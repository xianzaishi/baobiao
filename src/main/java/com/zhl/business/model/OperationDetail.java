package com.zhl.business.model;

import java.util.Date;

public class OperationDetail {
	/**
	 * 住院号
	 */
	private String zhuYuanHao;

	/**
	 * 姓名
	 */
	private String xingMing;

	/**
	 * 科室
	 */
	private String keShi;

	/**
	 * 出院日期
	 */
	private Date chuYuanRiQi;

	/**
	 * 已行手术
	 */
	private String yiXingShouShu;

	/**
	 * 手术级别
	 */
	private String shouShuJiBie;

	/**
	 * 愈合
	 */
	private String yuHe;

	public String getZhuYuanHao() {
		return zhuYuanHao;
	}

	public void setZhuYuanHao(String zhuYuanHao) {
		this.zhuYuanHao = zhuYuanHao;
	}

	public String getXingMing() {
		return xingMing;
	}

	public void setXingMing(String xingMing) {
		this.xingMing = xingMing;
	}

	public String getKeShi() {
		return keShi;
	}

	public void setKeShi(String keShi) {
		this.keShi = keShi;
	}

	public Date getChuYuanRiQi() {
		return chuYuanRiQi;
	}

	public void setChuYuanRiQi(Date chuYuanRiQi) {
		this.chuYuanRiQi = chuYuanRiQi;
	}

	public String getYiXingShouShu() {
		return yiXingShouShu;
	}

	public void setYiXingShouShu(String yiXingShouShu) {
		this.yiXingShouShu = yiXingShouShu;
	}

	public String getShouShuJiBie() {
		return shouShuJiBie;
	}

	public void setShouShuJiBie(String shouShuJiBie) {
		this.shouShuJiBie = shouShuJiBie;
	}

	public String getYuHe() {
		return yuHe;
	}

	public void setYuHe(String yuHe) {
		this.yuHe = yuHe;
	}
}
