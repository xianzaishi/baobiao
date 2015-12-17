package com.zhl.business.dto;

public class DiagnosticDto {
	/**
	 * 符合
	 */
	private double fuHe;

	/**
	 * 不符
	 */
	private double buFu;

	/**
	 * 疑诊
	 */
	private double yiZhen;

	public double getFuHe() {
		return fuHe;
	}

	public void setFuHe(double fuHe) {
		this.fuHe = fuHe;
	}

	public double getBuFu() {
		return buFu;
	}

	public void setBuFu(double buFu) {
		this.buFu = buFu;
	}

	public double getYiZhen() {
		return yiZhen;
	}

	public void setYiZhen(double yiZhen) {
		this.yiZhen = yiZhen;
	}
}
