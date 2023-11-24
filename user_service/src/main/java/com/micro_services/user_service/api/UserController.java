package com.micro_services.user_service.api;

import com.micro_services.user_service.dto.UserDto;
import com.micro_services.user_service.entity.User;
import com.micro_services.user_service.payloads.response.StandardMessageResponse;
import com.micro_services.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: shan
 * Created: 2023-11-24 10.37
 */
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/post")
    public StandardMessageResponse post(@RequestBody UserDto userDto) {
        if (!userService.existsUserById(userDto.getId())) {
            userService.save(modelMapper.map(userDto, User.class));
            return new StandardMessageResponse(null,201, "User saved successfully!");
        }
        return new StandardMessageResponse(null, 400, "User already exists!");
    }
}
