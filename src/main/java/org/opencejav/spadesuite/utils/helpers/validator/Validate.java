package org.opencejav.spadesuite.utils.helpers.validator;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Validate<T> {
    Validator<T> addRule(Predicate<? super T> rule, String message);
    <U> Validator<T> addRule(Function<? super T, ? extends U> mapper, Predicate<? super U> rule, String message);
    Validator<T> addRule(Predicate<? super T> rule);
    Validator<T> addRegexRule(String regex, String message);
    <U> Validator<T> addRegexRule(Function<? super T, ? extends U> mapper, String regex, String message);
}
