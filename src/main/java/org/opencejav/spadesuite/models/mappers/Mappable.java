package org.opencejav.spadesuite.models.mappers;

import java.util.Map;

/**
 * Interface to Map an Object for a given Type.
 * @param <T> The Type of Object to Map
 */
public interface Mappable<T> {
    T map(T object);
    T fromMap(T object);
    Map<String, T> toMap(T object);
}