package com.MyOa.Base;

import com.MyOa.domain.Department;
import com.MyOa.service.DepartmentService;
import com.MyOa.service.PrivilegeService;
import com.MyOa.service.RoleService;
import com.MyOa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;

/**
 * Created by xiongkuang on 3/18/16.
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    protected T model;

    public BaseAction(){
        try {
            //get true type of T through reflection
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>)parameterizedType.getActualTypeArguments()[0];
            //create model instance through reflection
            model = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public T getModel() {
        return model;
    }


    @Resource
    protected DepartmentService departmentService;

    @Resource
    protected RoleService roleService;

    @Resource
    protected UserService userService;

    @Resource
    protected PrivilegeService privilegeService;
}
