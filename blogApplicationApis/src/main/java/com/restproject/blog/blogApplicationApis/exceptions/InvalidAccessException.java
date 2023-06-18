package com.restproject.blog.blogApplicationApis.exceptions;

public class InvalidAccessException extends RuntimeException{

    private String requestingResource;
    private String accessRequestedResource;
    private String requestedAction;
    private long requestingResourceId;
    private long accessRequestedResourceId;

    public InvalidAccessException(String requestingResource, String accessRequestedResource,String requestedAction, long requestingResourceId, long accessRequestedResourceId) {
        super(String.format("%s: %s made invalid request for, %s, %s: %s "
                ,requestingResource
                ,requestingResourceId
                ,requestedAction
                ,accessRequestedResource
                ,accessRequestedResourceId));
        this.requestingResource = requestingResource;
        this.accessRequestedResource = accessRequestedResource;
        this.requestedAction = requestedAction;
        this.requestingResourceId = requestingResourceId;
        this.accessRequestedResourceId = accessRequestedResourceId;
    }
}
