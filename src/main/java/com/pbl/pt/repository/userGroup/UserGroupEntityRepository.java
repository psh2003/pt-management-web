package com.pbl.pt.repository.userGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupEntityRepository extends JpaRepository<UserGroupEntity, Integer> {
    @Query("select ug " +
            "from UserGroupEntity ug " +
            "order by ug.userGroupId")
    List<UserGroupEntity> findUserGroup();

    @Query("select ug " +
            "from UserGroupMappingEntity ugme " +
            "left join UserGroupEntity ug " +
            "on ug.userGroupId = ugme.userGroupId " +
            "where ugme.userId = :id " +
            "order by ug.userGroupId")
    List<UserGroupEntity> getUserGroupById(String id);
}
