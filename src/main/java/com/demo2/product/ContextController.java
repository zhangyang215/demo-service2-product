package com.demo2.product;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.product.entity.Supplier;
import com.demo2.product.service.SupplierService;

@RestController
public class ContextController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/context")
	public void context( ) {
		//String[] names = context.getBeanDefinitionNames();
//		for(String name : names) {
//			if(name.toLowerCase().contains("supplier"))
//				System.out.println(name + " of Type :: " + context.getBean(name).getClass());
//		}
		
		try {
			Object service = context.getBean("com.demo2.product.service.SupplierService");
			Method method = service.getClass().getDeclaredMethod("loadSupplier", long.class);
			Object rtn = method.invoke(service, 20001);
			rtn.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private ListableBeanFactory lbf;
	
	@GetMapping("test")
	public void test() {
		try {
			Class<?> clazz = Class.forName("com.demo2.product.service.SupplierService");
			Map<String, ?> ss = BeanFactoryUtils.beansOfTypeIncludingAncestors(lbf, clazz);
			Object obj = ss.get("com.demo2.product.service.SupplierService");
			Method method = obj.getClass().getDeclaredMethod("loadSupplier",long.class);
			Object rtn = method.invoke(obj, 20001);
			rtn.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Autowired
	private SupplierService supplierService;
	@GetMapping("getSupplier")
	public void getSupplier() {
		Supplier supplier = supplierService.loadSupplier(20001);
		supplier.toString();
	}
}
