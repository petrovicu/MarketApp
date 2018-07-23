package com.klaymen.rest.transferobjects;

import java.io.Serializable;

/**

 * Created by petrovicu on 20/07/2018.
 * Generic Rest response object
 *
 * Sets flag success or error message
 * All other responses inherit this one
 */
public class RestResponseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;

    public RestResponseObject() {}

    public RestResponseObject(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

