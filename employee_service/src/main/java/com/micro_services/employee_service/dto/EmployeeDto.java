package com.micro_services.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 2023-11-24 21.44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String id;
    private String name;
    private String email;
}
