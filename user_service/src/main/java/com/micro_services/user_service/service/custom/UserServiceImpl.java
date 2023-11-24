package com.micro_services.user_service.service.custom;

import com.micro_services.user_service.dto.UserDto;
import com.micro_services.user_service.entity.User;
import com.micro_services.user_service.repo.UserRepository;
import com.micro_services.user_service.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Author: shan
 * Created: 2023-11-24 10.38
 */
@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsUserById(String id) {
        return userRepository.existsUserById(id);
    }

    @Override
    public boolean save(User user) {
        User save = userRepository.save(user);
        return save != null;
    }

    @Override
    public UserDto getUserById(String id) {
        User userById = userRepository.findUserById(id);
        return modelMapper.map(userById, UserDto.class);
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        User save = userRepository.save(modelMapper.map(userDto, User.class));
        return save != null;
    }

    @Override
    public boolean deleteUserById(String id) {
       userRepository.deleteById(id);
       return true;
    }
}
