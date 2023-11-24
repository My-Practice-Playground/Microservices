package com.micro_services.employee_service.service;

import com.micro_services.employee_service.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;

/**
 * Author: shan
 * Created: 2023-11-24 12.45
 */
public interface EmployeeService {
    boolean existsById(String id);
    boolean saveEmployee(EmployeeDto employeeDto);
    boolean updateEmployee(EmployeeDto employeeDto);
    boolean deleteEmployee(String id);
    EmployeeDto getEmployee(String id);
}
