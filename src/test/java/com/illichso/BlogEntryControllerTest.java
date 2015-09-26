package com.illichso;

import com.illichso.mvc.BlogEntryController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class BlogEntryControllerTest {
    @InjectMocks
    private BlogEntryController controller;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    public void testGetOld() throws Exception {
        mockMvc.perform(get("/test1")).andDo(print());

    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/test")).andDo(print());

    }

    @Test
    public void testPost() throws Exception {
        mockMvc.perform(post("/test")
                .content("{\"title\":\"Test Blog Title\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("Test Blog Title")))
                .andDo(print());

    }
}
