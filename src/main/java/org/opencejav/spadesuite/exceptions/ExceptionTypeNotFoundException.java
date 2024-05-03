package org.opencejav.spadesuite.exceptions;

public class ExceptionTypeNotFoundException extends Exception {
    public ExceptionTypeNotFoundException(final String message) {
        super(message);
    }

    public ExceptionTypeNotFoundException(final Throwable cause) {
        super(cause);
    }

    public ExceptionTypeNotFoundException(
            final String message,
            final Throwable cause) {
        super(message, cause);
    }
}
