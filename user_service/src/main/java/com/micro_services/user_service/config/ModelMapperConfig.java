package com.micro_services.user_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: shan
 * Created: 2023-11-24 10.35
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    ModelMapper ModelMapper() {
        return new ModelMapper();
    }
}
