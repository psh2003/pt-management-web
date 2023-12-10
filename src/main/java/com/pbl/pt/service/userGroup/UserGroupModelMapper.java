package com.pbl.pt.service.userGroup;
import com.pbl.pt.controller.admin.UserGroupRequest;
import com.pbl.pt.repository.user.UserEntity;
import com.pbl.pt.repository.userGroup.UserGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserGroupModelMapper {
    UserGroupModelMapper INSTANCE = Mappers.getMapper(UserGroupModelMapper.class);
    List<UserGroup> toUserGroup(List<UserGroupEntity> userGroupEntity);

    UserGroupEntity map(UserGroupRequest userGroupRequest);
}
