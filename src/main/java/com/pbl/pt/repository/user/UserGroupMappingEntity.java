package com.pbl.pt.repository.user;

import com.pbl.pt.repository.BaseEntity;
import com.pbl.pt.repository.userGroup.UserGroupEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_group_mapping")
@IdClass(UserGroupMappingId.class)
public class UserGroupMappingEntity extends BaseEntity {
    @Id
    private String userGroupId;
    @Id
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userGroupId", insertable = false, updatable = false)
    private UserGroupEntity userGroupEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private UserEntity userEntity;

}
