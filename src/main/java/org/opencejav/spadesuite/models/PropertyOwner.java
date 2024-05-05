package org.opencejav.spadesuite.models;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.opencejav.spadesuite.utils.helpers.validator.Validator;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
// TODO JavaDocify PropertyOwner Class
public class PropertyOwner {
    private int ownerId;
    private String ownerName;
    private String ownerPhoneNumber;
    private Optional<String> ownerEmail;
    private Optional<List<Property>> ownedProperties;
    private int ownerAge;

    public PropertyOwner(PropertyOwnerBuilder builder) {
        this.ownerName = builder.ownerName;
        this.ownerPhoneNumber = builder.ownerPhoneNumber;
        this.ownerEmail = builder.ownerEmail;
        this.ownedProperties = builder.ownedProperties;
        this.ownerAge = builder.ownerAge;
    }

    public static class PropertyOwnerBuilder {
        //region DEFAULTS
        private static final String DEFAULT_OWNER_NAME = "Anonymous";

        private static final String DEFAULT_OWNER_PHONE_NUMBER = "(000)-000-0000";

        private static final Optional<String> DEFAULT_OWNER_EMAIL = Optional.empty();

        private static final Optional<List<Property>> DEFAULT_OWNED_PROPERTIES = Optional.empty();

        private static final int DEFAULT_OWNER_AGE = 0;
        //endregion

        private int ownerId;
        private String ownerName;
        private String ownerPhoneNumber;
        private Optional<String> ownerEmail;
        private Optional<List<Property>> ownedProperties;
        private int ownerAge;


        public PropertyOwnerBuilder() {
            this.ownerId = 0;
            this.ownerName = DEFAULT_OWNER_NAME;
            this.ownerPhoneNumber = DEFAULT_OWNER_PHONE_NUMBER;
            this.ownerEmail = DEFAULT_OWNER_EMAIL;
            this.ownedProperties = DEFAULT_OWNED_PROPERTIES;
            this.ownerAge = DEFAULT_OWNER_AGE;
        }

        public PropertyOwnerBuilder withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public PropertyOwnerBuilder withPhoneNumber(String ownerPhoneNumber) {
            this.ownerPhoneNumber = ownerPhoneNumber;
            return this;
        }

        public PropertyOwnerBuilder withOwnerEmail(Optional<String> ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }

        public PropertyOwnerBuilder withOwnedProperties(Optional<List<Property>> ownedProperties) {
            this.ownedProperties = ownedProperties;
            return this;
        }

        public PropertyOwnerBuilder withOwnerage(int ownerAge) {
            this.ownerAge = ownerAge;
            return this;
        }

        public PropertyOwner build() {
            isValidPropertyOwnerBuild();
            return new PropertyOwner(this);
        }

        private void isValidPropertyOwnerBuild() {
            Validator<PropertyOwnerBuilder> validator = Validator.of(this);

            validator
                    .addRule(propertyOwnerBuilder -> propertyOwnerBuilder.ownerName != null, "Owner Name cannot be null")
                    .addRule(propertyOwnerBuilder -> propertyOwnerBuilder.ownerPhoneNumber != null, "Owner Phone Number cannot be null")
                    .addRule(propertyOwnerBuilder -> propertyOwnerBuilder.ownerEmail.isPresent(), "Owner Email cannot be null")
                    .addRule(propertyOwnerBuilder -> propertyOwnerBuilder.ownedProperties.isPresent(), "Owned Properties cannot be null")
                    .addRule(propertyOwnerBuilder -> propertyOwnerBuilder.ownerAge > 0, "Owner Age must be greater than 0")
                    .getErrors();
        }
    }

    //region Getters
    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public Optional<String> getOwnerEmail() {
        return ownerEmail;
    }

    public Optional<List<Property>> getOwnedProperties() {
        return ownedProperties;
    }

    public int getOwnerAge() {
        return ownerAge;
    }
    //endregion

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);

        return builder
                .append(this.getOwnerName())
                .append(this.getOwnerPhoneNumber())
                .append(this.getOwnedProperties())
                .append(this.getOwnerEmail())
                .append(this.getOwnerAge())
                .toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        PropertyOwner propertyOwner = (PropertyOwner) obj;

        return this.getOwnerName().equals(propertyOwner.getOwnerName()) &&
                this.getOwnerPhoneNumber().equals(propertyOwner.getOwnerPhoneNumber()) &&
                this.getOwnedProperties().equals(propertyOwner.getOwnedProperties()) &&
                this.getOwnerEmail().equals(propertyOwner.getOwnerEmail()) &&
                this.getOwnerAge() == propertyOwner.getOwnerAge();
    }

    @Override
    public String toString() {
        return String.format("""
                %s {
                    ownerName: %s,
                    ownerPhoneNumber: %s,
                    ownerEmail: %s,
                    ownedProperties: %s,
                    ownerAge: %s
                }
                """,
                this.getClass().getCanonicalName(), this.getOwnerName(),
                this.getOwnerPhoneNumber(), this.getOwnerEmail(),
                this.getOwnedProperties(), this.getOwnerAge());
    }
}
