package com.MyOa.util;

import com.MyOa.domain.Privilege;
import com.MyOa.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * initiate the system
 * Created by xiongkuang on 3/26/16.
 */
@Component
public class Installer {

    @Resource
    public SessionFactory sessionFactory;

    @Transactional
    public void install(){
        Session session = sessionFactory.getCurrentSession();

        //save Administrator user
        User user = new User();
        user.setLoginName("admin");
        user.setName("Administrator");
        user.setPassWord(DigestUtils.md5Hex("admin"));
        session.save(user);

        //save privilege data
        Privilege menu, menu1, menu2, menu3, menu4, menu5;
        //------------------------
        menu = new Privilege("System Management", null, null);
        menu1 = new Privilege("Role Management", "/role_list", menu);
        menu2 = new Privilege("Department Management", "/department_list", menu);
        menu3 = new Privilege("User Management", "/user_list", menu);
        session.save(menu);
        session.save(menu1);
        session.save(menu2);
        session.save(menu3);

        session.save(new Privilege("Role List", "/role_list", menu1));
        session.save(new Privilege("Role Delete", "/role_delete", menu1));
        session.save(new Privilege("Role Add", "/role_add", menu1));
        session.save(new Privilege("Role Edit", "/role_edit", menu1));

        session.save(new Privilege("Department List", "/department_list", menu2));
        session.save(new Privilege("Department Delete", "/department_delete", menu2));
        session.save(new Privilege("Department Add", "/department_add", menu2));
        session.save(new Privilege("Department Edit", "/department_edit", menu2));

        session.save(new Privilege("User List", "/user_list", menu3));
        session.save(new Privilege("User Delete", "/user_delete", menu3));
        session.save(new Privilege("User Add", "/user_add", menu3));
        session.save(new Privilege("User Edit", "/user_edit", menu3));
        session.save(new Privilege("Initiate Password", "/user_initPassword", menu3));

        //------------------------
        menu = new Privilege("Online Discussion", null, null);
        menu1 = new Privilege("Forum Management", "/forumManage_list", menu);
        menu2 = new Privilege("Forum", "/forum_list", menu);
        session.save(menu);
        session.save(menu1);
        session.save(menu2);

        //------------------------
        menu = new Privilege("Work Flow", null, null);
        menu1 = new Privilege("Work Flow Management", "/processDefinition_list", menu);
        menu2 = new Privilege("Application Template Management", "/template_list", menu);
        menu3 = new Privilege("Write Application", "/flow_templateList", menu);
        menu4 = new Privilege("To be Review", "/flow_myTaskList", menu);
        menu5 = new Privilege("My Application", "/flow_myApplicationList", menu);
        session.save(menu);
        session.save(menu1);
        session.save(menu2);
        session.save(menu3);
        session.save(menu4);
        session.save(menu5);


        //------------------------




    }

    public static void main(String args[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Installer installer = (Installer) applicationContext.getBean("installer");
        installer.install();
    }

}
