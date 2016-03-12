package com.MyOa.service;

import com.MyOa.domain.Role;

import java.util.List;

/**
 * Created by xiongkuang on 3/12/16.
 */

public interface RoleService {

    List<Role> findAll();

    void delete(Long id);

    void save(Role role);

    Role getById(Long id);

    void update(Role role);
}
