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
import com.zhl.business.dto.DataDto;
import com.zhl.business.dto.DeptDateDto;
import com.zhl.business.dto.RuChuYuanShuDto;
import com.zhl.business.dto.ZaiYuanBingRenFenBuDto;
import com.zhl.business.dto.ZhuYuanShouRuDto;
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
		double chuZhenYiShengTotal = reportService.queryChuZhenYiShengTotal(dateMap);	// 门诊出诊医生
		double chuFangTotal = reportService.queryChuFangTotal(dateMap);	//门诊处方数
		double menZhenTuiFeiTotal = reportService.queryMenZhenTuiFeiTotal(dateMap);	//门诊退费金额
		double menZhenKangShengSuTotal = reportService.queryMenZhenKangShengSuTotal(dateMap);	//门诊使用抗生素数
		double ruYuanAndYiBaoTotal = reportService.queryRuYuanAndYiBaoTotal(dateMap);	//入院人数 医保人数
		double zaiYuanTotal = reportService.queryZaiYuanTotal(dateMap);	//在院人数
		double zaiYuanAndYiBaoTotal = reportService.queryZaiYuanAndYiBaoTotal(dateMap);	//在院人数 医保人数
		double zaiYuanAndXueTouTotal = reportService.queryZaiYuanAndXueTouTotal(dateMap);	//在院人数 血透人数
		double chuYuanAndYiBaoTotal = reportService.queryChuYuanAndYiBaoTotal(dateMap);	//出院人数 医保人数
		double queryXueTouShouRu = reportService.queryXueTouShouRu(dateMap);	// 血透收入
		
		RuChuYuanShuDto ruChuYuanShu = reportService.queryRuChuYuanShu(dateMap); // 入出院人数
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
		case 12: // 病床周转次数分析
			url = "/report/bedTurnoverTimes/dateStart/" + dateStart + "/dateEnd/" + dateEnd;
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
		RuChuYuanShuDto ruChuYuanShu = reportService.queryRuChuYuanShu(dateMap); // 入出院人数
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
		RuChuYuanShuDto ruChuYuanShu = reportService.queryRuChuYuanShu(dateMap); // 入出院人数
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
		double ipTotal = reportService.queryIpTotal(dateMap); // 在院收入
		double zaiYuanTotal = reportService.queryZaiYuanTotal(dateMap); // 在院人数
		ZhuYuanShouRuDto zhuYuanShouRuDto = reportService.queryZhuYuanShouRu(dateMap); // 在院收入

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("opTotal", menZhenShouRu); // 门诊收入
		model.addAttribute("menJiZhenRenCiTotal", menJiZhenRenCiTotal); // 门急诊人次
		model.addAttribute("opDrugsTotal", menZhenYaoPinShouRu); // 门诊药品收入
		model.addAttribute("ipTotal", ipTotal); // 在院收入
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

		double ipTotal = reportService.queryIpTotal(dateMap); // 在院收入
		ZhuYuanShouRuDto zhuYuanShouRuDto = reportService.queryZhuYuanShouRu(dateMap); // 在院收入
		double yiLiaoCaiLiaoShouRu = reportService.queryYiliaoCaiLiaoShouRu(dateMap); // 医疗材料收入

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("ipDrugsTotal", zhuYuanShouRuDto.getYaoPinShouRu()); // 在院药品收入
		model.addAttribute("opDrugsTotal", menZhenYaoPinShouRu); // 门诊药品收入
		model.addAttribute("yiLiaoCaiLiaoShouRu", yiLiaoCaiLiaoShouRu); // 医疗材料收入
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
			deptDateDtoResultList.add(deptDateDto);
		}
		
		String data = "";
		for (int i = 0; i < deptDateDtoList.size(); i++) {
			if ((deptDateDtoResultList.get(i).getDateList().get(1) == 0 ? 0 : (deptDateDtoResultList.get(i).getDateList().get(0) / deptDateDtoResultList.get(i)
					.getDateList().get(1)) * 100) > 0) {
				data += "['"
						+ deptDateDtoResultList.get(i).getName()
						+ "',"
						+ (deptDateDtoResultList.get(i).getDateList().get(1) == 0 ? 0
								: (deptDateDtoResultList.get(i).getDateList().get(0) / deptDateDtoResultList.get(i).getDateList().get(1)) * 100) + "],";
			}
		}

		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("deptDateDtoResultList", deptDateDtoResultList);
		model.addAttribute("data", data);
		return View.RescueSuccessRateView;
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
		List<DeptDateDto> deptDateDtoList = new LinkedList<DeptDateDto>();
		deptDateDtoList = reportService.queryYiLiaoDept();

		List<DeptDateDto> deptDateDtoResultList = new LinkedList<DeptDateDto>();

		String data = "";
		for (int i = 0; i < deptDateDtoList.size(); i++) {
			DeptDateDto deptDateDto = new DeptDateDto();
			int id = deptDateDtoList.get(i).getId();
			deptDateDto.setId(id);
			deptDateDto.setName(deptDateDtoList.get(i).getName());
			dateMap.put("id", Integer.toString(deptDateDtoList.get(i).getId()));
			List<Double> dateList = new LinkedList<Double>();

			int chuYuanZongChuangRi = reportService.queryChuYuanZongChuangRiByDeptId(dateMap); // 出院患者实际占用总床日
			int chuYuanShu = reportService.queryChuYuanShuByDeptId(dateMap); // 出院人数
			double chuYuanPingJunZhuYuanRi = (chuYuanShu == 0 ? 0 : chuYuanZongChuangRi / chuYuanShu); // 出院患者平均住院日
			dateList.add(chuYuanPingJunZhuYuanRi);

			dateMap.remove("id");

			if (chuYuanPingJunZhuYuanRi != 0) {
				data += "['" + deptDateDtoList.get(i).getName() + "'," + chuYuanPingJunZhuYuanRi + "],";
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
	 * 平均病床工作日
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
	 * 病床周转次数分析
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.BED_TURNOVER_TIMES)
	public String bedTurnoverTimes(@PathVariable String dateStart, @PathVariable String dateEnd, ModelMap model) {
		return View.BedTurnoverTimesView;
	}

}

