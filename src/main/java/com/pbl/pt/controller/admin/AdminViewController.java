package com.pbl.pt.controller.admin;

import com.pbl.pt.repository.user.UserEntity;
import com.pbl.pt.repository.user.UserGroupMappingEntity;
import com.pbl.pt.service.packaze.PackageService;
import com.pbl.pt.service.pass.BulkPassService;
import com.pbl.pt.service.statistics.StatisticsService;
import com.pbl.pt.service.user.User;
import com.pbl.pt.service.user.UserGroupMappingService;
import com.pbl.pt.service.user.UserService;
import com.pbl.pt.service.userGroup.UserGroupService;
import com.pbl.pt.util.LocalDateTimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminViewController {
    private final BulkPassService bulkPassService;
    private final PackageService packageService;
    private final UserGroupMappingService userGroupMappingService;
    private final StatisticsService statisticsService;
    private final UserGroupService userGroupService;
    private final UserService userService;

    public AdminViewController(UserGroupService userGroupService, BulkPassService bulkPassService, PackageService packageService, UserGroupMappingService userGroupMappingService, StatisticsService statisticsService, UserService userService) {
        this.userGroupService = userGroupService;
        this.bulkPassService = bulkPassService;
        this.packageService = packageService;
        this.userGroupMappingService = userGroupMappingService;
        this.statisticsService = statisticsService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView home(ModelAndView modelAndView, @RequestParam(value = "to", required = false) String toString) {
        LocalDateTime to;
        if (ObjectUtils.isEmpty(toString)){
            to = LocalDateTime.now();
        } else {
            to = LocalDateTimeUtils.parseDate(toString);
        }
        modelAndView.addObject("chartData", statisticsService.makeChartData(to));
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @GetMapping("/bulk-pass")
    public ModelAndView registerBulkPass(ModelAndView modelAndView) {
        modelAndView.addObject("bulkPasses", bulkPassService.getAllBulkPasses());
        modelAndView.addObject("packages", packageService.getAllPackages());
        modelAndView.addObject("groupList", userGroupService.getAllUserGroups());
        modelAndView.addObject("request", new BulkPassRequest());
        modelAndView.setViewName("admin/bulk-pass");

        return modelAndView;
    }

    @PostMapping("/bulk-pass")
    public String addBulkPass(@Valid @ModelAttribute("request") BulkPassRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "admin/bulk-pass";
        }
        bulkPassService.addBulkPass(request);
        return "redirect:/admin/bulk-pass";
    }

    @GetMapping("/groups")
    public ModelAndView userGroup(ModelAndView modelAndView){
        modelAndView.addObject("groupList", userGroupService.getAllUserGroups());
        modelAndView.addObject("request", new UserGroupRequest());
        modelAndView.setViewName("admin/user-group");
        return modelAndView;
    }

    @PostMapping("/groups")
    public String addGroup(@ModelAttribute("request") UserGroupRequest userGroupRequest) {
        userGroupService.addGroup(userGroupRequest);
        return "redirect:/admin/groups";
    }

    @GetMapping("/users")
    public ModelAndView users(ModelAndView modelAndView){
        final List<User> user = userService.getUserList();
        modelAndView.addObject("userList", user);
        modelAndView.addObject("groupList", userGroupService.getAllUserGroups());
        modelAndView.addObject("request", new UserGroupRequest());
        modelAndView.addObject("userRequest", new User());
        modelAndView.setViewName("admin/user");
        return modelAndView;
    }

    @PostMapping("/get-groups")
    public ModelAndView getGroups(@RequestParam("id") String id, ModelAndView modelAndView) {
        modelAndView.addObject("groupList2", userGroupService.getGroupByUserId(id));
        modelAndView.setViewName("admin/user :: #dataTable2");
        return modelAndView;
    }

    @PostMapping("/add-user-group")
    public ModelAndView addUserGroup(@RequestBody UserGroupRequest userGroupRequest, ModelAndView modelAndView) {
        userGroupMappingService.insertUserGroup(userGroupRequest);
        modelAndView.addObject("groupList2", userGroupService.getGroupByUserId(userGroupRequest.getUserId()));
        modelAndView.setViewName("admin/user :: #dataTable2");
        return modelAndView;
    }

    @PostMapping("/add-user")
    public ModelAndView addUser(@Valid @ModelAttribute("request") User user, BindingResult bindingResult, ModelAndView modelAndView){
        modelAndView.setViewName("admin/user");
        if (bindingResult.hasErrors()){
            return modelAndView;
        }
        userService.addUser(user);
        final List<User> userList = userService.getUserList();
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("groupList", userGroupService.getAllUserGroups());
        modelAndView.addObject("request", new UserGroupRequest());
        modelAndView.addObject("userRequest", new User());
        return modelAndView;
    }
}
