package org.opencejav.spadesuite.models;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.tinylog.Logger;

import java.io.Serializable;
import java.util.Objects;

public final class Address implements Serializable  {
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;

    public Address(final AddressBuilder builder) {
        this.street = builder.street;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.country = builder.country;
    }

    //region Getters
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }
    //endregion

    public static class AddressBuilder {
        private String street;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        public AddressBuilder street(final String street) {
            Objects.requireNonNull(street, "Street is Null.");
            handleInvalidInput(street, "Street Provided is Null, Empty or Blank.");

            this.street = street;
            return this;
        }

        public AddressBuilder city(final String city) {
            Objects.requireNonNull(city, "City is Null.");
            handleInvalidInput(city, "City Provided is Null, Empty or Blank.");

            this.city = city;
            return this;
        }

        public AddressBuilder state(final String state) {
            Objects.requireNonNull(state, "State is Null.");
            handleInvalidInput(state, "State Provided is Null, Empty or Blank.");

            this.state = state;
            return this;
        }

        public AddressBuilder zipCode(final String zipCode) {
            Objects.requireNonNull(zipCode, "ZipCode is Null.");
            handleInvalidInput(zipCode, "ZipCode Provided is Null, Empty or Blank.");

            this.zipCode = zipCode;
            return this;
        }

        public AddressBuilder country(final String country) {
            Objects.requireNonNull(country, "Country is Null.");
            handleInvalidInput(country, "Country Provided is Null, Empty or Blank.");

            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

        private void handleInvalidInput(final String variable, final String message) {
            if (variable.isEmpty() || variable.isBlank()) {
                Logger.error(message);
                throw new IllegalArgumentException(message);
            }
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);

        return builder
                .append(this.getStreet())
                .append(this.getCity())
                .append(this.getState())
                .append(this.getZipCode())
                .append(this.getCountry())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Address address = (Address) obj;

        return this.getStreet().equals(address.getStreet()) &&
                this.getCity().equals(address.getCity()) &&
                this.getState().equals(address.getState()) &&
                this.getZipCode().equals(address.getZipCode()) &&
                this.getCountry().equals(address.getCountry());
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
                this.getClass().getSimpleName(), this.getStreet(),
                this.getCity(), this.getState(),
                this.getZipCode(), this.getCountry());
    }
}
