package org.opencejav.spadesuite.utils.helpers.validator;


import org.opencejav.spadesuite.annotations.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@UtilityClass(className = "Validator")
public class Validator<T> implements Validate<T> {
    private final HashMap<Predicate<T>, String> validationRules;

    public Validator() {
        this.validationRules = new HashMap<>();
    }

    @Override
    public Validator<T> addRule(final Predicate<T> rule, final String message) {
        this.validationRules.put(rule, message);
        return this;

    }

    //region Predicates
    public static <T> boolean nonNull(final T obj) {
        return Objects.nonNull(obj);
    }

    public static <T> boolean notEmpty(final T obj) {
        return obj.toString().isEmpty();
    }

    public static <K, T> boolean nonNull(final HashMap<T, K> tkHashMap) {
        return tkHashMap != null;
    }

    public static <K, T> boolean notEmpty(final HashMap<T, K> tkHashMap) {
        return !tkHashMap.isEmpty();
    }
    //endregion
    

    @Override
    public Validator<T> addRegexRule(final String regex, final String message) {
        return this.addRule(value -> value.toString().matches(regex), message);

    }

    @Override
    public List<String> validate(final T object) {
        List<String> errors = new ArrayList<>();

        this.validationRules.forEach((rule, message) -> {
            if (!rule.test(object)) {
                errors.add(message);
            }
        });

        return errors;
    }

    public static <T> Validator<T> of(T object) {
        return new Validator<>();
    }

    public static <K, T> boolean nonEmpty(HashMap<T,K> tkHashMap) {
        return !tkHashMap.isEmpty();
    }
}
