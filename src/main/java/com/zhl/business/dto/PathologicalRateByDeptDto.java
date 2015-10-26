package com.zhl.business.dto;

public class PathologicalRateByDeptDto {
	/**
	 * 科室名称
	 */
	private String name;

	/**
	 * 符合
	 */
	private double fuhe;

	/**
	 * 不符
	 */
	private double bufu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFuhe() {
		return fuhe;
	}

	public void setFuhe(double fuhe) {
		this.fuhe = fuhe;
	}

	public double getBufu() {
		return bufu;
	}

	public void setBufu(double bufu) {
		this.bufu = bufu;
	}
}
