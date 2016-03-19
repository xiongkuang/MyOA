package com.MyOa.service;

import com.MyOa.Base.DaoSupport;
import com.MyOa.domain.Department;

import java.util.List;

/**
 * Created by xiongkuang on 3/14/16.
 */
public interface DepartmentService extends DaoSupport<Department>{
//    List<Department> findAll();
//
//    void delete(Long id);
//
//    void save(Department model);
//
//    Department getById(Long id);
//
//    void update(Department department);
//
    List<Department> findTopList();

    List<Department> findChildren(Long parentId);
}
