package com.zhl.business.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zhl.business.dto.MenZhenShouRuDto;
import com.zhl.business.dto.RuChuYuanShuDto;

@Repository
public class ReportDao extends BaseDao {
	/**
	 * 查询
	 * 
	 * @return
	 */
	public String query() {
		return (String) getSqlMapClientTemplate().queryForObject("report.query");
	}

	/**
	 * 住院收入
	 * 
	 * @param date
	 * @return
	 */
	public double queryIpTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryIpTotal", dateMap);
	}

	/**
	 * 入院药品收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpDrugsTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryIpDrugsTotal", dateMap);
	}

	/**
	 * 门诊保险收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryOpBaoXianTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryOpBaoXianTotal", dateMap);
	}

	/**
	 * 门诊医保 统筹收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryOpTongChouTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryOpTongChouTotal", dateMap);
	}

	/**
	 * 入院保险收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpBaoXianTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryIpBaoXianTotal", dateMap);
	}

	/**
	 * 入院医保 统筹收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpTongChouTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryIpTongChouTotal", dateMap);
	}

	/**
	 * 门急诊人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenJiZhenRenCiTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryMenJiZhenRenCiTotal", dateMap);
	}

	/**
	 * 急诊人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryJiZhenRenCiTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryJiZhenRenCiTotal", dateMap);
	}

	/**
	 * 门诊医保人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenYiBaoTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryMenZhenYiBaoTotal", dateMap);
	}

	/**
	 * 门诊出诊医生
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuZhenYiShengTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryChuZhenYiShengTotal", dateMap);
	}

	/**
	 * 门诊处方数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuFangTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryChuFangTotal", dateMap);
	}

	/**
	 * 门诊退费金额
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenTuiFeiTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryMenZhenTuiFeiTotal", dateMap);
	}

	/**
	 * 门诊使用抗生素数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenKangShengSuTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryMenZhenKangShengSuTotal", dateMap);
	}

	/**
	 * 入院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryRuYuanAndYiBaoTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryRuYuanAndYiBaoTotal", dateMap);
	}

	/**
	 * 在院人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryZaiYuanTotal", dateMap);
	}

	/**
	 * 在院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanAndYiBaoTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryZaiYuanAndYiBaoTotal", dateMap);
	}

	/**
	 * 在院人数 血透人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanAndXueTouTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryZaiYuanAndXueTouTotal", dateMap);
	}

	/**
	 * 出院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuYuanAndYiBaoTotal(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryChuYuanAndYiBaoTotal", dateMap);
	}

	/**
	 * 血透收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryXueTouShouRu(Map<String, String> dateMap) {
		return (Double) getSqlMapClientTemplate().queryForObject("report.queryXueTouShouRu", dateMap);
	}

	/**
	 * 入出院数
	 * 
	 * @param dateMap
	 * @return
	 */
	public RuChuYuanShuDto queryRuChuYuanShu(Map<String, String> dateMap) {
		return (RuChuYuanShuDto) getSqlMapClientTemplate().queryForObject("report.queryRuChuYuanShu", dateMap);
	}

	/**
	 * 门诊收入 （包含：药品收入、诊疗收入）
	 * 
	 * @param dateMap
	 * @return
	 */
	public MenZhenShouRuDto queryMenZhenShouRu(Map<String, String> dateMap) {
		return (MenZhenShouRuDto) getSqlMapClientTemplate().queryForObject("report.queryMenZhenShouRu", dateMap);
	}
}