package com.bsuir.ofeitus.archive.server.dao.parser;

/**
 * Class to catch Xml parser exception.
 *
 * @author Ofeitus
 * @version 1.0
 */
public class XmlParserException extends Exception{
    /**
     * Instantiates a new Xml parser exception.
     */
    public XmlParserException() {
        super();
    }

    /**
     * Instantiates a new Xml parser exception with specific message
     *
     * @param message the message
     */
    public XmlParserException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Xml parser exception with specific message and cause
     *
     * @param message the message
     * @param cause   the cause
     */
    public XmlParserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Xml parser exception with specific cause
     *
     * @param cause the cause
     */
    public XmlParserException(Throwable cause) {
        super(cause);
    }
}
