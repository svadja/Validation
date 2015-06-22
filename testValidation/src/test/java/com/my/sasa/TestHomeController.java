package com.my.sasa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestConfig.class })
public class TestHomeController {

	@Autowired
	WebApplicationContext wac;

	@Autowired
	MockHttpSession session;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testHome() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"));
	}

	@Test
	public void testGetForm() throws Exception {
		this.mockMvc.perform(get("/form"))
				.andExpect(status().isOk())
				.andExpect(view().name("form"))
				.andExpect(forwardedUrl("/WEB-INF/views/form.jsp"))
				.andExpect(model().attributeExists("testForm"))
				.andExpect(model().attribute("testForm", hasProperty("str", nullValue())))
				.andExpect(model().attribute("testForm", hasProperty("int_class", nullValue())))
				.andExpect(model().attribute("testForm", hasProperty("int_type", is(0))))
				.andExpect(model().attribute("testForm", hasProperty("email", nullValue())));
	}

	@Test
	public void testForm() throws Exception {
		this.mockMvc.perform(post("/form")
				.param("str", "11")
				.param("int_class", "1")
				.param("int_type", "2")
				.param("email", "test@test"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"))
     			//.andExpect(model().attributeHasFieldErrors("testForm"))
				.andExpect(model().attribute("testForm", hasProperty("str", is("11"))))
				.andExpect(model().attribute("testForm", hasProperty("int_class", is(1))))
				.andExpect(model().attribute("testForm", hasProperty("int_type", is(2))))
				.andExpect(model().attribute("testForm", hasProperty("email", is("test@test"))));
	}

	@Test
	public void testFormValid() throws Exception {
		this.mockMvc.perform(post("/form")
				.param("str", "11")
				.param("int_class", "1")
				//dont set up "int_type"
				//.param("int_type", "2")
				.param("email", ""))
				.andExpect(status().isOk())
				.andExpect(view().name("home"))
     			//expect error
				.andExpect(model().attributeHasFieldErrors("testForm"));
	}


}
