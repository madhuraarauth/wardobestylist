package com.wardrobe.planner.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wardrobe.planner.model.Colors;
import com.wardrobe.planner.model.Items;
import com.wardrobe.planner.services.ColorService;
import com.wardrobe.planner.spring.config.ApplicationContextConfig;
import com.wardrobe.planner.spring.config.SpringWebAppInitializer;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class,SpringWebAppInitializer.class})
@WebAppConfiguration
public class MyWardrobeControllerTest {

	@Autowired
	private ColorService colorService;
	
	
	 private MockMvc mockMvc;
	 
	   
	    @Autowired
	    private WebApplicationContext webApplicationContext;
	 
	    @Before
	    public void setUp() {
	        //We have to reset our mock between tests because the mock objects
	        //are managed by the Spring container. If we would not reset them,
	        //stubbing and verified behavior would "leak" from one test to another.
	       // Mockito.reset(colorService);
	 
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    }
	@Test
	public void addColorTest(){
		try {
			
			Colors colors= new Colors();
			colors.setColorCode("MAX-BLACK");
			colors.setColorName("#ffffff");
			colors.setItems(new HashSet<Items>());;
			MvcResult result = mockMvc.perform(post("/addColor").requestAttr("colors", colors)
/*					.param("colorName", "BLACK")
					.param("colorCode", "#ffffff")
*/					).andDo(print()).
					andExpect(status().isOk())
					.andReturn();
			
			/*String content = result.getResponse().getContentAsString();
			System.out.println(content);*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getColorTest(){
		try {
			mockMvc.perform(get("/colors")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("test");
	}
}
