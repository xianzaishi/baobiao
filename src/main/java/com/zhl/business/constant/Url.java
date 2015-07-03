package com.zhl.business.constant;

public class Url {
	/**
	 * 首页
	 */
	public static final String INDEX = "/index";
	
	/**
	 * 登陆后首页
	 */
	public static final String SECOND = "/second";

	/*--------------------------------- 报表模块 开始 --------------------------------------*/
	public static final String REPORT_BASE = "/report";
	/**
	 * 报表首页
	 */
	public static final String REPORT_INDEX = REPORT_BASE + "/index";

	/**
	 * 院长日报
	 */
	public static final String REPORT_DAILY_DEAN_INDEX = REPORT_BASE + "/daily/dean";

	/**
	 * 院长日报
	 */
	public static final String REPORT_DAILY_DEAN = REPORT_BASE + "/daily/dean/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 显示查询中页面
	 */
	public static final String REPORT_SEARCHING = "/report/search/dateStart/{dateStart}/dateEnd/{dateEnd}/parm/{parm}";

	/**
	 * 资源配置
	 */
	public static final String REPORT_RESOURCES = "/report/resources";

	/**
	 * 工作负荷
	 */
	public static final String REPORT_WORKLOAD = "/report/workload/dateStart/{dateStart}/dateEnd/{dateEnd}";
	/*--------------------------------- 报表模块 结束 --------------------------------------*/
}