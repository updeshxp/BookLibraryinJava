package io.github.updeshxp.project.restsrv.exception;

import java.time.Instant;
import java.util.Map;

public class ApiErrorResponse {

	private final Instant timestamp;
	private final int status;
	private final String error;
	private final String message;
	private final String path;
	private final Map<String, String> validationErrors;

	public ApiErrorResponse(int status, String error, String message, String path, Map<String, String> validationErrors) {
		this.timestamp = Instant.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.validationErrors = validationErrors;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}
}
