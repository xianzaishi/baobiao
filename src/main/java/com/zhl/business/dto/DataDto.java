package com.zhl.business.dto;


/**
 * 科室数据Dto
 * 
 * @author 张宏亮
 *
 */
public class DataDto {
	/**
	 * id
	 */
	private int id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 数据
	 */
	private double data;

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
