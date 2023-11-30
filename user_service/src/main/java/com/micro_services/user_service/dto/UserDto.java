package com.micro_services.user_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 2023-11-24 10.48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Valid

    @NotNull(message = "id cannot be null")
    @NotBlank(message = "id cannot be blank")
    private String id;

    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password cannot be blank")
    private String password;

    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "address cannot be null")
    @NotBlank(message = "address cannot be blank")
    private String address;

    private Integer age;
}
