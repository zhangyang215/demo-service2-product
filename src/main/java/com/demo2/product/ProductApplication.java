/*
 * created by 2019年7月9日 下午4:50:18
 */
package com.demo2.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author fangang
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages={"com.demo"})
@ImportResource(locations={"classpath:applicationContext-*.xml"})
@MapperScan("com.demo.support.dao")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ProductApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
