package com.bsuir.ofeitus.archive.client.service;

/**
 * Class to catch Service exception.
 *
 * @author Ofeitus
 * @version 1.0
 */
public class ServiceException extends Exception {
    /**
     * Instantiates a new Service exception.
     */
    public ServiceException() {
        super();
    }

    /**
     * Instantiates a new Service exception with specific message
     *
     * @param message the message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Service exception with specific message and cause
     *
     * @param message the message
     * @param cause   the cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Service exception with specific cause
     *
     * @param cause the cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
