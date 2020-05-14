package com.wangshuai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangshuai.bean.User;
import com.wangshuai.dao.UserDao;
import org.apache.catalina.mbeans.UserMBean;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JDBCApplication.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserDao userDao;


    @Test
    public void query() {
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps("userList");
        String json = ops.get();
        if (StringUtils.isBlank(json)) {
            //从数据库查询
            List<User> users = userDao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                String userJson = mapper.writeValueAsString(users);
                //存入redis
                ops.set(userJson);
                System.out.println("***************数据库查询*****************");
                json = userJson;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("*****************redis查询*****************");

        }


        System.out.println(json);

    }
}
