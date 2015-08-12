package com.zhl.business.dto;

import java.util.List;

/**
 * 科室数据Dto
 * 
 * @author 张宏亮
 *
 */
public class DeptDateDto {
	/**
	 * 科室id
	 */
	private int id;

	/**
	 * 科室名称
	 */
	private String name;

	/**
	 * 科室数据
	 */
	private List<Double> dateList;

	public List<Double> getDateList() {
		return dateList;
	}

	public void setDateList(List<Double> dateList) {
		this.dateList = dateList;
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
