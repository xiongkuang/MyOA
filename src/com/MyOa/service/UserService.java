package com.MyOa.service;

import com.MyOa.Base.DaoSupport;
import com.MyOa.domain.User;

/**
 * Created by xiongkuang on 3/18/16.
 */
public interface UserService extends DaoSupport<User> {


    /**
     *
     * @param loginName
     * @param passWord
     * @return
     */
    User findByUserNameAndPassword(String loginName, String passWord);
}
