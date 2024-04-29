package org.opencejav.spadesuite.utils.helpers.validator;

import java.util.List;
import java.util.function.Predicate;

public interface Validate<T> {
    Validator<T> addRule(Predicate<T> rule, String message);
    Validator<T> addRegexRule(String regex, String message);
    List<String> validate(T object);
}
