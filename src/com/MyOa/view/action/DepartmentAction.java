package com.MyOa.view.action;

import com.MyOa.domain.Department;
import com.MyOa.service.DepartmentService;
import com.MyOa.util.DepartmentUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongkuang on 3/14/16.
 */
@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    @Resource
    private DepartmentService departmentService;

    private Long parentId;

    private Department model = new Department();

    @Override
    public Department getModel() {
        return model;
    }

    public String list() throws Exception{
        List<Department> departmentList = null;
        if (parentId == null){
            departmentList = departmentService.findTopList();
        }else {
            departmentList = departmentService.findChildren(parentId);
            Department parent = departmentService.getById(parentId);
            ActionContext.getContext().put("parent",parent);
        }
        ActionContext.getContext().put("departmentList",departmentList);

        return "list";
    }

    public String delete() throws Exception{
        departmentService.delete(model.getId());
        return "toList";
    }

    public String addUI() throws Exception{
        //prepare data departmentlist
        //List<Department> departmentList = departmentService.findAll();
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);
        return "saveUI";
    }

    public String add() throws Exception{
        Department parent = departmentService.getById(parentId);
        model.setParent(parent);

        departmentService.save(model);
        return "toList";
    }

    public String editUI() throws Exception{
//        List<Department> departmentList = departmentService.findAll();
//        ActionContext.getContext().put("departmentList", departmentList);
        List<Department> topList = departmentService.findTopList();
        List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
        ActionContext.getContext().put("departmentList", departmentList);

        Department department = departmentService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(department);
        if (department.getParent() != null){
            parentId = department.getParent().getId();
        }
        return "saveUI";
    }

    public String edit() throws Exception{
        //get model from database
        Department department = departmentService.getById(model.getId());

        //edit the attribute
        department.setName(model.getName());
        department.setDescription(model.getDescription());
        department.setParent(departmentService.getById(parentId));//update the parent department

        //update database
        departmentService.update(department);
        return "toList";
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
