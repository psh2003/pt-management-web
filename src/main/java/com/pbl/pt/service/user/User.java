package com.pbl.pt.service.user;

import com.pbl.pt.repository.user.UserStatus;
import com.pbl.pt.repository.userGroup.UserGroupEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class User {
    private String userId;
    @NotBlank(message = "이름은 필수입력입니다.")
    private String userName;
    private UserStatus status;
    private String userGroupName;
    private String userGroupId;
    private List<UserGroupEntity> userGroupEntity;
}
