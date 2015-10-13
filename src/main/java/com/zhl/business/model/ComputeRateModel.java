package com.zhl.business.model;

/**
 * 计算率模型
 * 
 * @author 张宏亮
 *
 */
public class ComputeRateModel {
	/**
	 * 项目名
	 */
	private String name;

	/**
	 * 总计
	 */
	private double total;

	/**
	 * 项目数值
	 */
	private double data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}
}
