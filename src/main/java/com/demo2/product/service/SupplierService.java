/* 
 * Created by 2019年1月30日
 */
package com.demo2.product.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo2.product.entity.Supplier;
import com.demo2.product.service.impl.SupplierHystrixImpl;

/**
 * The service of suppliers.
 * @author fangang
 */
@Service
@FeignClient(value="service-supplier", fallback=SupplierHystrixImpl.class)
public interface SupplierService {
	/**
	 * @param id
	 * @return the supplier
	 */
	@GetMapping("get/supplier/loadSupplier")
	public Supplier loadSupplier(@RequestParam(value="id") long id);
	
	/**
	 * @return the list of supplier
	 */
	@PostMapping("execute/supplier/listOfSupplier")
	public List<Supplier> listOfSupplier();
}
