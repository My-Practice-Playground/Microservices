package com.micro_services.employee_service.service.custom;

import com.micro_services.employee_service.dto.EmployeeDto;
import com.micro_services.employee_service.entity.Employee;
import com.micro_services.employee_service.repository.EmployeeRepo;
import com.micro_services.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
       return employeeRepo.save(modelMapper.map(employeeDto, Employee.class))!=null;
    }

    @Override
    public boolean deleteEmployee(String id) {
        employeeRepo.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDto getEmployee(String id) {
        Optional<Employee> employeeOptional =
                employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            return modelMapper.map(employeeOptional.get(), EmployeeDto.class);
        }
        throw new RuntimeException("Employee not found");
    }
}
