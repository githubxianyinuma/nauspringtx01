package com.iweb.dao.impl;

import com.iweb.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer updateMoneyById(Integer id, Integer money) {
        return jdbcTemplate.update("update account set money = money + ? where id=?",money,id);
    }
}
