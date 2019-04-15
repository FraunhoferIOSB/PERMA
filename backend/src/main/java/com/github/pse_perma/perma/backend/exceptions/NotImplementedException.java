package com.github.pse_perma.perma.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class NotImplementedException extends RuntimeException {

	public NotImplementedException() {
		super();
	}

	public NotImplementedException(String message) {
		super(message);
	}

	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotImplementedException(Throwable cause) {
		super(cause);
	}

	protected NotImplementedException(String message, Throwable cause, boolean enableSuppression,
	                                  boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
