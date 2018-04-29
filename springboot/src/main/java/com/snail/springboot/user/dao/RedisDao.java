package com.snail.springboot.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //redis中设置key-value
    public void setKey(String key,String value){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key,value,1, TimeUnit.MINUTES);//一分钟过期
    }
    public String getValud(String key){
        ValueOperations<String,String> valueOperations =  stringRedisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
