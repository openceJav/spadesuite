package org.opencejav.spadesuite.repository;

import java.util.List;

/**
 * <p>
 *     BaseRepository is a generic interface that defines a set of common methods
 *     that all repositories should implement. Concrete classes implementing this
 *     interface should consider all methods defined for performing CRUD operations.
 *     <br>
 *     <br>
 *     Implementing classes should provide a concrete implementation for each
 *     of the methods defined in this interface.
 *
 *     <ul>
 *         <li>save() -> void</li>
 *         <li>delete() -> void</li>
 *         <li>update() -> void</li>
 *         <li>find() -> T</li>
 *         <li>findAll() -> List<T></li>
 *         <li>findById() -> T</li>
 *         <li>findByProperty() -> T</li>
 *         <li>findByProperties() -> T</li>
 *     </ul>
 * </p>
 * @param <T> The type of entity that the repository will be managing.
 */
public interface BaseRepository<T> {
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    T find(T entity);
    List<T> findAll();
    T findById(int id);
    T findByProperty(T property);
    T findByProperties(T... properties);
}
