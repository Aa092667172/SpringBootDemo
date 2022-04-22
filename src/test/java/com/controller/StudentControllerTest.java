package com.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * mockMvc模擬前端API請求
 */
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                    .get("/students/3");
                    .get("/students/{studentId}",3)
                    .header("headerName","headerValue")
                    .queryParam("graduate","true");
       MvcResult mvcResult= mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                //取得json中的哪個key的值
                .andExpect(jsonPath("$.id",equalTo(3)))
                .andExpect(jsonPath("$.name",notNullValue()))
                .andReturn();

       String body = mvcResult.getResponse().getContentAsString();
        System.out.println("返回的response body = " + body);
    }

    @Test
    public void create() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/students")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "    \"id\": 3,\n" +
                            "    \"name\": \"Judy\",\n" +
                            "    \"score\": 100.0,\n" +
                            "    \"graduate\": true,\n" +
                            "    \"createDate\": \"2021-09-05T04:19:48.000+00:00\"\n" +
                            "}");
            mockMvc.perform(requestBuilder)
                    .andExpect(status().is(201));
    }
}