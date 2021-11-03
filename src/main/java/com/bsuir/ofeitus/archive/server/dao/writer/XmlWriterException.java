package com.bsuir.ofeitus.archive.server.dao.writer;

/**
 * Class to catch Xml writer exception.
 *
 * @author Ofeitus
 * @version 1.0
 */
public class XmlWriterException extends Exception{
    /**
     * Instantiates a new Xml writer exception.
     */
    public XmlWriterException() {
        super();
    }

    /**
     * Instantiates a new Xml writer exception with specific message
     *
     * @param message the message
     */
    public XmlWriterException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Xml writer exception with specific message and cause
     *
     * @param message the message
     * @param cause   the cause
     */
    public XmlWriterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Xml writer exception with specific cause
     *
     * @param cause the cause
     */
    public XmlWriterException(Throwable cause) {
        super(cause);
    }
}
