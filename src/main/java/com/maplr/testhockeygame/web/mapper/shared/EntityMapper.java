package com.maplr.testhockeygame.web.mapper.shared;

import com.maplr.testhockeygame.domain.MaplrEntity;
import com.maplr.testhockeygame.web.view.MaplrView;

import java.util.Collection;

/**
 *
 * @param <T> Entity type
 * @param <V> View type
 */
public interface EntityMapper<T extends MaplrEntity, V extends MaplrView> {

    V toView(T entity);
    T toEntity(V view);

    Collection<V> toCollectionView(Collection<T> entities);
    Collection<T> toCollectionEntity(Collection<V> views);
}
