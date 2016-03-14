package com.MyOa.view.action;

import com.MyOa.domain.Department;
import com.MyOa.service.DepartmentService;
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

    private Department model = new Department();

    @Override
    public Department getModel() {
        return model;
    }

    public String list() throws Exception{
        List<Department> departmentList = departmentService.findeAll();
        ActionContext.getContext().put("departmentList",departmentList);
        return "list";
    }

    public String delete() throws Exception{
        departmentService.delete(model.getId());
        return "toList";
    }

    public String addUI() throws Exception{
        return "saveUI";
    }

    public String add() throws Exception{
        departmentService.save(model);
        return "toList";
    }

    public String editUI() throws Exception{
        Department department = departmentService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(department);
        return "saveUI";
    }

    public String edit() throws Exception{
        Department department = departmentService.getById(model.getId());
        department.setName(model.getName());
        department.setDescription(model.getDescription());
        departmentService.update(department);
        return "toList";
    }
}
