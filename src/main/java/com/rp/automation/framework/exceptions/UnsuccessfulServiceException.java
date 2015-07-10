package com.rp.automation.framework.exceptions;

@SuppressWarnings("serial")
public class UnsuccessfulServiceException extends RuntimeException {

    public UnsuccessfulServiceException(String message, Exception cause) {

        super(
                message
                        + " kindly refer attached screen shot for more clarification \n\n Stack Trace::\n",
                cause);
    }

    public UnsuccessfulServiceException() {
        super("Service  Failed"
                + " kindly refer attached screen shot for more clarification");
    }

}
