package org.opencejav.spadesuite.utils.helpers.validator;


import org.opencejav.spadesuite.annotations.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

@UtilityClass(className = "Validator")
@SuppressWarnings("all")
// TODO JavaDocify Validator<T> Class
public class Validator<T> implements Validate<T> {
    private final T object;
    private final List<Throwable> exceptions = new ArrayList<>();

    private Validator(T object) {
        this.object = object;
    }

    public static <T> Validator<T> of(T t) {
        return new Validator<>(Objects.requireNonNull(t));
    }

    @Override
    public Validator<T> addRule(
            final Predicate<? super T> rule,
            final String message) {
        if (!rule.test(object)) {
            exceptions.add(new IllegalArgumentException(message));
        }

        return this;
    }

    @Override
    public Validator<T> addRule(
            final Predicate<? super T> rule) {
        return addRule(rule, "Validation Failed.");
    }

    @Override
    public <U> Validator<T> addRule(
            final Function<? super T, ? extends U> mapper,
            final Predicate<? super U> rule,
            final String message) {
        return addRule(mapper.andThen(rule::test)::apply, message);
    }

    @Override
    public <U> Validator<T> addRegexRule(
            final Function<? super T, ? extends U> mapper,
            final String regex,
            final String message) {
        return addRule(mapper.andThen(u -> u.toString().matches(regex))::apply, message);
    }

    @Override
    public Validator<T> addRegexRule(
            final String regex,
            final String message) {
        return addRule(t -> t.toString().matches(regex), message);
    }

    //region Getter: getErrors()
    public T getErrors() throws IllegalStateException {
        if (!exceptions.isEmpty()) {
            throw new IllegalStateException(exceptions.stream()
                    .map(Throwable::getMessage)
                    .reduce("%s\n%s"::formatted) // Might Work?
                    .orElse("Validation Failed."));
        }

        return object;
    }
    //endregion
}
