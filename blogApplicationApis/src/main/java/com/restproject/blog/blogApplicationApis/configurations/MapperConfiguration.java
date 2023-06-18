package com.restproject.blog.blogApplicationApis.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper getModelMapperBean(){
        return new ModelMapper();
    }

}
