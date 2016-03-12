package com.MyOa.test;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

/**
 * Created by xiongkuang on 3/4/16.
 */
public class TestAction extends ActionSupport {

    @Resource
    private TestService testService;
    @Override
    public String execute() throws Exception {
        System.out.println("----->TestAction-excute()");
        //testService.saveTwoUsers();
        return "success";
    }
}
