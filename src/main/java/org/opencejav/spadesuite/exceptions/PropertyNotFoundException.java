package org.opencejav.spadesuite.exceptions;

public class PropertyNotFoundException extends RuntimeException {
    public PropertyNotFoundException(final String message) {
        super(message);
    }

    public PropertyNotFoundException(final Throwable cause) {
        super(cause);
    }

    public PropertyNotFoundException(
            final String message,
            final Throwable cause) {
        super(message, cause);
    }
}
