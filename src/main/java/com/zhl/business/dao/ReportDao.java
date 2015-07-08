package com.zhl.business.dao;

import java.util.List;
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

	/**
	 * 体检人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryTiJianRenShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryTiJianRenShu", dateMap);
	}

	/**
	 * 出院患者实际占用总床日
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryChuYuanZongChuangRi(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryChuYuanZongChuangRi", dateMap);
	}

	/**
	 * 住院手术例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanShouShuLiShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryZhuYuanShouShuLiShu", dateMap);
	}

	/**
	 * 门诊手术例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryMenZhenShouShuLiShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryMenZhenShouShuLiShu", dateMap);
	}

	/**
	 * 留观人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryLiuGuanRenCi(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryLiuGuanRenCi", dateMap);
	}

	/**
	 * 住院患者死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanSiWangShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryZhuYuanSiWangShu", dateMap);
	}

	/**
	 * 住院手术死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanShouShuSiWangShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryZhuYuanShouShuSiWangShu", dateMap);
	}

	/**
	 * 新生儿患者出院人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryXinShengErChuYuanShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryXinShengErChuYuanShu", dateMap);
	}

	/**
	 * 新生儿患者出院死亡人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryXinShengErSiWangShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryXinShengErSiWangShu", dateMap);
	}

	/**
	 * 住院危重抢救例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanWeiZhongQiangQiu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryZhuYuanWeiZhongQiangQiu", dateMap);
	}

	/**
	 * 住院危重抢救死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanWeiZhongQiangQiuSiWang(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryZhuYuanWeiZhongQiangQiuSiWang", dateMap);
	}

	/**
	 * 急诊科危重抢救例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryJiZhenWeiZhongQiangJiu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryJiZhenWeiZhongQiangJiu", dateMap);
	}

	/**
	 * 急诊科危重抢救死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryJiZhenWeiZhongQiangJiuSiWang(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryJiZhenWeiZhongQiangJiuSiWang", dateMap);
	}

	/**
	 * 住院患者自动出院例数(无费出院)
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZiDongLiYuan(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryZiDongLiYuan", dateMap);
	}

	/**
	 * 查询无费用出院患者
	 * 
	 * @param dateMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> queryJieZhangWuFei(Map<String, String> dateMap) {
		return (List<Integer>) getSqlMapClientTemplate().queryForList("report.queryJieZhangWuFei", dateMap);
	}

	/**
	 * 查询住院时间小于2天的患者
	 * 
	 * @param dateMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> queryZhuYuanDuan(Map<String, String> dateMap) {
		return (List<Integer>) getSqlMapClientTemplate().queryForList("report.queryZhuYuanDuan", dateMap);
	}

	/**
	 * 恶性肿瘤手术前诊断与术后病理诊断符合例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryShuQianZhenDuanFuHe(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryShuQianZhenDuanFuHe", dateMap);
	}

	/**
	 * 换床总次数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryHuanChuangShu(Map<String, String> dateMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("report.queryHuanChuangShu", dateMap);
	}
}