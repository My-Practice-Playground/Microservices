package com.micro_services.employee_service.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author: shan
 * Created: 2023-11-24 12.43
 */

@Data
@Document
public class Employee {
    private String id;
    private String name;
    private String email;
}
