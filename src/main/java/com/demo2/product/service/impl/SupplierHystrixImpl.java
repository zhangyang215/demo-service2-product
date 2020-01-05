/*
 * created by 2019年7月10日 上午9:30:18
 */
package com.demo2.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo2.product.entity.Supplier;
import com.demo2.product.service.SupplierService;

/**
 * The supplier service fallback class.
 * @author fangang
 */
@Component
public class SupplierHystrixImpl implements SupplierService {

	@Override
	public Supplier loadSupplier(long id) {
		Supplier supplier = new Supplier();
		supplier.setId(id);
		supplier.setName("默认供应商");
		return supplier;
	}

	@Override
	public List<Supplier> listOfSupplier() {
		List<Supplier> list = new ArrayList<Supplier>();
		return list;
	}

}
