package org.opencejav.spadesuite.exceptions;

public class StylesheetNotFoundException extends RuntimeException {
    public StylesheetNotFoundException(final String message) {
        super(message);
    }

    public StylesheetNotFoundException(final Throwable cause) {
        super(cause);
    }

    public StylesheetNotFoundException(
            final String message,
            final Throwable cause) {
        super(message, cause);
    }
}
