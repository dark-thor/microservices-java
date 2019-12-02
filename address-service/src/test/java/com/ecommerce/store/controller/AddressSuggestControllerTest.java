package com.ecommerce.store.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Ignore
public class AddressSuggestControllerTest extends ControllerTest {
    @Test
    public void testGetAddressByPincode() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/pincodes/560076"));

        resultActions.andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
