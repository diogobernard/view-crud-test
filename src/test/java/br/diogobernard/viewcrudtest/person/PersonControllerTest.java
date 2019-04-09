package br.diogobernard.viewcrudtest.person;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest({PersonController.class})
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Configuration
    @ComponentScan(basePackageClasses = { PersonController.class})
    public static class TestConf {}

    @Ignore
    @Test
    public void testRegisterPersonSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/person",new Person(1,"teste",20))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Successful registration")));
    }

    @Ignore
    @Test
    public void testGetPersonSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/person",new Person(2,"teste2",20))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Successful registration")));

        mockMvc.perform(MockMvcRequestBuilders.get("/person/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.age",is(20)));
    }

}
