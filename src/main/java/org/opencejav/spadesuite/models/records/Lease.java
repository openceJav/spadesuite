package org.opencejav.spadesuite.models.records;

import org.opencejav.spadesuite.utils.helpers.validator.Validator;

import java.io.Serializable;
import java.util.Objects;


@SuppressWarnings("all")
// TODO JavaDocify Lease Class
public record Lease(
        String tenantName,
        int unitNumber,
        double rent,
        double terms) implements Serializable {
    public static class LeaseBuilder {
        //region DEFAULTS
        private static final String DEFAULT_TENANT_NAME = "Change Me.";

        private static final int DEFAULT_UNIT_NUMBER = 0;

        private static final double DEFAULT_RENT = 0.0;

        private static final double DEFAULT_TERMS = 0.0;
        //endregion

        private String tenantName;
        private int unitNumber;
        private double rent;
        private double terms;

        public LeaseBuilder() {
            this.tenantName = DEFAULT_TENANT_NAME;
            this.unitNumber = DEFAULT_UNIT_NUMBER;
            this.rent = DEFAULT_RENT;
            this.terms = DEFAULT_TERMS;
        }

        public LeaseBuilder withTenantName(final String tenantName) {
            Objects.requireNonNull(tenantName, "Tenant Name Cannot be Null.");

            this.tenantName = tenantName;
            return this;
        }

        public LeaseBuilder withUnitNumber(final int unitNumber) {
            Objects.requireNonNull(unitNumber, "Unit Number Cannot be Null.");

            this.unitNumber = unitNumber;
            return this;
        }

        public LeaseBuilder withRent(final double rent) {
            Objects.requireNonNull(rent, "Rent Cannot be Null.");

            this.rent = rent;
            return this;
        }

        public LeaseBuilder withTerms(final double terms) {
            Objects.requireNonNull(terms, "Terms Cannot be Null.");

            this.terms = terms;
            return this;
        }

        public Lease build() {
            isValidLeaseBuild();
            return new Lease(this.tenantName, this.unitNumber, this.rent, this.terms);
        }

        // TODO Check this Method for Validity (Refactor if Necessary)
        public void isValidLeaseBuild() {
            Validator<LeaseBuilder> validator = Validator.of(this);

            // FIXME Add More Rules to Lease If Needed
            var leaseValid = validator
                    .addRule(l -> l.tenantName != null && l.tenantName.length() > 0, "Tenant Name Cannot be Null or Empty.")
                    .addRule(l -> l.unitNumber > 0, "Unit Number Must be Greater than 0.")
                    .addRule(l -> l.rent > 0, "Rent Must be Greater than 0.")
                    .addRule(l -> l.terms > 0, "Terms Must be Greater than 0.")
                    .addRegexRule(l -> l.tenantName, "^[a-zA-Z0-9]*$", "Tenant Name Must be Alphanumeric.")
                    .getErrors();
        }
    }
}