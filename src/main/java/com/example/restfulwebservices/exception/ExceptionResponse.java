package com.example.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String mesage;
    private String details;
    private String status;

    public ExceptionResponse(Date timestamp, String mesage, String details, String status) {
        this.timestamp = timestamp;
        this.mesage = mesage;
        this.details = details;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMesage() {
        return mesage;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ExceptionResponse [mesage=" + mesage + ", details=" + details + ", status=" + status + ", timestamp=" + timestamp + "]";
    }

    
    
    
}
