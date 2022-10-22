package com.iweb.service;

import com.iweb.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements IAccountService{

    @Autowired
    IAccountDao accountDao;

    @Override
    public Integer tranct(Integer id1, Integer id2, Integer money) {
        accountDao.updateMoneyById(id1,-money);

//        int i =10/0;

        Integer integer = accountDao.updateMoneyById(id2, money);

        return integer;
    }
}
