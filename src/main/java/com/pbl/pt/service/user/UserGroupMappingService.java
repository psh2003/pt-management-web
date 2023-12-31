package com.pbl.pt.service.user;

import com.pbl.pt.controller.admin.UserGroupRequest;
import com.pbl.pt.repository.user.UserGroupMappingEntity;
import com.pbl.pt.repository.user.UserGroupMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupMappingService {
    private final UserGroupMappingRepository userGroupMappingRepository;

    public UserGroupMappingService(UserGroupMappingRepository userGroupMappingRepository) {
        this.userGroupMappingRepository = userGroupMappingRepository;
    }

    public List<String> getAllUserGroupIds() {
        return userGroupMappingRepository.findDistinctUserGroupId();

    }

    public void insertUserGroup(UserGroupRequest userGroupRequest) {
        UserGroupMappingEntity userGroupMappingEntity = UserGroupMappingModelMapper.INSTANCE.toUserGroupMapping(userGroupRequest);
        userGroupMappingRepository.save(userGroupMappingEntity);
    }
}

