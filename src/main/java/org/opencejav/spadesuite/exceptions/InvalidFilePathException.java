package org.opencejav.spadesuite.exceptions;

public class InvalidFilePathException extends RuntimeException {
    public InvalidFilePathException(String message) {
        super(message);
    }

    public InvalidFilePathException(Throwable cause) {
        super(cause);
    }

    public InvalidFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
