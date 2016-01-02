package com.zhl.business.model;

/**
 * 各科室手消剂及洗手液消耗量统计表
 * 
 * @author 张宏亮
 *
 */
public class XiaoDuJiTongJiBiao {
	/**
	 * 科室id
	 */
	private int deptId;

	/**
	 * 科室名称
	 */
	private String dept;
	
	/**
	 * 实际占用总床日数
	 */
	private double shiJiZhanYongZongChuangRiShu;

	/**
	 * 手消出库(ml)
	 */
	private double shouXiaoChuKu;

	/**
	 * 洗手液出库(ml)
	 */
	private double xiShouYeChuKu;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

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

	public double getShouXiaoChuKu() {
		return shouXiaoChuKu;
	}

	public void setShouXiaoChuKu(double shouXiaoChuKu) {
		this.shouXiaoChuKu = shouXiaoChuKu;
	}

	public double getXiShouYeChuKu() {
		return xiShouYeChuKu;
	}

	public void setXiShouYeChuKu(double xiShouYeChuKu) {
		this.xiShouYeChuKu = xiShouYeChuKu;
	}
}
