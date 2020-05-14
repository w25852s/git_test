package com.wangshuai;

import com.wangshuai.bean.User;
import com.wangshuai.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JDBCApplication.class)
public class MybatisTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        System.out.println(users);

    }

}
