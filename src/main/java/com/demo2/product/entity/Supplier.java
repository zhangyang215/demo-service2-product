/* 
 * Created by 2018年9月9日
 */
package com.demo2.product.entity;

import java.io.Serializable;

import com.demo2.support.entity.Entity;

/**
 * The supplier entity
 * @author fangang
 */
public class Supplier extends Entity {
	private static final long serialVersionUID = 1486267798991452251L;
	private Long id;
	private String name;
	
	public Supplier() {}
	public Supplier(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	@Override
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(Serializable id) {
		this.id = (Long)id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
