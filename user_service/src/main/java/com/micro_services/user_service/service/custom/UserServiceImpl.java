package com.micro_services.user_service.service.custom;

import com.micro_services.user_service.entity.User;
import com.micro_services.user_service.repo.UserRepository;
import com.micro_services.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: shan
 * Created: 2023-11-24 10.38
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsUserById(String id) {
        return userRepository.existsUserById(id);
    }

    @Override
    public boolean save(User user) {
        User save = userRepository.save(user);
        return save!=null;
    }
}
