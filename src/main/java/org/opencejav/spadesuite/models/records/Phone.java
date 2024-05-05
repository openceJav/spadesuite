package org.opencejav.spadesuite.models.records;

import org.opencejav.spadesuite.utils.helpers.validator.Validator;

import java.text.MessageFormat;
import java.util.Objects;

@SuppressWarnings("all")
// TODO JavaDocify Phone Class
public record Phone(String number, int CountryCode) {
    private static final MessageFormat PHONE_FORMAT = new MessageFormat("({0})-{1}-{2}");

    public static class PhoneBuilder {
        //region DEFAULTS
        private static final String DEFAULT_NUMBER = "(000)-000-0000";

        private static final int DEFAULT_COUNTRY_CODE = 1;
        //endregion

        private String number;
        private int countryCode;

        public PhoneBuilder () {
            this.number = DEFAULT_NUMBER;
            this.countryCode = DEFAULT_COUNTRY_CODE;
        }

        public PhoneBuilder withNumber(String number) {
            Objects.requireNonNull(number, "Number Cannot be Null.");

            this.number = number;
            return this;
        }

        public PhoneBuilder withCountryCode(int countryCode) {
            Objects.requireNonNull(countryCode, "CountryCode Cannot be Null.");

            this.countryCode = countryCode;
            return this;
        }

        public PhoneBuilder withFormattedNumber() {
            this.number = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
            return this;
        }

        public Phone build() {
            isValidPhoneBuild();
            return new Phone(this.number, this.countryCode);
        }

        // TODO Check this Method for Validity (Refactor if Necessary)
        public void isValidPhoneBuild() {
            Validator<PhoneBuilder> validator = Validator.of(this);

            // FIXME Add More Rules for Phone If Needed
            var validPhone = validator
                    .addRule(p -> p.number != null && p.number.length() > 0, "Number Cannot be Null or Empty.")
                    .addRegexRule("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", "Numbe Contains Invalid Characters.")
                    .addRule(p -> p.countryCode >= 0 && p.countryCode <= 999, "Country Code Must be Between 0 and 999.")
                    .getErrors();
        }
    }
}
