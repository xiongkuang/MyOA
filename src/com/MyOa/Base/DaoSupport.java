package com.MyOa.Base;

import java.util.List;

/**
 * Created by xiongkuang on 3/8/16.
 */
public interface DaoSupport<T> {
    void save(T entity);

    void delete(Long id);

    void update(T entity);

    T getById(Long id);

    List<T> getByIds(Long[] ids);

    List<T> findAll();
}
