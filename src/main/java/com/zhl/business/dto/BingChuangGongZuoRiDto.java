package com.zhl.business.dto;

public class BingChuangGongZuoRiDto {
	/**
	 * 科室名称
	 */
	private String dept;

	/**
	 * 实际占用总床日数
	 */
	private double shiJiZhanYongZongChuangRiShu;

	/**
	 * 平均开放床日数
	 */
	private double pingJuKaiFangChuangRiShu;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getShiJiZhanYongZongChuangRiShu() {
		return shiJiZhanYongZongChuangRiShu;
	}

	public void setShiJiZhanYongZongChuangRiShu(double shiJiZhanYongZongChuangRiShu) {
		this.shiJiZhanYongZongChuangRiShu = shiJiZhanYongZongChuangRiShu;
	}

	public double getPingJuKaiFangChuangRiShu() {
		return pingJuKaiFangChuangRiShu;
	}

	public void setPingJuKaiFangChuangRiShu(double pingJuKaiFangChuangRiShu) {
		this.pingJuKaiFangChuangRiShu = pingJuKaiFangChuangRiShu;
	}
}
