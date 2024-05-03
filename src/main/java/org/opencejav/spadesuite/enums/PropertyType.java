package org.opencejav.spadesuite.enums;

import org.opencejav.spadesuite.exceptions.PropertyNotFoundException;

import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings("all")
// TODO JavaDocify PropertyType Enum
public enum PropertyType {
    COMMERCIAL("COMM"),
    RESIDENTIAL("RES"),
    INDUSTRIAL("IND"),
    AGRICULTURAL("AGR"),
    VACANT("VAC"),
    OTHER("OTH");

    private final String shortHand;

    PropertyType(final String shortHand) {
        this.shortHand = shortHand;
    }

    public Optional<PropertyType> getPropertyByShortHand(final String shortHand) {
        return Optional.ofNullable(Arrays.stream(PropertyType.values())
                .filter(property -> property.shortHand.equalsIgnoreCase(shortHand))
                .findFirst()
                .orElseThrow(() -> new PropertyNotFoundException("Property "))); // Throwing an Exception for Nullable?
    }

    //region Getters
    public String getShortHand() {
        return this.shortHand;
    }
    //endregion

    @Override
    public String toString() {
        return this.shortHand;
    }
}
