package com.micro_services.user_service.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Author: shan
 * Created: 2023-11-24 10.48
 */

@Data
@RequiredArgsConstructor
public class UserDto {
    private String id;
    private String password;
    private String name;
    private String address;
    private Integer age;
}
