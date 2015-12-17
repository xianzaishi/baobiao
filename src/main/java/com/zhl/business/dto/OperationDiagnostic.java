package com.zhl.business.dto;

/**
 * 手术前后诊断符合率
 * 
 * @author 张宏亮
 *
 */
public class OperationDiagnostic {
	/**
	 * 符合
	 */
	private double fuHe;

	/**
	 * 不符
	 */
	private double buFu;

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
}
