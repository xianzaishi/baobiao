package com.zhl.business.dto;

/**
 * 门诊诊断符合率Dto
 * 
 * @author 张宏亮
 *
 */
public class OpDiagnosticDto {
	/**
	 * 月份
	 */
	private String month;

	/**
	 * 总数
	 */
	private int zongShu;

	/**
	 * 符合
	 */
	private int fuHe;

	/**
	 * 不符
	 */
	private int buFu;

	/**
	 * 疑诊
	 */
	private int yiZhen;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getZongShu() {
		return zongShu;
	}

	public void setZongShu(int zongShu) {
		this.zongShu = zongShu;
	}

	public int getFuHe() {
		return fuHe;
	}

	public void setFuHe(int fuHe) {
		this.fuHe = fuHe;
	}

	public int getBuFu() {
		return buFu;
	}

	public void setBuFu(int buFu) {
		this.buFu = buFu;
	}

	public int getYiZhen() {
		return yiZhen;
	}

	public void setYiZhen(int yiZhen) {
		this.yiZhen = yiZhen;
	}
}
