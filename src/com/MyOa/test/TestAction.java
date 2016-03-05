package com.MyOa.test;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by xiongkuang on 3/4/16.
 */
public class TestAction extends ActionSupport {


    @Override
    public String execute() throws Exception {
        System.out.println("----->TestAction-excute()");
        return "success";
    }
}
