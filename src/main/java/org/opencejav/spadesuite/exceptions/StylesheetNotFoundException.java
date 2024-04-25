package org.opencejav.spadesuite.exceptions;

public class StylesheetNotFoundException extends RuntimeException {
    public StylesheetNotFoundException(String message) {
        super(message);
    }

    public StylesheetNotFoundException(Throwable cause) {
        super(cause);
    }

    public StylesheetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
