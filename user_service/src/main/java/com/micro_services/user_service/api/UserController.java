package com.micro_services.user_service.api;

import com.micro_services.user_service.dto.UserDto;
import com.micro_services.user_service.entity.User;
import com.micro_services.user_service.payloads.response.StandardMessageResponse;
import com.micro_services.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public StandardMessageResponse post(@Valid @RequestBody UserDto userDto) {
        if (!userService.existsUserById(userDto.getId())) {
            userService.save(modelMapper.map(userDto, User.class));
            return new StandardMessageResponse(null, 201, "User saved successfully!");
        }
        return new StandardMessageResponse(null, 400, "User already exists!");
    }

    @GetMapping("/get")
    public StandardMessageResponse get(@RequestParam String id) {
        if (userService.existsUserById(id))
            return new StandardMessageResponse(userService.getUserById(id), 200, "User fetched successfully!");
        return new StandardMessageResponse(null, 400, "User does not exist!");
    }

    @PatchMapping("/update")
    public StandardMessageResponse update(@RequestBody UserDto userDto) {
        if (userService.existsUserById(userDto.getId())) {
            userService.save(modelMapper.map(userDto, User.class));
            return new StandardMessageResponse(userDto, 200, "User updated successfully!");
        }
        return new StandardMessageResponse(null, 400, "User does not exist!");
    }

    @DeleteMapping("/delete")
    public StandardMessageResponse delete(@RequestParam String id) {
        if (userService.existsUserById(id)) {
            userService.deleteUserById(id);
            return new StandardMessageResponse(null, 200, "User deleted successfully!");
        }
        return new StandardMessageResponse(null, 400, "User does not exist!");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException e){
        Map<String,String>errors = new HashMap<>();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(
                        error->{
                            String fieldName = error.getField();
                            String message = error.getDefaultMessage();
                            errors.put(fieldName,message);
                        }
                );
        return errors;
    }
}
