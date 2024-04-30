package org.opencejav.spadesuite.models;

import org.opencejav.spadesuite.models.records.Address;
import org.opencejav.spadesuite.models.records.Email;
import org.opencejav.spadesuite.models.records.Lease;
import org.opencejav.spadesuite.models.records.Phone;
import org.opencejav.spadesuite.utils.helpers.validator.Validator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("all")
public final class Tenant {
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
        private static final String DEFAULT_NAME = "John Doe";

        private UUID id;
        private String name;
        private Email email;
        private Phone phone;
        private Address address;
        private Lease lease;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;

        public TenantBuilder() {
            this.name = DEFAULT_NAME;
            this.email = new Email.EmailBuilder().build();
            this.phone = new Phone.PhoneBuilder().build();
            this.address = new Address.AddressBuilder().build();
            this.lease = new Lease.LeaseBuilder().build();
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        public TenantBuilder withId() {
            this.id = UUID.randomUUID();
            return this;
        }

        public TenantBuilder withName(final String name) {
            Objects.requireNonNull(name, "Name Cannot be Null.");

            this.name = name;
            return this;
        }

        public TenantBuilder withEmail(final Email email) {
            Objects.requireNonNull(email, "Email Cannot be Null.");

            this.email = email;
            return this;
        }

        public TenantBuilder withPhone(final Phone phone) {
            Objects.requireNonNull(phone, "Phone Cannot be Null.");

            this.phone = phone;
            return this;
        }

        public TenantBuilder withAddress(final Address address) {
            Objects.requireNonNull(address, "Address Cannot be Null.");

            this.address = address;
            return this;
        }

        public TenantBuilder withLease(final Lease lease) {
            Objects.requireNonNull(lease, "Lease Cannot be Null.");

            this.lease = lease;
            return this;
        }

        public Tenant build() {
            isValidTenantBuild();
            return new Tenant(this);
        }

        // TODO Check this Method for Validity (Refactor if Necessary)
        private void isValidTenantBuild() {
            Validator<TenantBuilder> validator = Validator.of(this);

            // FIXME Add More Rules for Tenant If Necessary
            var tenantValid = validator
                    .addRule(t -> t.id != null, "Tenant ID is Required.")
                    .addRule(t -> t.name != null, "Tenant Name is Required.")
                    .addRule(t -> t.email != null, "Tenant Email is Required.")
                    .addRule(t -> t.phone != null, "Tenant Phone is Required.")
                    .addRule(t -> t.address != null, "Tenant Address is Required.")
                    .addRule(t -> t.lease != null, "Tenant Lease is Required.")
                    .getErrors();
        }
    }
}
