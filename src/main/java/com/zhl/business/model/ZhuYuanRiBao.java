package com.zhl.business.model;

/**
 * 住院日报
 * 
 * @author 张宏亮
 *
 */
public class ZhuYuanRiBao {
	/**
	 * 病人id
	 */
	private int bingRenId;

	/**
	 * 入院数
	 */
	private int ruYuanShu;

	/**
	 * 转入数
	 */
	private int zhuanRuShu;

	/**
	 * 出院数
	 */
	private int chuYuanShu;

	/**
	 * 转出数
	 */
	private int zhuanChuShu;

	/**
	 * 陪伴
	 */
	private int peiBan;

	/**
	 * 危重
	 */
	private int weiZhong;

	/**
	 * 开放床数
	 */
	private int kaiFangChuangShu;

	/**
	 * 其中死亡
	 */
	private int qiZhongSiWang;

	/**
	 * 本日加床
	 */
	private int benRiJiaChuang;

	/**
	 * 床位占用数 也是在院人数
	 */
	private int chuangWeiZhanYongShu;

	/**
	 * 家庭病床
	 */
	private int jiaTingBingChuang;

	public int getBingRenId() {
		return bingRenId;
	}

	public void setBingRenId(int bingRenId) {
		this.bingRenId = bingRenId;
	}

	public int getRuYuanShu() {
		return ruYuanShu;
	}

	public void setRuYuanShu(int ruYuanShu) {
		this.ruYuanShu = ruYuanShu;
	}

	public int getZhuanRuShu() {
		return zhuanRuShu;
	}

	public void setZhuanRuShu(int zhuanRuShu) {
		this.zhuanRuShu = zhuanRuShu;
	}

	public int getChuYuanShu() {
		return chuYuanShu;
	}

	public void setChuYuanShu(int chuYuanShu) {
		this.chuYuanShu = chuYuanShu;
	}

	public int getZhuanChuShu() {
		return zhuanChuShu;
	}

	public void setZhuanChuShu(int zhuanChuShu) {
		this.zhuanChuShu = zhuanChuShu;
	}

	public int getPeiBan() {
		return peiBan;
	}

	public void setPeiBan(int peiBan) {
		this.peiBan = peiBan;
	}

	public int getWeiZhong() {
		return weiZhong;
	}

	public void setWeiZhong(int weiZhong) {
		this.weiZhong = weiZhong;
	}

	public int getKaiFangChuangShu() {
		return kaiFangChuangShu;
	}

	public void setKaiFangChuangShu(int kaiFangChuangShu) {
		this.kaiFangChuangShu = kaiFangChuangShu;
	}

	public int getQiZhongSiWang() {
		return qiZhongSiWang;
	}

	public void setQiZhongSiWang(int qiZhongSiWang) {
		this.qiZhongSiWang = qiZhongSiWang;
	}

	public int getBenRiJiaChuang() {
		return benRiJiaChuang;
	}

	public void setBenRiJiaChuang(int benRiJiaChuang) {
		this.benRiJiaChuang = benRiJiaChuang;
	}

	public int getChuangWeiZhanYongShu() {
		return chuangWeiZhanYongShu;
	}

	public void setChuangWeiZhanYongShu(int chuangWeiZhanYongShu) {
		this.chuangWeiZhanYongShu = chuangWeiZhanYongShu;
	}

	public int getJiaTingBingChuang() {
		return jiaTingBingChuang;
	}

	public void setJiaTingBingChuang(int jiaTingBingChuang) {
		this.jiaTingBingChuang = jiaTingBingChuang;
	}
}
