package org.opencejav.spadesuite.exceptions;

public class ModuleException extends Exception {
    public ModuleException(String message) {
        super(message);
    }

    public ModuleException(Throwable cause) {
        super(cause);
    }

    public ModuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
