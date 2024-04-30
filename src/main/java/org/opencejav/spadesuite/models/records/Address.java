package org.opencejav.spadesuite.models.records;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.opencejav.spadesuite.utils.helpers.validator.Validator;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("all")
public record Address (
        String street,
        String city,
        String state,
        String zipCode,
        String country) implements Serializable  {

    public static class AddressBuilder {
        private String street;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        public AddressBuilder withStreet(final String street) {
            Objects.requireNonNull(street, "Street is Null.");

            this.street = street;
            return this;
        }

        public AddressBuilder withCity(final String city) {
            Objects.requireNonNull(city, "City is Null.");

            this.city = city;
            return this;
        }

        public AddressBuilder withState(final String state) {
            Objects.requireNonNull(state, "State is Null.");

            this.state = state;
            return this;
        }

        public AddressBuilder withZipCode(final String zipCode) {
            Objects.requireNonNull(zipCode, "ZipCode is Null.");

            this.zipCode = zipCode;
            return this;
        }

        public AddressBuilder withCountry(final String country) {
            Objects.requireNonNull(country, "Country is Null.");

            this.country = country;
            return this;
        }

        public Address build() {
            isAddressBuildValid();
            return new Address(
                    this.street,
                    this.city,
                    this.state,
                    this.zipCode,
                    this.country
            );
        }

        // TODO Check this Method for Validity (Refactor if Necessary)
        private void isAddressBuildValid() {
            Validator<AddressBuilder> validator = Validator.of(this);

            // FIXME Add More Rules for Address If Necessary
            var validAddress = validator
                    .addRule(a -> a.street != null && a.street.length() > 0, "Street Cannot be Null or Empty.")
                    .addRule(a -> a.city != null && a.city.length() > 0, "City Cannot be Null or Empty.")
                    .addRule(a -> a.state != null && a.state.length() > 0, "State Cannot be Null or Empty.")
                    .addRule(a -> a.zipCode != null && a.zipCode.length() > 0, "ZipCode Cannot be Null or Empty.")
                    .addRule(a -> a.country != null && a.country.length() > 0, "Country Cannot be Null or Empty.")
                    .getErrors();
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);

        return builder
                .append(this.street())
                .append(this.city())
                .append(this.state())
                .append(this.zipCode())
                .append(this.country())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Address address = (Address) obj;

        return this.street().equals(address.street()) &&
                this.city().equals(address.city()) &&
                this.state().equals(address.state()) &&
                this.zipCode().equals(address.zipCode()) &&
                this.country().equals(address.country());
    }

    @Override
    public String toString() {
        return String.format("""
                %s {
                    street: %s,
                    city: %s,
                    state: %s,
                    zipCode: %s,
                    country: %s
                }
                """,
                this.getClass().getSimpleName(), this.street(),
                this.city(), this.state(),
                this.zipCode(), this.country());
    }
}
