package com.ecommerce.store.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */
@Transactional
@Ignore
public class AddressControllerTest extends ControllerTest {

    @Test
    public void testAddAddress() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/v1/profile/customers/129/addresses/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(dataJson("src/test/resources/address.json")));

        resultActions.andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddressList() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/profile/customers/129/addresses/"));

        resultActions.andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddress() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/profile/customers/129/addresses/126"));

        resultActions.andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteAddress() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.delete("/v1/profile/customers/129/addresses/126"));

        resultActions.andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testEditAddress() throws Exception {
        // FIXME: change the harcoded orderid
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.put("/v1/profile/customers/129/addresses/126")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(dataJson("src/test/resources/address.json")));

        resultActions.andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String dataJson(String filepath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
