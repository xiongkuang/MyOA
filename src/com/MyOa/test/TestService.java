package com.MyOa.test;

import com.MyOa.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by xiongkuang on 3/7/16.
 */
@Service
public class TestService {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void saveTwoUsers(){
        Session session =sessionFactory.getCurrentSession();
        session.save(new User());
        session.save(new User());
    }
}
