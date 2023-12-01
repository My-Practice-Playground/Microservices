package com.micro_services.employee_service.api;

import com.micro_services.employee_service.dto.EmployeeDto;
import com.micro_services.employee_service.dto.UserDto;
import com.micro_services.employee_service.payload.StandardMessageResponse;
import com.micro_services.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
        return new StandardMessageResponse("saved", 200, "Employee already exists");
    }

    @PatchMapping("/update")
    public StandardMessageResponse updateEmployee(@RequestBody EmployeeDto employeeDto) {
        if (employeeService.existsById(employeeDto.getId())) {
            return employeeService.updateEmployee(employeeDto) ? new StandardMessageResponse(null, 200, "Employee updated successfully") : new StandardMessageResponse(null, 200, "Employee update failed");
        }
        return new StandardMessageResponse(null, 404, "Employee does not exists");
    }

    @DeleteMapping("/delete/{id}")
    public StandardMessageResponse deleteEmployee(@PathVariable String id) {
        if (employeeService.existsById(id)) {
            return employeeService.deleteEmployee(id) ? new StandardMessageResponse(id, 200, "Employee deleted successfully") : new StandardMessageResponse(id, 200, "Employee delete failed");
        }
        return new StandardMessageResponse(null, 404, "Employee does not exists");
    }

    @GetMapping("/get/{id}")
    public StandardMessageResponse getEmployee(@PathVariable String id) {
        if (employeeService.existsById(id)) {
            return new StandardMessageResponse(employeeService.getEmployee(id), 200, "Employee retrieved successfully");
        }
        return new StandardMessageResponse(null, 404, "Employee does not exists");
    }

    @GetMapping("/get/user/{id}")
    public StandardMessageResponse getUser(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        StandardMessageResponse forObject = restTemplate.getForObject(
                "http://localhost:8070/api/v1/user/get?id=" + id,
                StandardMessageResponse.class
        );
        if (forObject != null) {
            return forObject.getStatus() == 200
                    ? new StandardMessageResponse(forObject.getData(), 200, "User retrieved successfully")
                    : new StandardMessageResponse(null, 404, "User does not exists");
        }
        return new StandardMessageResponse(null, 404, "Request failed");
    }

    @PostMapping("/post/user")
    public StandardMessageResponse postUser(@RequestBody UserDto employeeDto) {
        RestTemplate restTemplate = new RestTemplate();
        StandardMessageResponse forObject = restTemplate.postForObject(
                "http://localhost:8070/api/v1/user/post",
                employeeDto,
                StandardMessageResponse.class
        );
        if (forObject != null) {
            return forObject.getStatus() == 201
                    ? new StandardMessageResponse(forObject.getData(), 200, "User saved successfully")
                    : new StandardMessageResponse(null, 404, "User save failed");
        }
        return new StandardMessageResponse(null, 404, "Request failed");
    }

}
