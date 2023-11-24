package com.micro_services.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Author: shan
 * Created: 2023-11-24 10.33
 */
@Entity
@Data
public class User {
    @Id
    private String id;
    private String password;
    private String name;
    private String address;
    private Integer age;
}
