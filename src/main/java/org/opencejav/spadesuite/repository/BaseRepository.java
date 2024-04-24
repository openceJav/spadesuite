package org.opencejav.spadesuite.repository;

// TODO Configure BaseRepository Interface
public interface BaseRepository<T> {
    void save();
    void delete();
    void update();
    void find();
    void findAll();
    void findById(int id);
    void findByProperty(T property);
    void findByProperties(T... properties);
}
