package com.zhl.business.model;

/**
 * 设备阳性率
 * 
 * @author 张宏亮
 *
 */
public class EquipmentPositiveRate {
	/**
	 * 月份
	 */
	private String month;

	/**
	 * 彩超
	 */
	private double caiChao;

	/**
	 * ct
	 */
	private double ct;

	/**
	 * mri
	 */
	private double mri;

	/**
	 * dr
	 */
	private double dr;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getCaiChao() {
		return caiChao;
	}

	public void setCaiChao(double caiChao) {
		this.caiChao = caiChao;
	}

	public double getCt() {
		return ct;
	}

	public void setCt(double ct) {
		this.ct = ct;
	}

	public double getMri() {
		return mri;
	}

	public void setMri(double mri) {
		this.mri = mri;
	}

	public double getDr() {
		return dr;
	}

	public void setDr(double dr) {
		this.dr = dr;
	}
}
