package com.micro_services.employee_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: shan
 * Created: 2023-11-24 21.45
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    ModelMapper ModelMapper() {
        return new ModelMapper();
    }
}
