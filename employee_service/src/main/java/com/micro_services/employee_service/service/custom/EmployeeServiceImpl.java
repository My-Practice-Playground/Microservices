package com.micro_services.employee_service.service.custom;

import com.micro_services.employee_service.repository.EmployeeRepo;
import com.micro_services.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author: shan
 * Created: 2023-11-24 12.46
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Override
    public boolean existsById(String id) {
        return employeeRepo.existsById(id);
    }
}
