package com.pbl.pt.controller.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserGroupRequest {
    private String userGroupName;
    private String userGroupId;
    private String userId;
}
