package org.opencejav.spadesuite.models;

import org.opencejav.spadesuite.utils.helpers.validator.Validator;
import org.tinylog.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Tenant {
    private final UUID id;
    private final String name;
    private final Email email;
    private final Phone phone;
    private final Address address;
    private final Lease lease;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private Tenant(final TenantBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.lease = builder.lease;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static class TenantBuilder {
        private UUID id;
        private String name;
        private Email email;
        private Phone phone;
        private Address address;
        private Lease lease;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;

        public TenantBuilder() {
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        public TenantBuilder withId() {
            this.id = UUID.randomUUID();
            return this;
        }

        public TenantBuilder withName(String name) {
            Objects.requireNonNull(name, "Name Cannot be Null.");

            this.name = name;
            return this;
        }

        public TenantBuilder withEmail(Email email) {
            Objects.requireNonNull(email, "Email Cannot be Null.");

            this.email = email;
            return this;
        }

        public TenantBuilder withPhone(Phone phone) {
            Objects.requireNonNull(phone, "Phone Cannot be Null.");

            this.phone = phone;
            return this;
        }

        public TenantBuilder withAddress(Address address) {
            Objects.requireNonNull(address, "Address Cannot be Null.");

            this.address = address;
            return this;
        }

        public TenantBuilder withLease(Lease lease) {
            Objects.requireNonNull(lease, "Lease Cannot be Null.");

            this.lease = lease;
            return this;
        }

        public Tenant build() {
            Tenant tenant = isValidTenantBuild(this);

            if (tenant == null) {
                throw new IllegalArgumentException("Invalid Tenant Object.");
            }

            return tenant;
        }


        // TODO Fix This Method and Validator Utility Class
        private static Tenant isValidTenantBuild(TenantBuilder tenant) {
            Validator<Tenant> validator = new Validator<>();

            List<String> errors = validator
                    .addRule(t -> t.id != null, "Tenant ID is Required.")
                    .addRule(t -> t.name != null, "Tenant Name is Required.")
                    .addRule(t -> t.email != null, "Tenant Email is Required.")
                    .addRule(t -> t.phone != null, "Tenant Phone is Required.")
                    .addRule(t -> t.address != null, "Tenant Address is Required.")
                    .addRule(t -> t.lease != null, "Tenant Lease is Required.")
                    .validate(new Tenant(tenant));


            if (!(errors.isEmpty())) {
                errors.forEach(Logger::error);
                return null;
            }

            return new Tenant(tenant);
        }
    }
}
