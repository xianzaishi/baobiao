package com.zhl.business.dto;


/**
 * 科室数据Dto
 * 
 * @author 张宏亮
 *
 */
public class ZaiYuanBingRenFenBuDto {
	/**
	 * 编码
	 */
	private String id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 人数
	 */
	private String count;

	/**
	 * 比例
	 */
	private String scale;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}
}
