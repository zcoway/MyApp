package com.gangw.myapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gangw.myapp.config.MvcWebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcWebConfig.class})
public class WebDomainIntegrationTest {

	private static final String STANDARD = "Yummy Noodles";
	private static final String CHEF_SPECIAL = "Special Yummy Noodles";
	private static final String LOW_CAL = "Low cal Yummy Noodles";

	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void getHome() throws Exception {
		mockMvc.perform(get("/api/12"))
		.andDo(print())
		.andExpect(status().isOk());
//		.andExpect(model().size(2))
//		.andExpect(model().attribute("menuItems", hasSize(3)))
//		.andExpect(model().attribute("menuItems", hasItems(hasProperty("name", is(STANDARD)),
//															hasProperty("name", is(CHEF_SPECIAL)),
//															hasProperty("name", is(LOW_CAL))) ))
//		.andExpect(model().attributeExists("basket"))
//    .andExpect(content().string(stringContainsInOrder(
//            Arrays.asList("<title>Yummy Noodle Bar</title>"))));

	}

}