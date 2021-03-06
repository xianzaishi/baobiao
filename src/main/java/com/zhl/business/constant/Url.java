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
	 * 平均病床工作日 按科室
	 */
	public static final String REPORT_AVG_WORKING_BEDS_BY_DEPT = "/report/avgWorkingBedsByDept/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 病床周转次数分析 按月
	 */
	public static final String BED_TURNOVER_TIMES = "/report/bedTurnoverTimes/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 病床周转次数分析 按科室
	 */
	public static final String BED_TURNOVER_TIMES_BY_DEPT = "/report/bedTurnoverTimesByDept/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 门诊诊断符合率
	 */
	public static final String OP_DIAGNOSTIC_RATE = "/report/opDiagnosticRate/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 全院临床病理符合率 按月
	 */
	public static final String PATHOLOGICA_RATE = "/report/pathologicalRate/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 全院临床病理符合率 按科室
	 */
	public static final String PATHOLOGICA_RATE_BY_DEPY = "/report/pathologicalRateByDept/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 大型设备阳性率
	 */
	public static final String EQUIPMENT_POSITIVE_RATE = "/report/equipmentPositiveRate/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 好转率 按月
	 */
	public static final String IMPROVEMENT_RATE_BY_MONTH = "/report/improvementRateByMonth/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 好转率 按科室
	 */
	public static final String IMPROVEMENT_RATE_BY_DEPT = "/report/improvementRateByDept/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 治愈率 按月
	 */
	public static final String CURE_RATE_BY_MONTH = "/report/cureRateByMonth/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 治愈率 按科室
	 */
	public static final String CURE_RATE_BY_DEPT = "/report/cureRateByDept/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 死亡率 按月
	 */
	public static final String DEATH_RATE_BY_MONTH = "/report/deathRateByMonth/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 死亡率 按科室
	 */
	public static final String DEATH_RATE_BY_DEPT = "/report/deathRateByDept/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 手术明细表 愈合 甲
	 */
	public static final String OPERATION_DETAIL_FIRST = "/report/operationDetailFirst/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 手术明细表 愈合 乙
	 */
	public static final String OPERATION_DETAIL_SECOND = "/report/operationDetailSecond/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 手术明细表 愈合 丙
	 */
	public static final String OPERATION_DETAIL_THIRD = "/report/operationDetailThird/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 手术明细表 愈合 丁
	 */
	public static final String OPERATION_DETAIL_FORTH = "/report/operationDetailForth/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 分科病人手术操作质量 全院
	 */
	public static final String OPERATION_QUALITH_BY_DEPT = "/report/operationQualityByDept/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 分科病人手术操作质量 外科系统
	 */
	public static final String OPERATION_QUALITH_BY_DEPT_WAIKE = "/report/operationQualityByDeptWaiKe/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 分科病人手术操作质量 外科系统
	 */
	public static final String OPERATION_QUALITH_BY_DEPT_NEIKE = "/report/operationQualityByDeptNeiKe/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 入出院诊断符合率
	 */
	public static final String DIAGNOSTIC_RATE = "/report/diagnosticRate/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 手术前后诊断符合率
	 */
	public static final String OPERATION_DIAGNOSTIC_RATE = "/report/operationDiagnosticRate/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 临床主要诊断与病理诊断符合率
	 */
	public static final String BING_LI_ZHEN_DUAN_RATE = "/report/bingLiZhenDuanRate/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 重点手术疗效及费用(ICD)18以上
	 */
	public static final String ZHONG_DIAN_SHOU_SHU_LIAO_XIAO = "/report/zhongDianShouShuLiaoXiao/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 重点疾病疗效及费用(ICD)18以上
	 */
	public static final String ZHONG_DIAN_JI_BING_LIAO_XIAO = "/report/zhongDianJiBingLiaoXiao/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 重点疾病疗效及费用(ICD)18以上 卫生部
	 */
	public static final String ZHONG_DIAN_JI_BING_LIAO_XIAO_WEI_SHENG_BU = "/report/zhongDianJiBingLiaoXiaoWeiShengBu/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * DR甲片率
	 */
	public static final String DR_JIA_PIAN_LV = "/report/DRJiaPianLv/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 单病种手术疾病疗效及费用
	 */
	public static final String DAN_BING_ZHONG_SHOU_SHU_JI_BING_LIAO_XIAO = "/report/danBingZhongShouShuJiBingLiaoXiao/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/**
	 * 各科室手消剂及洗手液消耗量统计表
	 */
	public static final String XIAO_DU_JI_TONG_JI_BIAO = "/report/xiaoDuJiTongJiBiao/dateStart/{dateStart}/dateEnd/{dateEnd}";

	/*--------------------------------- 报表模块 结束 --------------------------------------*/
}
