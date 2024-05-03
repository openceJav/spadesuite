package org.opencejav.spadesuite.exceptions;

public class InvalidSessionException extends RuntimeException {
    public InvalidSessionException(final String message) {
        super(message);
    }

    public InvalidSessionException(final Throwable cause) {
        super(cause);
    }

    public InvalidSessionException(
            final String message,
            final Throwable cause) {
        super(message, cause);
    }
}
