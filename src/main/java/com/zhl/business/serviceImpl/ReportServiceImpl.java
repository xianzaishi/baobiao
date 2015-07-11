package com.zhl.business.serviceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.business.dao.ReportDao;
import com.zhl.business.dto.RuChuYuanShuDto;
import com.zhl.business.dto.ZhuYuanShouRuDto;
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
	 * 门诊药品收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenYaoPinShouRu(Map<String, String> dateMap) {
		return reportDao.queryMenZhenYaoPinShouRu(dateMap);
	}

	/**
	 * 体检人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryTiJianRenShu(Map<String, String> dateMap){
		return reportDao.queryTiJianRenShu(dateMap);
	}

	/**
	 * 出院患者实际占用总床日
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryChuYuanZongChuangRi(Map<String, String> dateMap) {
		return reportDao.queryChuYuanZongChuangRi(dateMap);
	}

	/**
	 * 住院手术例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanShouShuLiShu(Map<String, String> dateMap) {
		return reportDao.queryZhuYuanShouShuLiShu(dateMap);
	}

	/**
	 * 门诊手术例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryMenZhenShouShuLiShu(Map<String, String> dateMap) {
		return reportDao.queryMenZhenShouShuLiShu(dateMap);
	}

	/**
	 * 留观人次
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryLiuGuanRenCi(Map<String, String> dateMap) {
		return reportDao.queryLiuGuanRenCi(dateMap);
	}

	/**
	 * 住院患者死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanSiWangShu(Map<String, String> dateMap) {
		return reportDao.queryZhuYuanSiWangShu(dateMap);
	}

	/**
	 * 住院手术死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanShouShuSiWangShu(Map<String, String> dateMap) {
		return reportDao.queryZhuYuanShouShuSiWangShu(dateMap);
	}

	/**
	 * 新生儿患者出院人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryXinShengErChuYuanShu(Map<String, String> dateMap) {
		return reportDao.queryXinShengErChuYuanShu(dateMap);
	}

	/**
	 * 新生儿患者出院死亡人数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryXinShengErSiWangShu(Map<String, String> dateMap) {
		return reportDao.queryXinShengErSiWangShu(dateMap);
	}

	/**
	 * 住院危重抢救例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanWeiZhongQiangQiu(Map<String, String> dateMap) {
		return reportDao.queryZhuYuanWeiZhongQiangQiu(dateMap);
	}

	/**
	 * 住院危重抢救死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZhuYuanWeiZhongQiangQiuSiWang(Map<String, String> dateMap) {
		return reportDao.queryZhuYuanWeiZhongQiangQiuSiWang(dateMap);
	}

	/**
	 * 急诊科危重抢救例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryJiZhenWeiZhongQiangJiu(Map<String, String> dateMap) {
		return reportDao.queryJiZhenWeiZhongQiangJiu(dateMap);
	}

	/**
	 * 急诊科危重抢救死亡例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryJiZhenWeiZhongQiangJiuSiWang(Map<String, String> dateMap) {
		return reportDao.queryJiZhenWeiZhongQiangJiuSiWang(dateMap);
	}

	/**
	 * 住院患者自动出院例数(无费出院)
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryZiDongLiYuan(Map<String, String> dateMap) {
		List<Integer> wuFeiList = new LinkedList<Integer>();
		List<Integer> duanList = new LinkedList<Integer>();
		wuFeiList = reportDao.queryJieZhangWuFei(dateMap);
		duanList = reportDao.queryZhuYuanDuan(dateMap);
		int wuFeiLength = wuFeiList.size();
		int duanLength = duanList.size();
		int count = 0;

		for (int i = 0; i < duanLength; i++) {
			if (wuFeiList.indexOf(duanList.get(i)) > 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 恶性肿瘤手术前诊断与术后病理诊断符合例数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryShuQianZhenDuanFuHe(Map<String, String> dateMap) {
		return reportDao.queryShuQianZhenDuanFuHe(dateMap);
	}

	/**
	 * 换床总次数
	 * 
	 * @param dateMap
	 * @return
	 */
	public int queryHuanChuangShu(Map<String, String> dateMap) {
		return reportDao.queryHuanChuangShu(dateMap);
	}

	/**
	 * 医疗材料收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryYiliaoCaiLiaoShouRu(Map<String, String> dateMap) {
		return reportDao.queryYiliaoCaiLiaoShouRu(dateMap);
	}

	/**
	 * 住院收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public ZhuYuanShouRuDto queryZhuYuanShouRu(Map<String, String> dateMap) {
		return reportDao.queryZhuYuanShouRu(dateMap);
	}

	/**
	 * 门诊挂号收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryGuaHaoShouRu(Map<String, String> dateMap) {
		return reportDao.queryGuaHaoShouRu(dateMap);
	}

	/**
	 * 门诊收费收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryMenZhenShouFeiShouRu(Map<String, String> dateMap) {
		return reportDao.queryMenZhenShouFeiShouRu(dateMap);
	}

	/**
	 * 体检收入
	 * 
	 * @param dateMap
	 * @return
	 */
	public double queryTiJianShouRu(Map<String, String> dateMap) {
		return reportDao.queryTiJianShouRu(dateMap);
	}
}
