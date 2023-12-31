package com.pbl.pt.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserId(String userId);

    @Query("select u " +
            "from UserEntity u")
    List<UserEntity> getUserList();
}
