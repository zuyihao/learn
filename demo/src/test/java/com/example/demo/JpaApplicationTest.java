package com.example.demo;

import com.example.dao.UserRepository;
import com.example.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = "com.example.*")
@EnableJpaRepositories(basePackages = "com.example.dao")
@EntityScan("com.example.entity")
public class JpaApplicationTest {
    private final Logger logger = LoggerFactory.getLogger(JpaApplicationTest.class);
    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {

    }
    @Test
    public void testAdd() {
        User user = new User();
        user.setId(1L);
        user.setUserName("风清扬");
        user.setPassword("fengqy");
        userRepository.save(user);
    }

    @After
    public void after() {
        //userRepository.deleteById(1L);
    }
}
