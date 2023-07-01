package com.poc_swagger3_security.exception;

public class NotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not Found Exception";

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
