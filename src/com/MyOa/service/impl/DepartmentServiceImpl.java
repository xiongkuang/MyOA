package com.MyOa.service.impl;

import com.MyOa.dao.DepartmentDao;
import com.MyOa.domain.Department;
import com.MyOa.service.DepartmentService;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongkuang on 3/14/16.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);

    }

    @Override
    public void save(Department model) {
        departmentDao.save(model);

    }

    @Override
    public Department getById(Long id) {
        return departmentDao.getById(id);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public List<Department> findTopList() {
        return sessionFactory.getCurrentSession().createQuery(//
                "FROM Department d WHERE d.parent IS NULL")//
                .list();
    }

    @Override
    public List<Department> findChildren(Long parentId) {
        return sessionFactory.getCurrentSession().createQuery(//
                "FROM Department d WHERE d.parent.id = ?")//
                .setParameter(0,parentId)//
                .list();
    }
}
