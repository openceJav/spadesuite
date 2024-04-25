package org.opencejav.spadesuite.utils.common;

import org.opencejav.spadesuite.annotations.UtilityClass;

@UtilityClass(className = "Range")
@SuppressWarnings("all")
public final class Range {
    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 100;
    private final int min;
    private final int max;

    /**
     * Constructor for the Range Class, sets the MIN_RANGE and MAX_RANGE.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     */
    public Range(final int min, final int max) {
        this.min = checkMin(min);
        this.max = checkMax(max);
    }

    /**
     * Checks if the minimum value is a valid integer and value to set.
     * @param min The minimum value to check.
     * @return The minimum value if it is valid, else the default minimum value.
     */
    private int checkMin(final int min) {
        if (min < 0) return DEFAULT_MIN;
        if (min > this.max) return this.max - 1;
        return min;
    }

    /**
     * Checks if the maximum value is a valid integer and value to set.
     * @param max The maximum value to check.
     * @return The maximum value if it is valid, else the default maximum value.
     */
    private int checkMax(final int max) {
        if (max < 0) return DEFAULT_MAX;
        if (max < this.min) return this.min + 1;
        return max;
    }

    /**
     * Checks if the value provided is within the MIN_RANGE and MAX_RANGE.
     * @param value The value to check.
     * @return True if the value is within the range, false otherwise.
     */
    public boolean contains(final int value) {
        return (value >= this.min && value <= this.max);
    }

    /**
     * Checks if the value provided is within the min and max range.
     * @param value The value fo check.
     * @param min The minimum threshold to check for.
     * @param max The maximum threshold to check for.
     * @return Ture if the value is within the min and max range, false otherwise.
     */
    public static boolean contains(final int value, final int min, final int max) {
        return (value >= min && value <= max);
    }
}
