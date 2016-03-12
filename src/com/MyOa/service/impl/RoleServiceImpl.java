package com.MyOa.service.impl;

import com.MyOa.dao.RoleDao;
import com.MyOa.domain.Role;
import com.MyOa.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongkuang on 3/12/16.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void delete(Long id) {
        roleDao.delete(id);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }
}
