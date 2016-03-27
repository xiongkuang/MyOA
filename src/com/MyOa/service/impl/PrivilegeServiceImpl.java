package com.MyOa.service.impl;

import com.MyOa.Base.DaoSupportImpl;
import com.MyOa.domain.Privilege;
import com.MyOa.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiongkuang on 3/27/16.
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService{
}
