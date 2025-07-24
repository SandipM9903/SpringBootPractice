package com.sandip.rest.webservices.rest_web_services.Exceptions;

import java.time.LocalDate;

public class ErrorDetails {
    //First timestamp
    private LocalDate timeStamp;
    //Second message
    private String message;
    //Third errorDetails
    private String errorDetails;

    public ErrorDetails(LocalDate timeStamp, String message, String errorDetails) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }
}
