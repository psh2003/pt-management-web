package com.pbl.pt.service.userGroup;

import com.pbl.pt.controller.admin.UserGroupRequest;
import com.pbl.pt.repository.packaze.PackageEntity;
import com.pbl.pt.repository.pass.BulkPassEntity;
import com.pbl.pt.repository.pass.BulkPassStatus;
import com.pbl.pt.repository.userGroup.UserGroupEntity;
import com.pbl.pt.repository.userGroup.UserGroupEntityRepository;
import com.pbl.pt.service.pass.BulkPassModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {
    private final UserGroupEntityRepository userGroupEntityRepository;

    public UserGroupService(UserGroupEntityRepository userGroupEntityRepository) {
        this.userGroupEntityRepository = userGroupEntityRepository;
    }

    public List<UserGroup> getAllUserGroups() {
        List<UserGroupEntity> userGroupEntity = userGroupEntityRepository.findUserGroup();
        return UserGroupModelMapper.INSTANCE.toUserGroup(userGroupEntity);
    }

    public void addGroup(UserGroupRequest userGroupRequest) {
        UserGroupEntity userGroupEntity = UserGroupModelMapper.INSTANCE.map(userGroupRequest);
        userGroupEntityRepository.save(userGroupEntity);
    }

    public List<UserGroup> getGroupByUserId(String id) {
        List<UserGroupEntity> userGroupEntities = userGroupEntityRepository.getUserGroupById(id);
        return UserGroupModelMapper.INSTANCE.toUserGroup(userGroupEntities);
    }
}
