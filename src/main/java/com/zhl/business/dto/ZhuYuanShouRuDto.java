package com.zhl.business.dto;

/**
 * 住院收入dto
 * 
 * @author 张宏亮
 *
 */
public class ZhuYuanShouRuDto {
	/**
	 * 药品收入
	 */
	private double yaoPinShouRu;

	/**
	 * 诊疗收入
	 */
	private double zhenLiaoShouRu;

	/**
	 * 救护车收入
	 */
	private double jiuHuCheShouRu;

	/**
	 * 总收入
	 */
	private double zongShouRu;

	public double getZongShouRu() {
		return zongShouRu;
	}

	public void setZongShouRu(double zongShouRu) {
		this.zongShouRu = zongShouRu;
	}

	public double getYaoPinShouRu() {
		return yaoPinShouRu;
	}

	public void setYaoPinShouRu(double yaoPinShouRu) {
		this.yaoPinShouRu = yaoPinShouRu;
	}

	public double getZhenLiaoShouRu() {
		return zhenLiaoShouRu;
	}

	public void setZhenLiaoShouRu(double zhenLiaoShouRu) {
		this.zhenLiaoShouRu = zhenLiaoShouRu;
	}

	public double getJiuHuCheShouRu() {
		return jiuHuCheShouRu;
	}

	public void setJiuHuCheShouRu(double jiuHuCheShouRu) {
		this.jiuHuCheShouRu = jiuHuCheShouRu;
	}
}