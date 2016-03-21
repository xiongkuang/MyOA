package com.MyOa.view.action;

import com.MyOa.Base.BaseAction;
import com.MyOa.domain.Department;
import com.MyOa.domain.Role;
import com.MyOa.domain.User;
import com.MyOa.util.DepartmentUtils;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;

/**
 * Created by xiongkuang on 3/18/16.
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
    private Long departmentId;
    private Long[] roleIds;

    public String list() throws Exception {
        List<User> userList = userService.findAll();
        ActionContext.getContext().put("userList",userList);
        return "list";
    }

    public String delete() throws Exception {
        userService.delete(model.getId());
        return "toList";
    }

    public String addUI() throws Exception {
        //prepare treeview departmentlist
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);

        //pepare rolelist
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList",roleList);

//        return "saveUI";
        return "addUI";
    }

    public String add() throws Exception {
        //to object, when model is instance we can use model after set attribute
        //set the department the user belongs to
        model.setDepartment(departmentService.getById(departmentId));
        //set the user's roles
        List<Role> roleList =roleService.getByIds(roleIds);
        model.setRoles(new HashSet<Role>(roleList));
        //set default password
        String md5Digest = DigestUtils.md5Hex("1234");
        model.setPassWord(md5Digest);

        //to database
        userService.save(model);
        return "toList";
    }

    public String editUI() throws Exception {
        //prepare treeview departmentlist,
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);

        //prepare rolelist
        List<Role> roleList = roleService.findAll();
        ActionContext.getContext().put("roleList",roleList);

        //prepare display data
        User user = userService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(user);
        if (user.getDepartment() != null){
            departmentId = user.getDepartment().getId();
        }
        if (user.getRoles() != null){
            roleIds = new Long[user.getRoles().size()];
            int index = 0;
            for (Role role : user.getRoles()){
                roleIds[index++] = role.getId();
            }
        }
//        return "saveUI";
        return "editUI";
    }

    public String edit() throws Exception {
        //get original object
        User user = userService.getById(model.getId());
        //set the attributes
        user.setLoginName(model.getLoginName());
        user.setName(model.getName());
        user.setDescription(model.getDescription());
        user.setEmail(model.getEmail());
        user.setGender(model.getGender());
        user.setPhoneNumber(model.getPhoneNumber());

        user.setDepartment(departmentService.getById(departmentId));
        List<Role> roleList =roleService.getByIds(roleIds);
        user.setRoles(new HashSet<Role>(roleList));

        //update database
        userService.update(user);

        return "toList";
    }

    public String initPassword() throws Exception {
        //get original object
        User user = userService.getById(model.getId());
        //set the attribute,use md5digest
        String md5Digest = DigestUtils.md5Hex("1234");
        user.setPassWord(md5Digest);

        //update database
        userService.update(user);
        return "toList";
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }
}
