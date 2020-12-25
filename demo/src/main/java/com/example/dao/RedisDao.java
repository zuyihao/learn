package com.example.dao;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component("redisDao")
public class RedisDao {
    @Resource
    private StringRedisTemplate template;
    public void setKey(String key, String value){
        ValueOperations<String,String> ops = template.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);
    }
    public String getValue(String key){
        ValueOperations<String,String> ops = template.opsForValue();
        return ops.get(key);
    }
}
