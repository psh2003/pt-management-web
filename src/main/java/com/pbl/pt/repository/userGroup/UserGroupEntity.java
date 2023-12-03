package com.pbl.pt.repository.userGroup;

import com.pbl.pt.repository.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_group")
public class UserGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userGroupId;
    private String userGroupName;
}
