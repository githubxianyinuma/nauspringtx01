package com.iweb;

import com.iweb.controller.AccountController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AccountController accountController = ac.getBean(AccountController.class);

        accountController.tranct(10001,10002,3000);

    }
}
