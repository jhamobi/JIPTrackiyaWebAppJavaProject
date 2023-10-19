package com.jhamobi.trackiya.client;

import java.io.Serializable;

public class ServerException extends Exception implements Serializable {
	private static final long serialVersionUID = 1L;

	public ServerException() {
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Throwable cause) {
		super(cause);
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}
}
