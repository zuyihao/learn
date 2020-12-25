package com.example.demo;

import com.example.dao.RedisDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisApplicationTest {
    private final Logger logger = LoggerFactory.getLogger(RedisApplicationTest.class);
    @Autowired
    RedisDao redisDao;

    //@Test
    public void testRedis(){
        redisDao.setKey("name","dfa");
        redisDao.setKey("age",11+"");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }
}
