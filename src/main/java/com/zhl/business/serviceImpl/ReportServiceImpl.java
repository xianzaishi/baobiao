package com.zhl.business.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.business.dao.ReportDao;
import com.zhl.business.dto.MenZhenShouRuDto;
import com.zhl.business.dto.RuChuYuanShuDto;
import com.zhl.business.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao reportDao;

	public String query() {
		return reportDao.query();
	}

	/**
	 * 住院收入
	 * 
	 * @param date
	 * @return
	 */
	public double queryIpTotal(Map<String, String> dateMap) {
		return reportDao.queryIpTotal(dateMap);
	}

	/**
	 * 入院药品收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpDrugsTotal(Map<String, String> dateMap) {
		return reportDao.queryIpDrugsTotal(dateMap);
	}

	/**
	 * 门诊保险收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryOpBaoXianTotal(Map<String, String> dateMap) {
		return reportDao.queryOpBaoXianTotal(dateMap);
	}

	/**
	 * 入院保险收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpBaoXianTotal(Map<String, String> dateMap) {
		return reportDao.queryIpBaoXianTotal(dateMap);
	}

	/**
	 * 门诊医保 统筹收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryOpTongChouTotal(Map<String, String> dateMap) {
		return reportDao.queryOpTongChouTotal(dateMap);
	}

	/**
	 * 入院医保 统筹收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpTongChouTotal(Map<String, String> dateMap) {
		return reportDao.queryIpTongChouTotal(dateMap);
	}

	/**
	 * 门急诊人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenJiZhenRenCiTotal(Map<String, String> dateMap) {
		return reportDao.queryMenJiZhenRenCiTotal(dateMap);
	}

	/**
	 * 急诊人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryJiZhenRenCiTotal(Map<String, String> dateMap) {
		return reportDao.queryJiZhenRenCiTotal(dateMap);
	}

	/**
	 * 门诊医保人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenYiBaoTotal(Map<String, String> dateMap) {
		return reportDao.queryMenZhenYiBaoTotal(dateMap);
	}

	/**
	 * 门诊出诊医生
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuZhenYiShengTotal(Map<String, String> dateMap) {
		return reportDao.queryChuZhenYiShengTotal(dateMap);
	}

	/**
	 * 门诊处方数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuFangTotal(Map<String, String> dateMap) {
		return reportDao.queryChuFangTotal(dateMap);
	}

	/**
	 * 门诊退费金额
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenTuiFeiTotal(Map<String, String> dateMap) {
		return reportDao.queryMenZhenTuiFeiTotal(dateMap);
	}

	/**
	 * 门诊使用抗生素数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenKangShengSuTotal(Map<String, String> dateMap) {
		return reportDao.queryMenZhenKangShengSuTotal(dateMap);
	}

	/**
	 * 入院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryRuYuanAndYiBaoTotal(Map<String, String> dateMap) {
		return reportDao.queryRuYuanAndYiBaoTotal(dateMap);
	}

	/**
	 * 在院人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanTotal(Map<String, String> dateMap) {
		return reportDao.queryZaiYuanTotal(dateMap);
	}

	/**
	 * 在院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanAndYiBaoTotal(Map<String, String> dateMap) {
		return reportDao.queryZaiYuanAndYiBaoTotal(dateMap);
	}

	/**
	 * 在院人数 血透人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanAndXueTouTotal(Map<String, String> dateMap) {
		return reportDao.queryZaiYuanAndXueTouTotal(dateMap);
	}

	/**
	 * 出院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuYuanAndYiBaoTotal(Map<String, String> dateMap) {
		return reportDao.queryChuYuanAndYiBaoTotal(dateMap);
	}

	/**
	 * 血透收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryXueTouShouRu(Map<String, String> dateMap) {
		return reportDao.queryXueTouShouRu(dateMap);
	}

	/**
	 * 入出院数
	 * 
	 * @param dateMap
	 * @return
	 */
	public RuChuYuanShuDto queryRuChuYuanShu(Map<String, String> dateMap) {
		return reportDao.queryRuChuYuanShu(dateMap);
	}

	/**
	 * 门诊收入 （包含：药品收入、诊疗收入）
	 * 
	 * @param dateMap
	 * @return
	 */
	public MenZhenShouRuDto queryMenZhenShouRu(Map<String, String> dateMap) {
		return reportDao.queryMenZhenShouRu(dateMap);
	}

}
