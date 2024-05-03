package org.opencejav.spadesuite.exceptions;

public class InvalidFilePathException extends RuntimeException {
    public InvalidFilePathException(final String message) {
        super(message);
    }

    public InvalidFilePathException(final Throwable cause) {
        super(cause);
    }

    public InvalidFilePathException(
            final String message,
            final Throwable cause) {
        super(message, cause);
    }
}
