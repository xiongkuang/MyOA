package com.MyOa.service.impl;

import com.MyOa.Base.DaoSupportImpl;
import com.MyOa.domain.User;
import com.MyOa.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiongkuang on 3/18/16.
 */
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {
    @Override
    public User findByUserNameAndPassword(String loginName, String passWord) {
        //user the md5 digest of password to verify the password
        String md5Digest = DigestUtils.md5Hex(passWord);
        return (User)getSession().createQuery(//
                "FROM User u WHERE u.loginName=? AND u.passWord=?")//
                .setParameter(0, loginName)//
                .setParameter(1, md5Digest)//
                .uniqueResult();//if have multiple value will throw hibernateException
    }
}

