/*
 * Created by 2020-12-21 16:02:59 
 */
package com.demo2.product.contract;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alibaba.fastjson.JSONObject;
import com.demo2.product.entity.Product;

/**
 * @author fangang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(ids= {"com.demo:demo-service2-supplier:+:stubs:9004"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ProductContractTest {
	@Autowired
	private MockMvc mvc;
	@Test
	public void testSaveAndDelete() throws Exception {
		Product product = new Product();
		long id = 10010;
		product.setId(id);
		product.setName("Nodebook");
		product.setPrice((double)4000);
		product.setUnit("unit");
		String idStr = Long.valueOf(id).toString();
		String productStr = JSONObject.toJSONString(product);
		
		mvc.perform(post("/orm/product/saveProduct")
				.param("id", idStr)
				.param("name", "Nodebook")
				.param("price", "4000")
				.param("unit", "unit"))
		.andExpect(status().isOk());
		
		mvc.perform(get("/orm/product/getProduct")
				.param("id", idStr))
		.andExpect(status().isOk())
		.andExpect(content().json(productStr));
		
		mvc.perform(get("/orm/product/deleteProduct")
				.param("id", idStr))
		.andExpect(status().isOk());
		
		mvc.perform(get("/orm/product/getProduct")
				.param("id", idStr))
		.andExpect(status().isOk());
	}
	@Test
	public void testSaveAndDeleteWithSupplier() throws Exception {
		Product product = new Product();
		long id = 10011;
		product.setId(id);
		product.setName("Computor");
		product.setPrice((double)8000);
		product.setUnit("unit");
		product.setSupplierId((long)20001);
		String productStr = JSONObject.toJSONString(product);
		String idStr = Long.valueOf(id).toString();
		
		mvc.perform(post("/orm/product/saveProduct")
				.param("id", idStr)
				.param("name", "Computor")
				.param("price", "8000")
				.param("unit", "unit")
				.param("supplier_id", "20001"))
		.andExpect(status().isOk());
		
		mvc.perform(get("/orm/product/getProduct")
				.param("id", idStr))
		.andExpect(status().isOk())
		.andExpect(content().json(productStr));
		
		mvc.perform(get("/orm/product/deleteProduct")
				.param("id", idStr))
		.andExpect(status().isOk());
		
		mvc.perform(get("/orm/product/getProduct")
				.param("id", idStr))
		.andExpect(status().isOk());
	}
}
