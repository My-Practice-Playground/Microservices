package com.micro_services.employee_service.api;

import com.micro_services.employee_service.dto.EmployeeDto;
import com.micro_services.employee_service.entity.Employee;
import com.micro_services.employee_service.payload.StandardMessageResponse;
import com.micro_services.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: shan
 * Created: 2023-11-24 12.47
 */
@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @PostMapping("/save")
    public StandardMessageResponse saveEmployee(@RequestBody EmployeeDto employeeDto) {
        if (!employeeService.existsById(employeeDto.getId())) {
            return employeeService.saveEmployee(employeeDto) ? new StandardMessageResponse(null, 200, "Employee saved successfully") : new StandardMessageResponse(null, 200, "Employee save failed");
        }
        return new StandardMessageResponse(null, 200, "Employee already exists");
    }

    @PostMapping("/update")
    public StandardMessageResponse updateEmployee(@RequestBody EmployeeDto employeeDto) {
        if (employeeService.existsById(employeeDto.getId())) {
            return employeeService.updateEmployee(employeeDto) ? new StandardMessageResponse(null, 200, "Employee updated successfully") : new StandardMessageResponse(null, 200, "Employee update failed");
        }
        return new StandardMessageResponse(null, 200, "Employee does not exists");
    }

    @DeleteMapping("/delete/{id}")
    public StandardMessageResponse deleteEmployee(@PathVariable String id) {
        if (employeeService.existsById(id)) {
            return employeeService.deleteEmployee(id) ? new StandardMessageResponse(null, 200, "Employee deleted successfully") : new StandardMessageResponse(null, 200, "Employee delete failed");
        }
        return new StandardMessageResponse(null, 200, "Employee does not exists");
    }

    @GetMapping("/get/{id}")
    public StandardMessageResponse getEmployee(@PathVariable String id) {
        if (employeeService.existsById(id)) {
            return new StandardMessageResponse(employeeService.getEmployee(id), 200, "Employee retrieved successfully");
        }
        return new StandardMessageResponse(null, 400, "Employee does not exists");
    }


}
