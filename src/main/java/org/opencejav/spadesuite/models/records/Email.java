package org.opencejav.spadesuite.models.records;

import org.opencejav.spadesuite.utils.helpers.validator.Validator;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("all")
// TODO JavaDocify Email Class
public record Email(
        String email,
        boolean isVerified) implements Serializable {
    public static class EmailBuilder {
        //region DEFAULTS
        private static final String DEFAULT_EMAIL = "change.me@gmail.com";

        private static final boolean DEFAULT_VERIFIED = false;
        //endregion

        private String email;
        private boolean isVerified;

        public EmailBuilder() {
            this.email = DEFAULT_EMAIL;
            this.isVerified = DEFAULT_VERIFIED;
        }

        public EmailBuilder withEmail(final String email) {
            Objects.requireNonNull(email, "Email Cannot be Null.");

            this.email = email;
            return this;
        }

        public EmailBuilder withVerified(final boolean isVerified) {
            Objects.requireNonNull(isVerified, "Verified Cannot be Null."); // Is this Necessary?

            this.isVerified = isVerified;
            return this;
        }

        public Email build() {
            isValidEmailBuild();
            return new Email(this.email, this.isVerified);
        }

        // TODO Check this Method for Validity (Refactor if Necessary)
        private void isValidEmailBuild() {
            Validator<EmailBuilder> validator = Validator.of(this);

            // FIXME Add More Rules for Email If Needed
            var emailValid = validator
                    .addRule(e -> e.email != null && e.email.length() > 0, "Email Cannot be Null or Empty.")
                    .addRule(e -> e.email.contains("@"), "Email Must Contain '@' Symbol.")
                    .addRule(e -> e.email.contains("."), "Email Must Contain '.' Symbol.")
                    .addRule(e -> e.email.length() > 5, "Email Must be Greater than 5 Characters.")
                    .getErrors();
        }
    }
}
