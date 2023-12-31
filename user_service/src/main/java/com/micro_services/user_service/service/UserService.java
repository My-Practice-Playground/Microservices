package com.micro_services.user_service.service;

import com.micro_services.user_service.dto.UserDto;
import com.micro_services.user_service.entity.User;
import org.springframework.stereotype.Service;

/**
 * Author: shan
 * Created: 2023-11-24 10.38
 */

public interface UserService {
    boolean existsUserById(String id);
    boolean save(User user);
    UserDto getUserById(String id);
    boolean updateUser(UserDto userDto);
    boolean deleteUserById(String id);
}
