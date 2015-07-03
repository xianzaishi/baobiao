package com.zhl.business.service;

import java.util.Map;

import com.zhl.business.dto.MenZhenShouRuDto;
import com.zhl.business.dto.RuChuYuanShuDto;



/**
 * 频道服务层接口
 * 
 * @author 张宏亮
 * 
 */
public interface ReportService {
	/**
	 * 查询
	 * 
	 * @return
	 */
	public String query();

	/**
	 * 住院收入
	 * 
	 * @param date
	 * @return
	 */
	public double queryIpTotal(Map<String, String> dateMap);

	/**
	 * 入院药品收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpDrugsTotal(Map<String, String> dateMap);
	
	/**
	 * 门诊保险收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryOpBaoXianTotal(Map<String, String> dateMap);

	/**
	 * 入院保险收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpBaoXianTotal(Map<String, String> dateMap);

	/**
	 * 门诊医保 统筹收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryOpTongChouTotal(Map<String, String> dateMap);

	/**
	 * 入院医保 统筹收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryIpTongChouTotal(Map<String, String> dateMap);

	/**
	 * 门急诊人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenJiZhenRenCiTotal(Map<String, String> dateMap);

	/**
	 * 急诊人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryJiZhenRenCiTotal(Map<String, String> dateMap);

	/**
	 * 门诊医保人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 门诊出诊医生
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuZhenYiShengTotal(Map<String, String> dateMap);

	/**
	 * 门诊处方数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuFangTotal(Map<String, String> dateMap);

	/**
	 * 门诊退费金额
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenTuiFeiTotal(Map<String, String> dateMap);

	/**
	 * 门诊使用抗生素数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenKangShengSuTotal(Map<String, String> dateMap);

	/**
	 * 入院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryRuYuanAndYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 在院人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanTotal(Map<String, String> dateMap);

	/**
	 * 在院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanAndYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 在院人数 血透人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryZaiYuanAndXueTouTotal(Map<String, String> dateMap);

	/**
	 * 出院人数 医保人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryChuYuanAndYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 血透收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryXueTouShouRu(Map<String, String> dateMap);

	/**
	 * 入出院数
	 * 
	 * @param dateMap
	 * @return
	 */
	public RuChuYuanShuDto queryRuChuYuanShu(Map<String, String> dateMap);

	/**
	 * 门诊收入 （包含：药品收入、诊疗收入）
	 * 
	 * @param dateMap
	 * @return
	 */
	public MenZhenShouRuDto queryMenZhenShouRu(Map<String, String> dateMap);

	/**
	 * 体检人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryTiJianRenShu(Map<String, String> dateMap);

	/**
	 * 出院患者实际占用总床日
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryChuYuanZongChuangRi(Map<String, String> dateMap);

	/**
	 * 住院手术例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanShouShuLiShu(Map<String, String> dateMap);

	/**
	 * 门诊手术例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryMenZhenShouShuLiShu(Map<String, String> dateMap);
	
	/**
	 * 留观人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryLiuGuanRenCi(Map<String, String> dateMap);
}
