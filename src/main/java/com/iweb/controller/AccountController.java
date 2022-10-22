package com.iweb.controller;

import com.iweb.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController
{
    @Autowired
    IAccountService accountService;

    public void tranct(Integer id1,Integer id2,Integer money){
        accountService.tranct(id1,id2,money);
    }
}
