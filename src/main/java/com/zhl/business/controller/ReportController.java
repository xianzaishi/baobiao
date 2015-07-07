package com.zhl.business.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhl.business.constant.Url;
import com.zhl.business.constant.View;
import com.zhl.business.dto.MenZhenShouRuDto;
import com.zhl.business.dto.RuChuYuanShuDto;
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

		double ipTotal = reportService.queryIpTotal(dateMap);
		double ipDrugsTotal = reportService.queryIpDrugsTotal(dateMap);
		double opBaoXianTotal = reportService.queryOpBaoXianTotal(dateMap);
		double ipBaoXianTotal = reportService.queryIpBaoXianTotal(dateMap);
		double opTongChouTotal = reportService.queryOpTongChouTotal(dateMap);
		double ipTongChouTotal = reportService.queryIpTongChouTotal(dateMap);

		double menJiZhenRenCiTotal = reportService.queryMenJiZhenRenCiTotal(dateMap);
		double jiZhenRenCiTotal = reportService.queryJiZhenRenCiTotal(dateMap);
		double menZhenYiBaoTotal = reportService.queryMenZhenYiBaoTotal(dateMap);
		double chuZhenYiShengTotal = reportService.queryChuZhenYiShengTotal(dateMap);
		double chuFangTotal = reportService.queryChuFangTotal(dateMap);
		double menZhenTuiFeiTotal = reportService.queryMenZhenTuiFeiTotal(dateMap);
		double menZhenKangShengSuTotal = reportService.queryMenZhenKangShengSuTotal(dateMap);
		double ruYuanAndYiBaoTotal = reportService.queryRuYuanAndYiBaoTotal(dateMap);
		double zaiYuanTotal = reportService.queryZaiYuanTotal(dateMap);
		double zaiYuanAndYiBaoTotal = reportService.queryZaiYuanAndYiBaoTotal(dateMap);
		double zaiYuanAndXueTouTotal = reportService.queryZaiYuanAndXueTouTotal(dateMap);
		double chuYuanAndYiBaoTotal = reportService.queryChuYuanAndYiBaoTotal(dateMap);
		double queryXueTouShouRu = reportService.queryXueTouShouRu(dateMap);
		
		RuChuYuanShuDto ruChuYuanShu = reportService.queryRuChuYuanShu(dateMap);
		MenZhenShouRuDto menZhenShouRu = reportService.queryMenZhenShouRu(dateMap);

		double sum = ipTotal + menZhenShouRu.getYaoPinShouRu() + menZhenShouRu.getZhenLiaoShouRu();

		model.addAttribute("sum", sum); // 总收入
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("opTotal", menZhenShouRu.getYaoPinShouRu() + menZhenShouRu.getZhenLiaoShouRu()); // 门诊收入
		model.addAttribute("ipTotal", ipTotal); // 入院收入
		model.addAttribute("opDrugsTotal", menZhenShouRu.getYaoPinShouRu()); // 门诊药品收入
		model.addAttribute("opTreatmentTotal", menZhenShouRu.getZhenLiaoShouRu()); // 门诊诊疗收入
		model.addAttribute("ipDrugsTotal", ipDrugsTotal); // 入院药品收入
		model.addAttribute("ipTreatmentTotal", ipTotal - ipDrugsTotal); // 入院诊疗收入
		model.addAttribute("opBaoXianTotal", opBaoXianTotal); // 门诊保险收入
		model.addAttribute("ipBaoXianTotal", ipBaoXianTotal); // 入院保险收入
		model.addAttribute("opTongChouTotal", opTongChouTotal); // 门诊医保 统筹收入
		model.addAttribute("ipTongChouTotal", ipTongChouTotal); // 入院医保 统筹收入
		model.addAttribute("opBaoXianXianJinTotal", opBaoXianTotal - opTongChouTotal); // 门诊医保 现金收入
		model.addAttribute("ipBaoXianXianJinTotal", ipBaoXianTotal - ipTongChouTotal); // 入院医保 现金收入

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
		model.addAttribute("ruYuanAndZiFeiTotal", ruChuYuanShu.getRuYuanShu() - ruYuanAndYiBaoTotal); //入院人数 自费人数
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
}

