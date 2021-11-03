package com.bsuir.ofeitus.archive.bean;

import java.util.Map;

/**
 * Class that implements this interface is able to return it's fields in map:
 * Key - name of field, Value - value of field
 *
 * @author Ofeitus
 * @version 1.0
 */
public interface Parameterizable {
    /**
     * Method that returns object field in map:
     * Key - name of field, Value - value of field
     *
     * @return map of params
     */
    Map<String, String> getParams();
}
