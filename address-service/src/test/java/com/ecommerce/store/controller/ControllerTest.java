package com.ecommerce.store.controller;

import com.ecommerce.store.AddressConfiguration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AddressConfiguration.class})
@WebAppConfiguration
public abstract class ControllerTest {
    static {
        System.setProperty("spring.profiles.active", "test");
    }

    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;

    @Autowired
    MessageSource messageSource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}
