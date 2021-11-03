package com.bsuir.ofeitus.archive.server.service;

/**
 * Class to catch Service exception.
 *
 * @author Ofeitus
 * @version 1.0
 */
public class ServerServiceException extends Exception {
    /**
     * Instantiates a new Service exception.
     */
    public ServerServiceException() {
        super();
    }

    /**
     * Instantiates a new Service exception with specific message
     *
     * @param message the message
     */
    public ServerServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Service exception with specific message and cause
     *
     * @param message the message
     * @param cause   the cause
     */
    public ServerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Service exception with specific cause
     *
     * @param cause the cause
     */
    public ServerServiceException(Throwable cause) {
        super(cause);
    }
}
