package com.pbl.pt.service.user;

import com.pbl.pt.repository.user.UserEntity;
import com.pbl.pt.repository.user.UserGroupMappingEntity;
import com.pbl.pt.repository.user.UserGroupMappingRepository;
import com.pbl.pt.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(final String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        return UserModelMapper.INSTANCE.toUser(userEntity);

    }

    public List<User> getUserList() {
        List<UserEntity> userEntities = userRepository.getUserList();
        return UserModelMapper.INSTANCE.toUserList(userEntities);
    }

    public void addUser(User user) {
        UserEntity userEntity = UserModelMapper.INSTANCE.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
