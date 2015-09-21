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

	/**
	 * 治疗质量
	 */
	public static final String REPORT_WORK_QUALITY = "/report/workQuality/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 工作效率
	 */
	public static final String REPORT_WORK_EFFICIENCY = "/report/workEfficiency/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 患者负担
	 */
	public static final String REPORT_PATIENT_COST = "/report/patientCost/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 资产运营
	 */
	public static final String REPORT_ASSETS_OPERATION = "/report/assetsOperation/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 按抢救成功率分析
	 */
	public static final String REPORT_RESCUE_SUCCESS_RATE = "/report/rescueSuccessRate/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 出院患者平均住院天数分析
	 */
	public static final String REPORT_DAY_OF_PATIENT_COST = "/report/dayOfPatientCost/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 在院病人分布
	 */
	public static final String REPORT_IP_SPREAD = "/report/ipSpread/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 平均病床工作日
	 */
	public static final String REPORT_AVG_WORKING_BEDS = "/report/avgWorkingBeds/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 病床周转次数分析
	 */
	public static final String BED_TURNOVER_TIMES = "/report/bedTurnoverTimes/dateStart/{dateStart}/dateEnd/{dateEnd}";
	/*--------------------------------- 报表模块 结束 --------------------------------------*/
}
