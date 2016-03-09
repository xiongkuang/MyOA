package com.MyOa.Base;

import com.MyOa.dao.RoleDao;
import com.MyOa.dao.UserDao;
import com.MyOa.dao.impl.RoleDaoImpl;
import com.MyOa.dao.impl.UserDaoImpl;
import com.MyOa.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xiongkuang on 3/8/16.
 */
public class BaseDaoTest {

    @Test
    public void testSave() throws Exception {
        UserDao userDao = new UserDaoImpl();
        RoleDao roleDao = new RoleDaoImpl();


    }
}