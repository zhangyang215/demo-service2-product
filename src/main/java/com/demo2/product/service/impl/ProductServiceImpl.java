/* 
 * Created by 2018年9月10日
 */
package com.demo2.product.service.impl;

import java.util.List;

import com.demo2.support.dao.BasicDao;
import com.demo2.support.repository.Repository;
import com.demo2.product.entity.Product;
import com.demo2.product.service.ProductService;

/**
 * The implement of the product service.
 * @author fangang
 */
public class ProductServiceImpl implements ProductService {
	private BasicDao dao;
	private Repository repository;
	
	/**
	 * @return the repository
	 */
	public Repository getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	/**
	 * @return the dao
	 */
	public BasicDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	@Override
	public void saveProduct(Product product) {
		dao.insertOrUpdate(product);
	}

	@Override
	public void saveProductList(List<Product> listOfProducts) {
		dao.insertOrUpdate(listOfProducts);
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = new Product();
		product.setId(id);
		dao.delete(product);
	}

	@Override
	public Product getProduct(Long id) {
		Product template = new Product();
		return repository.load(id, template);
	}
}
