package com.jule.exampel.login;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



//@TestPropertySource(properties = "logging.level.org.springframework.web=DEBUG")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=LoginApplication.class)
//@SpringBootTest
@WebMvcTest(GreetingController.class)
public class LoginApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void rendersForm() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(content().string(containsString("Form")));
    }

    @Test
    public void submitsForm() throws Exception {
        mockMvc.perform(post("/greeting").param("id", "12345").param("content", "Hello"))
                .andExpect(content().string(containsString("Result")))
                .andExpect(content().string(containsString("id: 12345")));
    }

}
