package com.MyOa.service.impl;

import com.MyOa.Base.DaoSupportImpl;
import com.MyOa.domain.User;
import com.MyOa.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiongkuang on 3/18/16.
 */
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {
}
