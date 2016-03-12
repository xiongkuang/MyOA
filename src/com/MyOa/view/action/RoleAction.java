package com.MyOa.view.action;

import com.MyOa.domain.Role;
import com.MyOa.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiongkuang on 3/12/16.
 */
@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven {

    @Resource
    private RoleService roleService;

//    private Long id;
//    private String name;
//    private String description;

    private Role model = new Role();

    @Override
    public Object getModel() {
        return model;
    }

    public String list() throws Exception{
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList",roleList);
        return "list";
    }

    public String delete() throws Exception{
        roleService.delete(model.getId());
        return "toList";
    }

    public String addUI() throws Exception{
        return "addUI";
    }

    public String add() throws Exception{
//        //encapsulate to object
//        Role role = new Role();
//        role.setName(model.getName());
//        role.setDescription(model.getDescription());
//
//        //save to database
//        roleService.save(role);
        roleService.save(model);

        return "toList";
    }

    public String editUI() throws Exception{
        //prepare feedback data
        Role role = roleService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(role);//use ognl to find value in stack
        //this.name = role.getName();
        //this.description = role.getDescription();
        return "editUI";
    }

    public String edit() throws Exception{
        //1, get the original object from the database
        Role role = roleService.getById(model.getId());

        //2, set the attributes
        role.setName(model.getName());
        role.setDescription(model.getDescription());

        //3, update database

        roleService.update(role);
        return "toList";
    }


    //getter and setter

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
