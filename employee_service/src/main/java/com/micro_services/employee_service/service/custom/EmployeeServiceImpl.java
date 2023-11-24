package com.micro_services.employee_service.service.custom;

import com.micro_services.employee_service.dto.EmployeeDto;
import com.micro_services.employee_service.entity.Employee;
import com.micro_services.employee_service.repository.EmployeeRepo;
import com.micro_services.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Author: shan
 * Created: 2023-11-24 12.46
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    @Override
    public boolean existsById(String id) {
        return employeeRepo.existsById(id);
    }

    @Override
    public boolean saveEmployee(EmployeeDto employeeDto) {
        return employeeRepo.save(modelMapper.map(employeeDto, Employee.class)) != null;
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {
        return false;
    }

    @Override
    public EmployeeDto getEmployee(String id) {
        return null;
    }
}
