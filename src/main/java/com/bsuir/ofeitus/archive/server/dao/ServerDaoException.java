package com.bsuir.ofeitus.archive.server.dao;

/**
 * Class to catch Dao exception.
 *
 * @author Ofeitus
 * @version 1.0
 */
public class ServerDaoException extends Exception {
    /**
     * Instantiates a new Dao exception.
     */
    public ServerDaoException() {
        super();
    }

    /**
     * Instantiates a new Dao exception with specific message
     *
     * @param message the message
     */
    public ServerDaoException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Dao exception with specific message and cause
     *
     * @param message the message
     * @param cause   the cause
     */
    public ServerDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Dao exception with specific cause
     *
     * @param cause the cause
     */
    public ServerDaoException(Throwable cause) {
        super(cause);
    }
}