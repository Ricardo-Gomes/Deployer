package br.com.deployer.exception;

import java.util.Arrays;
import java.util.List;

public class ValidationException extends RuntimeException {

	private List<String> errors;

	public ValidationException(String error) {
		this.errors = Arrays.asList(error);
	}

	public ValidationException(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

}
