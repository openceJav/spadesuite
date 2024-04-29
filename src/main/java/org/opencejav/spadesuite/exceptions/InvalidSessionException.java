package org.opencejav.spadesuite.exceptions;

public class InvalidSessionException extends RuntimeException {
    public InvalidSessionException(String message) {
        super(message);
    }

    public InvalidSessionException(Throwable cause) {
        super(cause);
    }

    public InvalidSessionException(String message, Throwable cause) {
        super(message, cause);
    }
}
