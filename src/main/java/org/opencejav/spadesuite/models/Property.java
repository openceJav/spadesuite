package org.opencejav.spadesuite.models;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.javatuples.Unit;
import org.opencejav.spadesuite.enums.PropertyType;
import org.opencejav.spadesuite.models.records.Address;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("all")
// TODO JavaDocify Property Class
public final class Property {
    private UUID id;
    private final String propertyName;
    private final PropertyOwner propertyOwner;
    private final Address address;
    private final PropertyType propertyType;
    private final List<Unit> availableUnits;
    private final List<Unit> rentedUnits;

    public Property(PropertyBuilder builder) {
        this.propertyName = builder.propertyName;
        this.propertyOwner = builder.propertyOwner;
        this.address = builder.address;
        this.propertyType = builder.propertyType;
        this.availableUnits = builder.availableUnits;
        this.rentedUnits = builder.rentedUnits;
    }

    //region Getters
    public UUID getId() {
        return id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public PropertyOwner getPropertyOwner() {
        return propertyOwner;
    }

    public Address getAddress() {
        return address;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public List<Unit> getAvailableUnits() {
        return availableUnits;
    }

    public List<Unit> getRentedUnits() {
        return rentedUnits;
    }
    //endregion

    public static class PropertyBuilder {
        private UUID id;
        private String propertyName;
        private PropertyOwner propertyOwner;
        private Address address;
        private PropertyType propertyType;
        private List<Unit> availableUnits;
        private List<Unit> rentedUnits;


        public PropertyBuilder withId() {
            this.id = UUID.randomUUID();
            return this;
        }

        public PropertyBuilder withPropertyName(String propertyName) {
            Objects.requireNonNull(propertyName, "Property Name is Required.");

            this.propertyName = propertyName;
            return this;
        }

        public PropertyBuilder withPropertyOwner(PropertyOwner propertyOwner) {
            Objects.requireNonNull(propertyOwner, "Property Owner is Required.");

            this.propertyOwner = propertyOwner;
            return this;
        }

        public PropertyBuilder withAddress(Address address) {
            Objects.requireNonNull(address, "Address is Required.");

            this.address = address;
            return this;
        }

        public PropertyBuilder withPropertyType(PropertyType propertyType) {
            Objects.requireNonNull(propertyType, "Property Type is Required.");

            this.propertyType = propertyType;
            return this;
        }

        public PropertyBuilder withAvailableUnits(List<Unit> availableUnits) {
            Objects.requireNonNull(availableUnits, "Available Units is Required.");

            this.availableUnits = availableUnits;
            return this;
        }

        public PropertyBuilder withRentedUnits(List<Unit> rentedUnits) {
            Objects.requireNonNull(rentedUnits, "Rented Units is Required.");

            this.rentedUnits = rentedUnits;
            return this;
        }

        public Property build() {
            return new Property(this);
        }

        // TODO Implement isValidPropertyBuild() Method
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);

        return builder
                .append(this.getPropertyName())
                .append(this.getPropertyOwner())
                .append(this.getAddress())
                .append(this.getPropertyType())
                .append(this.getAvailableUnits())
                .append(this.getRentedUnits())
                .toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Property property = (Property) obj;

        return this.getPropertyName().equals(property.getPropertyName()) &&
                this.getPropertyOwner().equals(property.getPropertyOwner()) &&
                this.getAddress().equals(property.getAddress()) &&
                this.getPropertyType().equals(property.getPropertyType()) &&
                this.getAvailableUnits().equals(property.getAvailableUnits()) &&
                this.getRentedUnits().equals(property.getRentedUnits());
    }

    @Override
    public String toString() {
        return String.format("""
                %s {
                    id: %s,
                    propertyName: %s,
                    propertyOwner: %s,
                    address: %s,
                    propertyType: %s,
                    availableUnits: %s,
                    rentedUnits: %s
                }
                """,
                this.getClass().getCanonicalName(), this.getId(),
                this.getPropertyName(), this.getPropertyOwner(),
                this.getAddress(), this.getPropertyType(),
                this.getAvailableUnits(), this.getRentedUnits());
    }
}
