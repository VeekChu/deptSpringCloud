package com.snail.springboot;

import com.snail.springboot.user.dao.RedisDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public void contextLoad(){}
    @Autowired
    private RedisDao redisDao;
    @org.junit.Test
    public void testRedis(){
        redisDao.setKey("name","snail");
        redisDao.setKey("age","25");
        System.out.println(redisDao.getValud("name"));
        System.out.println(redisDao.getValud("age"));
    }
}
