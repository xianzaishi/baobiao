package com.zhl.business.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhl.business.constant.Url;
import com.zhl.business.constant.View;
import com.zhl.business.dto.BingChuangGongZuoRiDto;
import com.zhl.business.dto.BingLiZhenDuanFuHeLvDto;
import com.zhl.business.dto.DataDto;
import com.zhl.business.dto.DeptDateDto;
import com.zhl.business.dto.DiagnosticDto;
import com.zhl.business.dto.OpDiagnosticDto;
import com.zhl.business.dto.OperationDiagnostic;
import com.zhl.business.dto.PathologicalRateByDeptDto;
import com.zhl.business.dto.RuChuYuanShuDto;
import com.zhl.business.dto.ZaiYuanBingRenFenBuDto;
import com.zhl.business.dto.ZhongDianJiBingLiaoXiao18Dto;
import com.zhl.business.dto.ZhongDianShouShuLiaoXiao18Dto;
import com.zhl.business.dto.ZhuYuanShouRuDto;
import com.zhl.business.model.ComputeRateModel;
import com.zhl.business.model.Department;
import com.zhl.business.model.EquipmentPositiveRate;
import com.zhl.business.model.OperationDetail;
import com.zhl.business.model.OperationQuality;
import com.zhl.business.model.ZhuYuanRiBao;
import com.zhl.business.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService reportService;

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_INDEX)
	public String index(ModelMap model) {
		String name = reportService.query();
		model.addAttribute("name", name);
		return View.ReportIndexView;
	}

	/**
	 * 院长日报
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_DAILY_DEAN_INDEX)
	public String daily4DeanIndex() {
		return View.ReportIndexView;
	}

	/**
	 * 院长日报 查询
	 * 
	 * @param dateStart
	 * @param model
	 */
	@RequestMapping(value = Url.REPORT_DAILY_DEAN)
	public String daily4Dean(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		ZhuYuanRiBao zhuYuanRiBao = new ZhuYuanRiBao();
		zhuYuanRiBao = queryZhuYuanRiBao(StartTime, EndTime);

		// 门诊收入 = 挂号收入 + 门诊收费收入 + 体检收入
		double guaHaoShouRu = reportService.queryGuaHaoShouRu(dateMap); // 门诊挂号收入
		double menZhenShouFeiShouRu = reportService.queryMenZhenShouFeiShouRu(dateMap); // 门诊收费收入
		double tiJianShouRu = reportService.queryTiJianShouRu(dateMap); // 体检收入
		double menZhenShouRu = guaHaoShouRu + menZhenShouFeiShouRu + tiJianShouRu; // 门诊收入

		ZhuYuanShouRuDto zhuYuanShouRuDto = reportService.queryZhuYuanShouRu(dateMap); // 在院收入
		double opBaoXianTotal = reportService.queryOpBaoXianTotal(dateMap);	// 门诊保险收入
		double ipBaoXianTotal = reportService.queryIpBaoXianTotal(dateMap);	// 在院保险收入
		double opTongChouTotal = reportService.queryOpTongChouTotal(dateMap);	// 门诊医保 统筹收入
		double ipTongChouTotal = reportService.queryIpTongChouTotal(dateMap);	// 在院医保 统筹收入

		double menJiZhenRenCiTotal = reportService.queryMenJiZhenRenCiTotal(dateMap);	// 门急诊人次
		double jiZhenRenCiTotal = reportService.queryJiZhenRenCiTotal(dateMap);	// 急诊人次
		double menZhenYiBaoTotal = reportService.queryMenZhenYiBaoTotal(dateMap);	// 门诊医保人次
		double chuZhenYiShengTotal = 49; // 门诊出诊医生reportService.queryChuZhenYiShengTotal(dateMap);
		double chuFangTotal = reportService.queryChuFangTotal(dateMap);	//门诊处方数
		double menZhenTuiFeiTotal = reportService.queryMenZhenTuiFeiTotal(dateMap);	//门诊退费金额
		double menZhenKangShengSuTotal = reportService.queryMenZhenKangShengSuTotal(dateMap);	//门诊使用抗生素数
		double ruYuanAndYiBaoTotal = reportService.queryRuYuanAndYiBaoTotal(dateMap);	//入院人数 医保人数
		double zaiYuanTotal = reportService.queryZaiYuanTotal(dateMap); // 在院人数;
		double zaiYuanAndYiBaoTotal = reportService.queryZaiYuanAndYiBaoTotal(dateMap);	//在院人数 医保人数
		double zaiYuanAndXueTouTotal = reportService.queryZaiYuanAndXueTouTotal(dateMap);	//在院人数 血透人数
		double chuYuanAndYiBaoTotal = reportService.queryChuYuanAndYiBaoTotal(dateMap);	//出院人数 医保人数
		double queryXueTouShouRu = reportService.queryXueTouShouRu(dateMap);	// 血透收入
		
		RuChuYuanShuDto ruChuYuanShu = new RuChuYuanShuDto(); // 入出院人数 :reportService.queryRuChuYuanShu(dateMap);
		ruChuYuanShu.setRuYuanShu(zhuYuanRiBao.getRuYuanShu());
		ruChuYuanShu.setChuYuanShu(zhuYuanRiBao.getChuYuanShu());
		double menZhenYaoPinShouRu = reportService.queryMenZhenYaoPinShouRu(dateMap); // 门诊药品收入

		double sum = zhuYuanShouRuDto.getZongShouRu() + menZhenShouRu;

		model.addAttribute("sum", sum); // 总收入
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("opTotal", menZhenShouRu); // 门诊收入
		model.addAttribute("ipTotal", zhuYuanShouRuDto.getZongShouRu()); // 在院收入
		model.addAttribute("opDrugsTotal", menZhenYaoPinShouRu); // 门诊药品收入
		model.addAttribute("opTreatmentTotal", menZhenShouRu - menZhenYaoPinShouRu); // 门诊诊疗收入
		model.addAttribute("ipDrugsTotal", zhuYuanShouRuDto.getYaoPinShouRu()); // 在院药品收入
		model.addAttribute("ipTreatmentTotal", zhuYuanShouRuDto.getZhenLiaoShouRu()); // 在院诊疗收入
		model.addAttribute("opBaoXianTotal", opBaoXianTotal); // 门诊保险收入
		model.addAttribute("ipBaoXianTotal", ipBaoXianTotal); // 在院保险收入
		model.addAttribute("opTongChouTotal", opTongChouTotal); // 门诊医保 统筹收入
		model.addAttribute("ipTongChouTotal", ipTongChouTotal); // 在院医保 统筹收入
		model.addAttribute("opBaoXianXianJinTotal", opBaoXianTotal - opTongChouTotal); // 门诊医保 现金收入
		model.addAttribute("ipBaoXianXianJinTotal", ipBaoXianTotal - ipTongChouTotal); // 在院医保 现金收入

		model.addAttribute("menJiZhenRenCiTotal", menJiZhenRenCiTotal); // 门急诊人次
		model.addAttribute("jiZhenRenCiTotal", jiZhenRenCiTotal); // 急诊人次
		model.addAttribute("menZhenRenCiTotal", menJiZhenRenCiTotal - jiZhenRenCiTotal); // 门诊人次
		model.addAttribute("menZhenYiBaoTotal", menZhenYiBaoTotal); // 门诊医保人次
		model.addAttribute("menZhenZiFeiTotal", menJiZhenRenCiTotal - menZhenYiBaoTotal); // 门诊自费人次
		model.addAttribute("chuZhenYiShengTotal", chuZhenYiShengTotal); // 门诊出诊医生
		model.addAttribute("chuFangTotal", chuFangTotal); //门诊处方数
		model.addAttribute("menZhenTuiFeiTotal", menZhenTuiFeiTotal); //门诊退费金额
		model.addAttribute("menZhenKangShengSuTotal", menZhenKangShengSuTotal); //门诊使用抗生素数
		model.addAttribute("ruYuanTotal", ruChuYuanShu.getRuYuanShu()); //入院人数
		model.addAttribute("ruYuanAndYiBaoTotal", ruYuanAndYiBaoTotal); //入院人数 医保人数
		model.addAttribute("ruYuanAndZiFeiTotal", ruChuYuanShu.getRuYuanShu() - ruYuanAndYiBaoTotal); //在院人数 自费人数
		model.addAttribute("zaiYuanTotal", zaiYuanTotal); //在院人数
		model.addAttribute("zaiYuanAndYiBaoTotal", zaiYuanAndYiBaoTotal); //在院人数 医保人数
		model.addAttribute("zaiYuanAndXueTouTotal", zaiYuanAndXueTouTotal); //在院人数 血透人数
		model.addAttribute("zaiYuanAndZiFeiTotal", zaiYuanTotal - zaiYuanAndYiBaoTotal - zaiYuanAndXueTouTotal); // 在院人数  自费人数
		model.addAttribute("chuYuanTotal", ruChuYuanShu.getChuYuanShu()); //出院人数
		model.addAttribute("chuYuanAndYiBaoTotal", chuYuanAndYiBaoTotal); //出院人数 医保人数
		model.addAttribute("chuYuanAndZiFeiTotal", ruChuYuanShu.getChuYuanShu() - chuYuanAndYiBaoTotal); //出院人数 自费人数
		model.addAttribute("shiYongChuangWeiTotal", zaiYuanTotal); // 使用床位数 等于 在院人数
		model.addAttribute("queryXueTouShouRu", queryXueTouShouRu); // 血透收入

		return View.Report4DeanView;
	}

	/**
	 * 显示查询中页面
	 * 
	 * @param parm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_SEARCHING)
	public String searching(@PathVariable String dateStart, @PathVariable String dateEnd, @PathVariable int parm, ModelMap model) {
		String url = "";
		switch (parm) {
		case 1: // 院长日报
			url = "/report/daily/dean/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 3: // 工作负荷
			url = "/report/workload/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 4: // 治疗质量
			url = "/report/workQuality/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 5: // 工作效率
			url = "/report/workEfficiency/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 6: // 患者负担
			url = "/report/patientCost/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 7: // 资产运营
			url = "/report/assetsOperation/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 9: // 按抢救成功率分析
			url = "/report/rescueSuccessRate/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 10: // 患者平均住院天数分析
			url = "/report/dayOfPatientCost/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 11: // 平均病床工作日
			url = "/report/avgWorkingBeds/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 12: // 病床周转次数
			url = "/report/bedTurnoverTimes/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 13: // 门诊诊断符合率
			url = "/report/opDiagnosticRate/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 14: // 全院临床病理符合率
			url = "/report/pathologicalRate/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 15: // 大型设备阳性率
			url = "/report/equipmentPositiveRate/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 16: // 好转率
			url = "/report/improvementRateByMonth/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 17: // 治愈率
			url = "/report/cureRateByMonth/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 18: // 死亡率
			url = "/report/deathRateByMonth/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 23: // 好转率 按科室
			url = "/report/improvementRateByDept/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 24: // 治愈率 按科室
			url = "/report/cureRateByDept/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 25: // 死亡率 按科室
			url = "/report/deathRateByDept/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 27: // 病床周转次数 按科室
			url = "/report/bedTurnoverTimesByDept/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 28: // 全院临床病理符合率 按科室
			url = "/report/pathologicalRateByDept/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 33: // 平均病床工作日 按科室
			url = "/report/avgWorkingBedsByDept/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 36: // 手术明细表 愈合 甲
			url = "/report/operationDetailFirst/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 37: // 手术明细表 愈合 乙
			url = "/report/operationDetailSecond/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 38: // 手术明细表 愈合 丙
			url = "/report/operationDetailThird/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 39: // 手术明细表 愈合 丁
			url = "/report/operationDetailForth/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 41: // 分科病人手术操作质量 全院
			url = "/report/operationQualityByDept/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 42: // 分科病人手术操作质量 外科
			url = "/report/operationQualityByDeptWaiKe/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 43: // 分科病人手术操作质量 内科
			url = "/report/operationQualityByDeptNeiKe/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 44: // 入出院诊断符合率
			url = "/report/diagnosticRate/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 45: // 手术前后诊断符合率
			url = "/report/operationDiagnosticRate/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 46: // 临床主要诊断与病理诊断符合率
			url = "/report/bingLiZhenDuanRate/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 47: // 重点手术疗效及费用(ICD)18以上
			url = "/report/zhongDianShouShuLiaoXiao/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 49: // 重点疾病疗效及费用(ICD)18以上
			url = "/report/zhongDianJiBingLiaoXiao/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		case 50: // 重点疾病疗效及费用(ICD)18以上 卫生部
			url = "/report/zhongDianJiBingLiaoXiaoWeiShengBu/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
			model.addAttribute("url", url);
			break;
		}
		return View.ReportSearchingView;
	}

	/**
	 * 资源配置
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_RESOURCES)
	public String reportResources() {
		return View.ReportResourcesView;
	}

	/**
	 * 工作负荷
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_WORKLOAD)
	public String reportWorkload(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		double jiZhenRenCiTotal = reportService.queryJiZhenRenCiTotal(dateMap); // 急诊人次
		double menJiZhenRenCiTotal = reportService.queryMenJiZhenRenCiTotal(dateMap); // 门急诊人次
		double menZhenRenCiTotal = menJiZhenRenCiTotal - jiZhenRenCiTotal; // 门诊人次
		int tiJianRenCi = reportService.queryTiJianRenShu(dateMap); // 体检人次
		RuChuYuanShuDto ruChuYuanShu = new RuChuYuanShuDto();// 入出院人数 reportService.queryRuChuYuanShu(dateMap);
		ZhuYuanRiBao zhuYuanRiBao = new ZhuYuanRiBao();
		zhuYuanRiBao = queryZhuYuanRiBao(StartTime, EndTime);
		ruChuYuanShu.setChuYuanShu(zhuYuanRiBao.getChuYuanShu());
		ruChuYuanShu.setRuYuanShu(zhuYuanRiBao.getRuYuanShu());
		int chuYuanZongChuangRi = reportService.queryChuYuanZongChuangRi(dateMap); // 出院患者实际占用总床日
		int zhuYuanShouShuLiShu = reportService.queryZhuYuanShouShuLiShu(dateMap); // 住院手术例数
		int menZhenShouShuLiShu = reportService.queryMenZhenShouShuLiShu(dateMap); // 门诊手术例数
		int liuGuanRenCi = reportService.queryLiuGuanRenCi(dateMap); // 留观人次

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("jiZhenRenCiTotal", jiZhenRenCiTotal); // 急诊人次
		model.addAttribute("menZhenRenCiTotal", menZhenRenCiTotal); // 门诊人次
		model.addAttribute("tiJianRenCi", tiJianRenCi); // 体检人次
		model.addAttribute("ruYuanRenShu", ruChuYuanShu.getRuYuanShu()); // 入院人数
		model.addAttribute("chuYuanRenShu", ruChuYuanShu.getChuYuanShu()); // 出院人数
		model.addAttribute("chuYuanZongChuangRi", chuYuanZongChuangRi); // 出院患者实际占用总床日
		model.addAttribute("zhuYuanShouShuLiShu", zhuYuanShouShuLiShu); // 住院手术例数
		model.addAttribute("menZhenShouShuLiShu", menZhenShouShuLiShu); // 门诊手术例数
		model.addAttribute("liuGuanRenCi", liuGuanRenCi); // 留观人次
		return View.ReportWorkloadView;
	}

	/**
	 * 治疗质量
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_WORK_QUALITY)
	public String workQuality(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		int zhuYuanShouShuLiShu = reportService.queryZhuYuanShouShuLiShu(dateMap); // 住院手术例数
		int zhuYuanSiWangShu = reportService.queryZhuYuanSiWangShu(dateMap); // 住院患者死亡例数
		int zhuYuanShouShuSiWangShu = reportService.queryZhuYuanShouShuSiWangShu(dateMap); // 住院手术死亡例数
		int xinShengErChuYuanShu = reportService.queryXinShengErChuYuanShu(dateMap); // 新生儿患者出院人数
		int xinShengErSiWangShu = reportService.queryXinShengErSiWangShu(dateMap); // 新生儿患者出院死亡人数
		int zhuYuanWeiZhongQiangQiu = reportService.queryZhuYuanWeiZhongQiangQiu(dateMap); // 住院危重抢救例数
		int zhuYuanWeiZhongQiangQiuSiWang = reportService.queryZhuYuanWeiZhongQiangQiuSiWang(dateMap); // 住院危重抢救死亡例数
		int jiZhenWeiZhongQiangJiu = reportService.queryJiZhenWeiZhongQiangJiu(dateMap); // 急诊科危重抢救例数
		int jiZhenWeiZhongQiangJiuSiWang = reportService.queryJiZhenWeiZhongQiangJiuSiWang(dateMap); // 急诊科危重抢救死亡例数
		int ziDongLiYuan = reportService.queryZiDongLiYuan(dateMap); // 住院患者自动出院例数(无费出院)
		int shuQianZhenDuanFuHe = reportService.queryShuQianZhenDuanFuHe(dateMap); // 恶性肿瘤手术前诊断与术后病理诊断符合例数

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("zhuYuanShouShuLiShu", zhuYuanShouShuLiShu); // 住院手术例数
		model.addAttribute("zhuYuanSiWangShu", zhuYuanSiWangShu); // 住院患者死亡例数
		model.addAttribute("zhuYuanShouShuSiWangShu", zhuYuanShouShuSiWangShu); // 住院手术死亡例数
		model.addAttribute("xinShengErChuYuanShu", xinShengErChuYuanShu); // 新生儿患者出院人数
		model.addAttribute("xinShengErSiWangShu", xinShengErSiWangShu); // 新生儿患者出院死亡人数
		model.addAttribute("zhuYuanWeiZhongQiangQiu", zhuYuanWeiZhongQiangQiu); // 住院危重抢救例数
		model.addAttribute("zhuYuanWeiZhongQiangQiuSiWang", zhuYuanWeiZhongQiangQiuSiWang); // 住院危重抢救死亡例数
		model.addAttribute("jiZhenWeiZhongQiangJiu", jiZhenWeiZhongQiangJiu); // 急诊科危重抢救例数
		model.addAttribute("jiZhenWeiZhongQiangJiuSiWang", jiZhenWeiZhongQiangJiuSiWang); // 急诊科危重抢救死亡例数
		model.addAttribute("ziDongLiYuan", ziDongLiYuan); // 住院患者自动出院例数(无费出院)
		model.addAttribute("shuQianZhenDuanFuHe", shuQianZhenDuanFuHe); // 恶性肿瘤手术前诊断与术后病理诊断符合例数
		return View.ReportWorkQualityView;
	}

	/**
	 * 工作效率
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_WORK_EFFICIENCY)
	public String workEfficiency(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);
		
		double zaiYuanTotal = reportService.queryZaiYuanTotal(dateMap);	//使用床位数 等于 在院人数
		int chuYuanZongChuangRi = reportService.queryChuYuanZongChuangRi(dateMap); // 出院患者实际占用总床日
		RuChuYuanShuDto ruChuYuanShu = new RuChuYuanShuDto(); // 入出院人数reportService.queryRuChuYuanShu(dateMap);
		ZhuYuanRiBao zhuYuanRiBao = new ZhuYuanRiBao();
		zhuYuanRiBao = queryZhuYuanRiBao(StartTime, EndTime);
		ruChuYuanShu.setChuYuanShu(zhuYuanRiBao.getChuYuanShu());
		ruChuYuanShu.setRuYuanShu(zhuYuanRiBao.getRuYuanShu());
		double chuYuanPingJunZhuYuanRi = chuYuanZongChuangRi / ruChuYuanShu.getChuYuanShu(); // 出院患者平均住院日
		int huanChuangShu = reportService.queryHuanChuangShu(dateMap); // 换床总次数

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("shiYongChuangWeiTotal", zaiYuanTotal); // 使用床位数 等于 在院人数
		model.addAttribute("chuYuanPingJunZhuYuanRi", chuYuanPingJunZhuYuanRi); // 出院患者平均住院日
		model.addAttribute("chuYuanZongChuangRi", chuYuanZongChuangRi); // 出院患者实际占用总床日
		model.addAttribute("chuangWeiZhouZhuanCiShu", huanChuangShu); // 换床总次数
		return View.ReportWorkEfficiencyView;
	}

	/**
	 * 患者负担
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_PATIENT_COST)
	public String patientCost(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		// 门诊收入 = 挂号收入 + 门诊收费收入 + 体检收入
		double guaHaoShouRu = reportService.queryGuaHaoShouRu(dateMap); // 门诊挂号收入
		double menZhenShouFeiShouRu = reportService.queryMenZhenShouFeiShouRu(dateMap); // 门诊收费收入
		double tiJianShouRu = reportService.queryTiJianShouRu(dateMap); // 体检收入
		double menZhenShouRu = guaHaoShouRu + menZhenShouFeiShouRu + tiJianShouRu; // 门诊收入
		double menZhenYaoPinShouRu = reportService.queryMenZhenYaoPinShouRu(dateMap); // 门诊药品收入

		double menJiZhenRenCiTotal = reportService.queryMenJiZhenRenCiTotal(dateMap); // 门急诊人次
		double zaiYuanTotal = reportService.queryZaiYuanTotal(dateMap); // 在院人数
		ZhuYuanShouRuDto zhuYuanShouRuDto = reportService.queryZhuYuanShouRu(dateMap); // 在院收入

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("opTotal", menZhenShouRu); // 门诊收入
		model.addAttribute("menJiZhenRenCiTotal", menJiZhenRenCiTotal); // 门急诊人次
		model.addAttribute("opDrugsTotal", menZhenYaoPinShouRu); // 门诊药品收入
		model.addAttribute("ipTotal", zhuYuanShouRuDto.getZongShouRu()); // 在院收入
		model.addAttribute("zaiYuanTotal", zaiYuanTotal); // 在院人数
		model.addAttribute("ipDrugsTotal", zhuYuanShouRuDto.getYaoPinShouRu()); // 在院药品收入
		return View.ReportPatientCostView;
	}

	/**
	 * 资产运营
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_ASSETS_OPERATION)
	public String assetsOperation(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		double menZhenYaoPinShouRu = reportService.queryMenZhenYaoPinShouRu(dateMap); // 门诊药品收入

		ZhuYuanShouRuDto zhuYuanShouRuDto = reportService.queryZhuYuanShouRu(dateMap); // 在院收入
		double yiLiaoCaiLiaoShouRu = reportService.queryYiliaoCaiLiaoShouRu(dateMap); // 医疗材料收入

		double guaHaoShouRu = reportService.queryGuaHaoShouRu(dateMap); // 门诊挂号收入
		double menZhenShouFeiShouRu = reportService.queryMenZhenShouFeiShouRu(dateMap); // 门诊收费收入
		double tiJianShouRu = reportService.queryTiJianShouRu(dateMap); // 体检收入
		double menZhenShouRu = guaHaoShouRu + menZhenShouFeiShouRu + tiJianShouRu; // 门诊收入
		double sum = zhuYuanShouRuDto.getZongShouRu() + menZhenShouRu;

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("ipDrugsTotal", zhuYuanShouRuDto.getYaoPinShouRu()); // 在院药品收入
		model.addAttribute("opDrugsTotal", menZhenYaoPinShouRu); // 门诊药品收入
		model.addAttribute("yiLiaoCaiLiaoShouRu", yiLiaoCaiLiaoShouRu); // 医疗材料收入
		model.addAttribute("yiLiaoShouRu", sum); // 医疗材料收入
		return View.AssetsOperationView;
	}

	/**
	 * 按抢救成功率分析
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_RESCUE_SUCCESS_RATE)
	public String rescueSuccessRate(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		// 查询医疗部门
		List<DeptDateDto> deptDateDtoList = new LinkedList<DeptDateDto>();
		deptDateDtoList = reportService.queryYiLiaoDept();
		
		List<DeptDateDto> deptDateDtoResultList = new LinkedList<DeptDateDto>();

		for (int i = 0; i < deptDateDtoList.size(); i++) {
			DeptDateDto deptDateDto = new DeptDateDto();
			int id = deptDateDtoList.get(i).getId();
			deptDateDto.setId(id);
			deptDateDto.setName(deptDateDtoList.get(i).getName());
			dateMap.put("id", Integer.toString(deptDateDtoList.get(i).getId()));
			List<Double> dateList = reportService.queryQiangJiuChengGongLvByDeptId(dateMap);
			dateMap.remove("id");
			deptDateDto.setDateList(dateList);
			// 去掉没有抢救的
			if (dateList.get(1) != 0) {
				deptDateDtoResultList.add(deptDateDto);
			}
		}
		
		String data = "";
		for (int i = 0; i < deptDateDtoResultList.size(); i++) {
			// if ((deptDateDtoResultList.get(i).getDateList().get(1) == 0 ? 0 :
			// (deptDateDtoResultList.get(i).getDateList().get(0) /
			// deptDateDtoResultList.get(i)
			// .getDateList().get(1)) * 100) > 0) {
				data += "['"
						+ deptDateDtoResultList.get(i).getName()
						+ "',"
						+ (deptDateDtoResultList.get(i).getDateList().get(1) == 0 ? 0
								: (deptDateDtoResultList.get(i).getDateList().get(0) / deptDateDtoResultList.get(i).getDateList().get(1)) * 100) + "],";
			// }
		}

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("deptDateDtoResultList", deptDateDtoResultList);
		model.addAttribute("data", data);
		return View.RescueSuccessRateView;
	}

	/**
	 * 查询住院日报
	 * 
	 * @return
	 */
	private ZhuYuanRiBao queryZhuYuanRiBao(String dateStart, String dateEnd) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);

		// 查询住院日报统计的医疗部门
		List<Department> deptList = new LinkedList<Department>();
		deptList = reportService.queryZhuYuanRiBaoDept();

		// 住院日报List
		List<ZhuYuanRiBao> zhuYuanRiBaoList = new LinkedList<ZhuYuanRiBao>();

		for (int i = 0; i < deptList.size(); i++) {
			dateMap.put("id", Integer.toString(deptList.get(i).getId()));
			zhuYuanRiBaoList.add(reportService.queryZhuYuanRiBaoByDeptId(dateMap));
			dateMap.remove("id");
		}

		// 求和
		ZhuYuanRiBao zhuYuanRiBao = new ZhuYuanRiBao();
		zhuYuanRiBao.setBingRenId(0);

		int ruYuanShu = 0; // 入院数
		int zhuanRuShu = 0; // 转入数
		int chuYuanShu = 0; // 出院数
		int zhuanChuShu = 0; // 转出数
		int peiBan = 0; // 陪伴
		int weiZhong = 0; // 危重
		int kaiFangChuangShu = 0; // 开放床数
		int qiZhongSiWang = 0; // 其中死亡
		int benRiJiaChuang = 0; // 本日加床
		int chuangWeiZhanYongShu = 0; // 床位占用数
		int jiaTingBingChuang = 0; // 家庭病床
		for (int i = 0; i < zhuYuanRiBaoList.size(); i++) {
			ruYuanShu += zhuYuanRiBaoList.get(i).getRuYuanShu();
			zhuanRuShu += zhuYuanRiBaoList.get(i).getZhuanRuShu();
			chuYuanShu += zhuYuanRiBaoList.get(i).getChuYuanShu();
			zhuanChuShu += zhuYuanRiBaoList.get(i).getZhuanChuShu();
			peiBan += zhuYuanRiBaoList.get(i).getPeiBan();
			weiZhong += zhuYuanRiBaoList.get(i).getWeiZhong();
			kaiFangChuangShu += zhuYuanRiBaoList.get(i).getKaiFangChuangShu();
			qiZhongSiWang += zhuYuanRiBaoList.get(i).getQiZhongSiWang();
			benRiJiaChuang += zhuYuanRiBaoList.get(i).getBenRiJiaChuang();
			chuangWeiZhanYongShu += zhuYuanRiBaoList.get(i).getChuangWeiZhanYongShu();
			jiaTingBingChuang += zhuYuanRiBaoList.get(i).getJiaTingBingChuang();
		}
		zhuYuanRiBao.setRuYuanShu(ruYuanShu);
		zhuYuanRiBao.setZhuanRuShu(zhuanRuShu);
		zhuYuanRiBao.setChuYuanShu(chuYuanShu);
		zhuYuanRiBao.setZhuanChuShu(zhuanChuShu);
		zhuYuanRiBao.setPeiBan(peiBan);
		zhuYuanRiBao.setWeiZhong(weiZhong);
		zhuYuanRiBao.setKaiFangChuangShu(kaiFangChuangShu);
		zhuYuanRiBao.setQiZhongSiWang(qiZhongSiWang);
		zhuYuanRiBao.setBenRiJiaChuang(benRiJiaChuang);
		zhuYuanRiBao.setChuangWeiZhanYongShu(chuangWeiZhanYongShu);
		zhuYuanRiBao.setJiaTingBingChuang(jiaTingBingChuang);

		return zhuYuanRiBao;
	}

	/**
	 * 出院患者平均住院天数分析
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_DAY_OF_PATIENT_COST)
	public String dayOfPatientCost(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		// 查询医疗部门
		List<Department> deptList = new LinkedList<Department>();
		deptList = reportService.queryZhuYuanRiBaoDept();

		List<DeptDateDto> deptDateDtoResultList = new LinkedList<DeptDateDto>();

		String data = "";
		for (int i = 0; i < deptList.size(); i++) {
			DeptDateDto deptDateDto = new DeptDateDto();
			int id = deptList.get(i).getId();
			deptDateDto.setId(id);
			deptDateDto.setName(deptList.get(i).getName());
			dateMap.put("id", Integer.toString(deptList.get(i).getId()));
			List<Double> dateList = new LinkedList<Double>();

			double chuYuanZongChuangRi = reportService.queryChuYuanZongChuangRiByDeptId(dateMap); // 出院患者实际占用总床日
			double chuYuanShu = (double) reportService.queryZhuYuanRiBaoByDeptId(dateMap).getChuYuanShu(); // 出院人数
			double chuYuanPingJunZhuYuanRi = (chuYuanShu == 0 ? 0 : chuYuanZongChuangRi / chuYuanShu); // 出院患者平均住院日
			dateList.add(chuYuanPingJunZhuYuanRi);

			dateMap.remove("id");

			if (chuYuanPingJunZhuYuanRi != 0) {
				data += "['" + deptList.get(i).getName() + "'," + chuYuanPingJunZhuYuanRi + "],";
			}

			deptDateDto.setDateList(dateList);
			deptDateDtoResultList.add(deptDateDto);
		}

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("deptDateDtoResultList", deptDateDtoResultList);
		model.addAttribute("data", data);
		return View.DayOfPatientCostView;
	}

	/**
	 * 在院病人分布
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_IP_SPREAD)
	public String ipSpread(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		String StartTime = dateStart + " 00:00:00";
		String EndTime = dateEnd + " 23:59:59";
		dateMap.put("StartTime", StartTime);
		dateMap.put("EndTime", EndTime);

		List<ZaiYuanBingRenFenBuDto> zaiYuanBingRenFenBuList = new LinkedList<ZaiYuanBingRenFenBuDto>();
		zaiYuanBingRenFenBuList = reportService.queryZaiYuanBingRenFenBu();

		String data = "";
		for (int i = 0; i < zaiYuanBingRenFenBuList.size(); i++) {
			data += "['" + zaiYuanBingRenFenBuList.get(i).getName() + "'," + zaiYuanBingRenFenBuList.get(i).getCount() + "],";
		}

		model.addAttribute("zaiYuanBingRenFenBuList", zaiYuanBingRenFenBuList);
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("data", data);
		return View.IpSpreadView;
	}

	/**
	 * 平均病床工作日 按月
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_AVG_WORKING_BEDS)
	public String averageWorkingDaysOfHospitalBeds(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();

		String data = "";
		List<DataDto> dataDtoList = new LinkedList<DataDto>();
		// 病床工作日：实际占用总床日数÷平均开放病床数(1061)
		for (int i = 1; i <= 12; i++) {
			DataDto dataDto = new DataDto();
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01 00:00:00";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i) + " 23:59:59";
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			double avg = reportService.queryBingChuangGongZuoRiByMonth(dateMap) / 1061.00;
			dataDto.setName(i + "月");
			dataDto.setData(avg);
			dataDtoList.add(dataDto);
			data += "['" + i + "月'," + avg + "],";
			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("dataDtoList", dataDtoList);
		model.addAttribute("data", data);
		return View.AvgWorkingBedsView;
	}

	/**
	 * 平均病床工作日 按科室
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPORT_AVG_WORKING_BEDS_BY_DEPT)
	public String bingChuangGongZuoRiByDept(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		
		List<BingChuangGongZuoRiDto> bcgzrDtoList = new LinkedList<BingChuangGongZuoRiDto>();
		bcgzrDtoList = reportService.queryBingChuangGongZuoRiByDept(dateMap);
		String data = "";
		for (int i = 0; i < bcgzrDtoList.size(); i++) {
			if (bcgzrDtoList.get(i).getPingJuKaiFangChuangRiShu() != 0) {
				data += "['" + bcgzrDtoList.get(i).getDept() + "'," + bcgzrDtoList.get(i).getShiJiZhanYongZongChuangRiShu()
						/ bcgzrDtoList.get(i).getPingJuKaiFangChuangRiShu() + "],";
			} else {
				bcgzrDtoList.remove(i);
				i = i - 1;
			}
		}
		
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("bcgzrDtoList", bcgzrDtoList);
		model.addAttribute("data", data);
		return View.AvgWorkingBedsByDeptView;
	}

	/**
	 * 获得一个月的天数
	 * 
	 * @param month
	 * @return
	 */
	private static int getDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();  
        //下面可以设置月份，注：月份设置要减1，所以设置1月就是1-1，设置2月就是2-1，如此类推  
		cal.set(Calendar.MONTH, month - 1);
		int MaxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return MaxDay;
	}

	/**
	 * 病床周转次数 按月
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.BED_TURNOVER_TIMES)
	public String bedTurnoverTimes(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();

		String data = "";
		List<DataDto> dataDtoList = new LinkedList<DataDto>();
		for (int i = 1; i <= 12; i++) {
			DataDto dataDto = new DataDto();
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i);
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			double bedTurnoverTimes = reportService.queryBedTurnoverTimes(dateMap);
			dataDto.setName(i + "月");
			dataDto.setData(bedTurnoverTimes);
			dataDtoList.add(dataDto);
			data += "['" + i + "月'," + bedTurnoverTimes + "],";
			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("dataDtoList", dataDtoList);
		model.addAttribute("data", data);
		return View.BedTurnoverTimesView;
	}

	/**
	 * 病床周转次数 按科室
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.BED_TURNOVER_TIMES_BY_DEPT)
	public String bedTurnoverTimesByDept(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);

		List<DataDto> dataDtoList = new LinkedList<DataDto>();
		dataDtoList = reportService.queryBedTurnoverTimesByDept(dateMap);

		String data = "";
		for (int i = 0; i < dataDtoList.size(); i++) {
			data += "['" + dataDtoList.get(i).getName() + "'," + dataDtoList.get(i).getData() + "],";
		}

		model.addAttribute("dataDtoList", dataDtoList);
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("data", data);
		return View.BedTurnoverTimesView;
	}

	/**
	 * 门诊诊断符合率
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OP_DIAGNOSTIC_RATE)
	public String opDiagnosticRate(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();

		String data = "";
		List<OpDiagnosticDto> dataDtoList = new LinkedList<OpDiagnosticDto>();
		for (int i = 1; i <= 12; i++) {
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i);
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			OpDiagnosticDto opDiagnosticDto = reportService.queryOpDiagnosticRate(dateMap);
			opDiagnosticDto.setMonth(i + "月");
			dataDtoList.add(opDiagnosticDto);
			if (opDiagnosticDto.getZongShu() == 0) {
				data += "['" + i + "月'," + 0 + "],";
			} else {
				data += "['" + i + "月'," + ((double) opDiagnosticDto.getFuHe() / (double) opDiagnosticDto.getZongShu()) * 100 + "],";
			}
			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("dataDtoList", dataDtoList);
		model.addAttribute("data", data);
		return View.OpDiagnosticRateView;
	}

	/**
	 * 全院临床病理符合率 按月
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.PATHOLOGICA_RATE)
	public String pathologicalRate(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();

		String data = "";
		List<OpDiagnosticDto> dataDtoList = new LinkedList<OpDiagnosticDto>();
		for (int i = 1; i <= 12; i++) {
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i);
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			OpDiagnosticDto opDiagnosticDto = reportService.queryPathologicalRate(dateMap);
			opDiagnosticDto.setMonth(i + "月");
			dataDtoList.add(opDiagnosticDto);
			if (opDiagnosticDto.getZongShu() == 0) {
				data += "['" + i + "月'," + 0 + "],";
			} else {
				data += "['" + i + "月'," + ((double) opDiagnosticDto.getFuHe() / (double) opDiagnosticDto.getZongShu()) * 100 + "],";
			}
			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("dataDtoList", dataDtoList);
		model.addAttribute("data", data);
		return View.PathologicalRateView;
	}

	/**
	 * 全院临床病理符合率 按科室
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(Url.PATHOLOGICA_RATE_BY_DEPY)
	public String pathologicalRateByDept(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);

		List<PathologicalRateByDeptDto> pathologicalList = new LinkedList<PathologicalRateByDeptDto>();
		pathologicalList = reportService.queryPathologicalRateByDept(dateMap);
		String data = "";
		for (int i = 0; i < pathologicalList.size(); i++) {
			if ((pathologicalList.get(i).getBufu() + pathologicalList.get(i).getFuhe()) != 0) {
				data += "['" + pathologicalList.get(i).getName() + "',"
						+ (pathologicalList.get(i).getFuhe() / (pathologicalList.get(i).getBufu() + pathologicalList.get(i).getFuhe())) * 100 + "],";
			} else {
				pathologicalList.remove(i);
				i = i - 1;
			}
		}

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("pathologicalList", pathologicalList);
		model.addAttribute("data", data);
		return View.PathologicalRateByDeptView;
	}

	/**
	 * 大型设备阳性率
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.EQUIPMENT_POSITIVE_RATE)
	public String equipmentPositiveRate(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		EquipmentPositiveRate equipmentPositiveRate = new EquipmentPositiveRate();
		List<EquipmentPositiveRate> equipmentPositiveRateList = new LinkedList<EquipmentPositiveRate>();
		String data = "";
		String data1 = ""; // 彩超
		String data2 = ""; // ct
		String data3 = ""; // mri
		String data4 = ""; // dr

		for (int i = 1; i <= 12; i++) {
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01 00:00:00";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i) + " 23:59:59";
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			equipmentPositiveRate = reportService.queryEquipmentPositiveRate(dateMap);
			equipmentPositiveRate.setMonth(i + "月");
			equipmentPositiveRateList.add(equipmentPositiveRate);
			if (i == 12) {
				data1 += equipmentPositiveRate.getCaiChao();
				data2 += equipmentPositiveRate.getCt();
				data3 += equipmentPositiveRate.getMri();
				data4 += equipmentPositiveRate.getDr();
			} else {
				data1 += equipmentPositiveRate.getCaiChao() + ",";
				data2 += equipmentPositiveRate.getCt() + ",";
				data3 += equipmentPositiveRate.getMri() + ",";
				data4 += equipmentPositiveRate.getDr() + ",";
			}

			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		data = "{name:'彩超',data:[" + data1 + "]},{name:'ct',data:[" + data2 + "]},{name:'mri',data:[" + data3 + "]},{name:'dr',data:[" + data4 + "]}";

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("equipmentPositiveRateList", equipmentPositiveRateList);
		model.addAttribute("data", data);
		return View.EquipmentPositiveRateView;
	}

	/**
	 * 好转率 按月
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.IMPROVEMENT_RATE_BY_MONTH)
	public String improvementRateByMonth(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();

		String data = "";
		List<ComputeRateModel> computeRateModelList = new LinkedList<ComputeRateModel>();
		ComputeRateModel computeRateModel = new ComputeRateModel();
		for (int i = 1; i <= 12; i++) {
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i);
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			computeRateModel = reportService.queryImprovementRateByMonth(dateMap);
			computeRateModel.setName(i + "月");
			computeRateModelList.add(computeRateModel);
			data += "['" + i + "月'," + (computeRateModel.getData() / computeRateModel.getTotal()) * 100 + "],";
			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("computeRateModelList", computeRateModelList);
		model.addAttribute("data", data);
		return View.ImprovementRateByMonthView;
	}

	/**
	 * 好转率 按科室
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.IMPROVEMENT_RATE_BY_DEPT)
	public String improvementRateByDept(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);

		String data = "";
		List<ComputeRateModel> computeRateModelList = new LinkedList<ComputeRateModel>();
		computeRateModelList = reportService.queryImprovementRateByDept(dateMap);

		for (int i = 0; i < computeRateModelList.size(); i++) {
			data += "['" + computeRateModelList.get(i).getName() + "'," + (computeRateModelList.get(i).getData() / computeRateModelList.get(i).getTotal()) * 100 + "],";
		}

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("computeRateModelList", computeRateModelList);
		model.addAttribute("data", data);
		return View.ImprovementRateByDeptView;
	}

	/**
	 * 治愈率 按月
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.CURE_RATE_BY_MONTH)
	public String cureRateByMonth(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();

		String data = "";
		List<ComputeRateModel> computeRateModelList = new LinkedList<ComputeRateModel>();
		ComputeRateModel computeRateModel = new ComputeRateModel();
		for (int i = 1; i <= 12; i++) {
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i);
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			computeRateModel = reportService.queryCureRateByMonth(dateMap);
			computeRateModel.setName(i + "月");
			computeRateModelList.add(computeRateModel);
			data += "['" + i + "月'," + (computeRateModel.getData() / computeRateModel.getTotal()) * 100 + "],";
			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("computeRateModelList", computeRateModelList);
		model.addAttribute("data", data);
		return View.CureRateByMonthView;
	}

	/**
	 * 治愈率 按科室
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.CURE_RATE_BY_DEPT)
	public String cureRateByDept(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model){
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);

		String data = "";
		List<ComputeRateModel> computeRateModelList = reportService.queryCureRateByDept(dateMap);

		for (int i = 0; i < computeRateModelList.size(); i++) {
			data += "['" + computeRateModelList.get(i).getName() + "'," + (computeRateModelList.get(i).getData() / computeRateModelList.get(i).getTotal())
					* 100 + "],";
		}

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("computeRateModelList", computeRateModelList);
		model.addAttribute("data", data);
		return View.CureRateByDeptView;
	}

	/**
	 * 死亡率 按月
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.DEATH_RATE_BY_MONTH)
	public String deathRateByMonth(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();

		String data = "";
		List<ComputeRateModel> computeRateModelList = new LinkedList<ComputeRateModel>();
		ComputeRateModel computeRateModel = new ComputeRateModel();
		for (int i = 1; i <= 12; i++) {
			String strStartTime = dateStart.split("-")[0] + "-" + i + "-01";
			String strEndTime = dateStart.split("-")[0] + "-" + i + "-" + getDayOfMonth(i);
			dateMap.put("StartTime", strStartTime);
			dateMap.put("EndTime", strEndTime);
			computeRateModel = reportService.queryDeathRateByMonth(dateMap);
			computeRateModel.setName(i + "月");
			computeRateModelList.add(computeRateModel);
			data += "['" + i + "月'," + (computeRateModel.getData() / computeRateModel.getTotal()) * 100 + "],";
			dateMap.remove("StartTime");
			dateMap.remove("EndTime");
		}

		model.addAttribute("dateStart", dateStart.split("-")[0]);
		model.addAttribute("dateEnd", dateStart.split("-")[0]);
		model.addAttribute("computeRateModelList", computeRateModelList);
		model.addAttribute("data", data);
		return View.DeathRateByMonthView;
	}

	/**
	 * 死亡率 按科室
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.DEATH_RATE_BY_DEPT)
	public String deathRateByDept(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);

		String data = "";
		List<ComputeRateModel> computeRateModelList = reportService.queryDeathRateByDept(dateMap);

		for (int i = 0; i < computeRateModelList.size(); i++) {
			data += "['" + computeRateModelList.get(i).getName() + "'," + (computeRateModelList.get(i).getData() / computeRateModelList.get(i).getTotal())
					* 100 + "],";
		}

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("computeRateModelList", computeRateModelList);
		model.addAttribute("data", data);
		return View.DeathRateByDeptView;
	}

	/**
	 * 手术明细表 愈合 甲
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_DETAIL_FIRST)
	public String operationDetailFirst(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationDetail> operationDetailList = new LinkedList<OperationDetail>();
		operationDetailList = reportService.queryOperationDetailFirst(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("operationDetailList", operationDetailList);
		return View.OperationDetailFirstView;
	}

	/**
	 * 手术明细表 愈合 乙
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_DETAIL_SECOND)
	public String operationDetailSecond(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationDetail> operationDetailList = new LinkedList<OperationDetail>();
		operationDetailList = reportService.queryOperationDetailSecond(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("operationDetailList", operationDetailList);
		return View.OperationDetailSecondView;
	}

	/**
	 * 手术明细表 愈合 丙
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_DETAIL_THIRD)
	public String operationDetailThird(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationDetail> operationDetailList = new LinkedList<OperationDetail>();
		operationDetailList = reportService.queryOperationDetailThird(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("operationDetailList", operationDetailList);
		return View.OperationDetailThirdView;
	}

	/**
	 * 手术明细表 愈合 丁
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_DETAIL_FORTH)
	public String operationDetailForth(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationDetail> operationDetailList = new LinkedList<OperationDetail>();
		operationDetailList = reportService.queryOperationDetailForth(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("operationDetailList", operationDetailList);
		return View.OperationDetailForthView;
	}

	/**
	 * 分科病人手术操作质量 全院
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_QUALITH_BY_DEPT)
	public String operationQualityByDept(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationQuality> operationQualityList = new LinkedList<OperationQuality>();
		operationQualityList = reportService.queryOperationQualityByDept(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("operationQualityList", operationQualityList);
		return View.OperationQualityByDeptView;
	}

	/**
	 * 分科病人手术操作质量 外科系统
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_QUALITH_BY_DEPT_WAIKE)
	public String operationQualityByDeptWaiKe(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationQuality> operationQualityList = new LinkedList<OperationQuality>();
		operationQualityList = reportService.queryOperationQualityByDeptWaiKe(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("operationQualityList", operationQualityList);
		return View.OperationQualityByDeptWaiKeView;
	}

	/**
	 * 分科病人手术操作质量 内科系统
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_QUALITH_BY_DEPT_NEIKE)
	public String operationQualityByDeptNeiKe(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationQuality> operationQualityList = new LinkedList<OperationQuality>();
		operationQualityList = reportService.queryOperationQualityByDeptNeiKe(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("operationQualityList", operationQualityList);
		return View.OperationQualityByDeptNeiKeView;
	}

	/**
	 * 入出院诊断符合率
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.DIAGNOSTIC_RATE)
	public String diagnosticRate(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<DiagnosticDto> diagnosticList = new LinkedList<DiagnosticDto>();
		diagnosticList = reportService.queryDiagnosticRate(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("diagnosticList", diagnosticList);
		return View.DiagnosticRateView;
	}

	/**
	 * 手术前后诊断符合率
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.OPERATION_DIAGNOSTIC_RATE)
	public String operationDiagnosticRate(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<OperationDiagnostic> diagnosticList = new LinkedList<OperationDiagnostic>();
		diagnosticList = reportService.queryOperationDiagnosticRate(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("diagnosticList", diagnosticList);
		return View.OperationDiagnosticRateView;
	}
	
	/**
	 * 临床主要诊断与病理诊断符合率
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.BING_LI_ZHEN_DUAN_RATE)
	public String queryBingLiZhenDuanFuHeLv(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<BingLiZhenDuanFuHeLvDto> diagnosticList = new LinkedList<BingLiZhenDuanFuHeLvDto>();
		diagnosticList = reportService.queryBingLiZhenDuanFuHeLv(dateMap);
		
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("diagnosticList", diagnosticList);
		return View.BingLiZhenDuanRateView;
	}

	/**
	 * 重点手术疗效及费用(ICD)18以上
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.ZHONG_DIAN_SHOU_SHU_LIAO_XIAO)
	public String queryZhongDianShouShuLiaoXiao18(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<ZhongDianShouShuLiaoXiao18Dto> zhongDianShouShuLiaoXiaoList = new LinkedList<ZhongDianShouShuLiaoXiao18Dto>();
		zhongDianShouShuLiaoXiaoList = reportService.queryZhongDianShouShuLiaoXiao18(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("zhongDianShouShuLiaoXiaoList", zhongDianShouShuLiaoXiaoList);
		return View.ZhongDianShouShuLiaoXiaoView;
	}

	/**
	 * 重点疾病疗效及费用(ICD)18以上
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.ZHONG_DIAN_JI_BING_LIAO_XIAO)
	public String queryZhongDianJiBingLiaoXiao18(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<ZhongDianJiBingLiaoXiao18Dto> zhongDianJiBingLiaoXiaoList = new LinkedList<ZhongDianJiBingLiaoXiao18Dto>();
		zhongDianJiBingLiaoXiaoList = reportService.queryZhongDianJiBingLiaoXiao(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("zhongDianJiBingLiaoXiaoList", zhongDianJiBingLiaoXiaoList);
		return View.ZhongDianJiBingLiaoXiaoView;
	}

	/**
	 * 重点疾病疗效及费用(ICD)18以上 卫生部
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.ZHONG_DIAN_JI_BING_LIAO_XIAO_WEI_SHENG_BU)
	public String queryZhongDianJiBingLiaoXiaoWeiShengBu18(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("StartTime", dateStart);
		dateMap.put("EndTime", dateEnd);
		List<ZhongDianJiBingLiaoXiao18Dto> zhongDianJiBingLiaoXiaoWeiShengBuList = new LinkedList<ZhongDianJiBingLiaoXiao18Dto>();
		zhongDianJiBingLiaoXiaoWeiShengBuList = reportService.queryZhongDianJiBingLiaoXiaoWeiShengBu(dateMap);

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("zhongDianJiBingLiaoXiaoWeiShengBuList", zhongDianJiBingLiaoXiaoWeiShengBuList);
		return View.ZhongDianJiBingLiaoXiaoWeiShengBuView;
	}

}

