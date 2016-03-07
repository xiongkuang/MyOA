package com.MyOa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiongkuang on 3/7/16.
 */
public class SpringTest {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    @Test
    public void testBean() throws Exception{
        TestAction testAction =(TestAction)ac.getBean("mySpringTestAction");
        System.out.println(testAction);
    }
}
