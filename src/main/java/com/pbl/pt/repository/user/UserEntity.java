package com.pbl.pt.repository.user;

import com.pbl.pt.repository.BaseEntity;
import com.pbl.pt.repository.userGroup.UserGroupEntity;
import com.pbl.pt.service.userGroup.UserGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    private String userName;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String phone;

    private String meta;

    @ManyToMany
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private List<UserGroupMappingEntity> userGroupMappingEntities;
}
