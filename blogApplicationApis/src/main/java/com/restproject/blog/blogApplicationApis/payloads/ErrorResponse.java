package com.restproject.blog.blogApplicationApis.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int responseStatus;
    private Date timeStamp;
    private String message;
    private String description;

}
