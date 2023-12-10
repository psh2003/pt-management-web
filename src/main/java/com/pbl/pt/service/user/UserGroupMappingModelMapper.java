package com.pbl.pt.service.user;

import com.pbl.pt.controller.admin.UserGroupRequest;
import com.pbl.pt.repository.user.UserGroupMappingEntity;
import com.pbl.pt.service.userGroup.UserGroupModelMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserGroupMappingModelMapper {
    UserGroupMappingModelMapper INSTANCE = Mappers.getMapper(UserGroupMappingModelMapper.class);

    UserGroupMappingEntity toUserGroupMapping(UserGroupRequest userGroupRequest);
}
