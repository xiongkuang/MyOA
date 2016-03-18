package com.MyOa.Base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongkuang on 3/8/16.
 */

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private Class<T> tClass = null;//a problem to be solved

    public BaseDaoImpl(){
        //use reflection to get class of T, this.getClass get the class of instance(user/role...)
        ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
        tClass = (Class<T>)pt.getActualTypeArguments()[0];
        System.out.println("class is "+tClass);
    }

    @Resource
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);

    }

    @Override
    public void delete(Long id) {
        Object object = getById(id);
        if (object != null){
            getSession().delete(object);
        }

    }

    @Override
    public void update(T entity) {
        getSession().update(entity);

    }

    @Override
    public T getById(Long id) {
        if (id == null){
            return null;
        }else {
            return (T) getSession().get(tClass, id);
        }
    }

    @Override
    public List<T> getByIds(Long[] ids) {
        return getSession().createQuery(//
                "FROM " +tClass.getSimpleName()+ " " + "WHERE id IN (:ids)").setParameterList("ids", ids)//
                .list();
    }

    @Override
    public List<T> findAll() {
        return getSession().createQuery(//
                "FROM " + tClass.getSimpleName())//
                .list();
    }
}
