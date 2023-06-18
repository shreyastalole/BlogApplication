package com.restproject.blog.blogApplicationApis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Requested Resource does not exist")
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;

    private long fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName, long fieldValue){
        super(String.format("%s not found for %s = %s ",resourceName,fieldName,fieldValue));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
    }

}
