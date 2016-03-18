package com.MyOa.util;

import com.MyOa.domain.Department;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xiongkuang on 3/18/16.
 */
public class DepartmentUtils {
    /**
     * iterate the department tree, put all departments in one list and return, change the department's
     * name to show the layer of the department
     * @param topList
     * @return
     */
    public static List<Department> getAllDepartments(List<Department> topList) {
        List<Department> departmentList = new ArrayList<Department>();
        traverseDepartmentTreeList(topList, departmentList,"▸");
        return departmentList;
    }

    private static void traverseDepartmentTreeList(Collection<Department> topList, List<Department> departmentList, String prefix){
        for (Department top : topList){
            //top
            //System.out.println(prefix + top.getName());
            Department copy = new Department();
            copy.setId(top.getId());
            copy.setName(prefix + top.getName());
            departmentList.add(copy);
            //children
            traverseDepartmentTreeList(top.getChildren(), departmentList, "　" + prefix);
        }
    }
}
