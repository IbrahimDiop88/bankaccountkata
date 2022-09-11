package com.bankaccountkata.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8639285375656815335L;

	public ResourceNotFoundException(String message) {
        super(message);
    }

}
