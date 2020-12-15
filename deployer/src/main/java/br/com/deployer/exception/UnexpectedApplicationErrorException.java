package br.com.deployer.exception;

public class UnexpectedApplicationErrorException extends RuntimeException {

	public UnexpectedApplicationErrorException(String message) {
		super(message);
	}

}
