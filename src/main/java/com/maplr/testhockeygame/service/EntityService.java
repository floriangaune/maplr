package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.service.exception.EntityServiceTechnicalException;
import com.maplr.testhockeygame.shared.enumeration.ErrorCodeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public abstract class EntityService<T, K> {

    /**
     * Find an entity by its Identifier
     * @param id searched identifier
     * @return the given entity
     * @throws EntityServiceTechnicalException if no data found
     */
    public T findById(K id) throws EntityServiceTechnicalException {
        return this.getRepository().findById(id).orElseThrow(() -> new EntityServiceTechnicalException(ErrorCodeEnum.SERV_E_1));
    }

    /**
     * Find all entities
     * @return all entities
     */
    public Collection<T> findAll() {
        return this.getRepository().findAll();
    }

    /**
     * Sava an entity
     * @param datum to save
     * @return saved entity
     */
    public T save(T datum) {
        this.prepareData(datum);
        return this.getRepository().save(datum);
    }

    /**
     * Save a collection of entities
     * @param data to save
     * @return saved entities
     */
    public Collection<T> saveAll(Collection<T> data) {
        data.forEach(this::prepareData);
        return this.getRepository().saveAll(data);
    }

    /**
     * get the associated repository
     * @return the repository of the associated entity
     */
    protected abstract JpaRepository<T, K> getRepository();

    protected void prepareData(T datum){
        // Nothong to do.
    }

}