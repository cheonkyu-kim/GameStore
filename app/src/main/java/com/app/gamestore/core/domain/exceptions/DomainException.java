package com.app.gamestore.core.domain.exceptions;

public abstract class DomainException extends RuntimeException {

    private ErrorCode code;

    public DomainException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }
}