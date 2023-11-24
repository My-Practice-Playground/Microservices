package com.micro_services.employee_service.repository;

import com.micro_services.employee_service.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

/**
 * Author: shan
 * Created: 2023-11-24 12.44
 */
@EnableMongoRepositories
@Repository
public interface EmployeeRepo extends MongoRepository<Employee,String> {
    boolean existsById(String id);
}
