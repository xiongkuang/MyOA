package com.MyOa.Base;

import java.util.List;

/**
 * Created by xiongkuang on 3/8/16.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Override
    public void save(T entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public List<T> getByIds(Long[] ids) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
