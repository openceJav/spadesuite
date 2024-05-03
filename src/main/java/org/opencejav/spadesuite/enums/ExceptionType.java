package org.opencejav.spadesuite.enums;

import org.opencejav.spadesuite.exceptions.ExceptionTypeNotFoundException;

import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings("all")
// TODO JavaDocify ExceptionType Enum
public enum ExceptionType {
    INV_FILE_PATH("INV_FP", "Invalid File Path."),
    INV_FILE_TYPE("INV_FT", "Invalid File Type."),
    INV_FILE_FORMAT("INV_FF", "Invalid File Format."),
    INV_FILE_CONTENT("INV_FC", "Invalid File Content."),
    INV_FILE_NAME("INV_FN", "Invalid File Name."),

    INV_SESSION_TIMEOUT("INV_SESH_T", "Invalid Session Timeout."),
    INV_CONNECTION_TIMEOUT("INV_CONN_T", "Invalid Connection Timeout."),
    INV_POOL_SIZE("INV_POOL", "Invalid Pool Size."),
    INV_DETECTION_THRESHOLD("INV_DETE_T", "Invalid Detection Threshold.");

    private final String shortHand;
    private final String desc;

    ExceptionType(final String shortHand, final String desc) {
        this.shortHand = shortHand;
        this.desc = desc;
    }

    public static Optional<ExceptionType> getExceptionByShortHand(final String shortHand)
            throws ExceptionTypeNotFoundException {
        return Optional.ofNullable(Arrays.stream(ExceptionType.values())
                .filter(exception -> exception.shortHand.equalsIgnoreCase(shortHand))
                .findFirst()
                .orElseThrow(() -> new ExceptionTypeNotFoundException("No Such Exception Found."))); // Throwing an Exception for Nullable?
    }

    //region Getters
    public String getShortHand() {
        return shortHand;
    }

    public String getDesc() {
        return desc;
    }
    //endregion

    @Override
    public String toString() {
        return "%s, %s".formatted(this.shortHand, this.desc);
    }
}
