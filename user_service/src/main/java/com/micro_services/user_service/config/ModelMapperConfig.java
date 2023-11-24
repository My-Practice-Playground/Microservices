package com.micro_services.user_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Author: shan
 * Created: 2023-11-24 10.35
 */
@Configurable
public class ModelMapperConfig {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
