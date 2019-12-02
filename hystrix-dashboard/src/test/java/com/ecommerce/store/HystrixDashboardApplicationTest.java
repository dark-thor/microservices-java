package com.ecommerce.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {HystrixDashboardApplication.class})
public class HystrixDashboardApplicationTest {
    static {
        System.setProperty("spring.profiles.active", "test");
    }

    @Test
    public void contextLoads() throws Exception {
    }
}
