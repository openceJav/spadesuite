package org.opencejav.spadesuite.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    Optional<T> find(T entity);
    List<T> findAll();
    Optional<T> findById(int id);
    Optional<T> findByProperty(T property);
    Optional<T> findByProperties(T... properties);
}
