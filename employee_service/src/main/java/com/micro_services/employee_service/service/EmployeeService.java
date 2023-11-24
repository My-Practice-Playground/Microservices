package com.micro_services.employee_service.service;

import lombok.RequiredArgsConstructor;

/**
 * Author: shan
 * Created: 2023-11-24 12.45
 */
public interface EmployeeService {
    boolean existsById(String id);

}
