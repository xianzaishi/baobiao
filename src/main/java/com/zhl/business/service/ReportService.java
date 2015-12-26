package com.zhl.business.service;

import java.util.List;
import java.util.Map;

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
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryIpTotal(Map<String, String> dateMap);

	/**
	 * 门诊保险收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryOpBaoXianTotal(Map<String, String> dateMap);

	/**
	 * 入院保险收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryIpBaoXianTotal(Map<String, String> dateMap);

	/**
	 * 门诊医保 统筹收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryOpTongChouTotal(Map<String, String> dateMap);

	/**
	 * 入院医保 统筹收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryIpTongChouTotal(Map<String, String> dateMap);

	/**
	 * 门急诊人次
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryMenJiZhenRenCiTotal(Map<String, String> dateMap);

	/**
	 * 急诊人次
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryJiZhenRenCiTotal(Map<String, String> dateMap);

	/**
	 * 门诊医保人次
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryMenZhenYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 门诊出诊医生
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryChuZhenYiShengTotal(Map<String, String> dateMap);

	/**
	 * 门诊处方数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryChuFangTotal(Map<String, String> dateMap);

	/**
	 * 门诊退费金额
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryMenZhenTuiFeiTotal(Map<String, String> dateMap);

	/**
	 * 门诊使用抗生素数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryMenZhenKangShengSuTotal(Map<String, String> dateMap);

	/**
	 * 入院人数 医保人数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryRuYuanAndYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 在院人数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryZaiYuanTotal(Map<String, String> dateMap);

	/**
	 * 在院人数 医保人数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryZaiYuanAndYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 在院人数 血透人数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryZaiYuanAndXueTouTotal(Map<String, String> dateMap);

	/**
	 * 出院人数 医保人数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryChuYuanAndYiBaoTotal(Map<String, String> dateMap);

	/**
	 * 血透收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryXueTouShouRu(Map<String, String> dateMap);

	/**
	 * 入出院数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public RuChuYuanShuDto queryRuChuYuanShu(Map<String, String> dateMap);

	/**
	 * 门诊药品收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryMenZhenYaoPinShouRu(Map<String, String> dateMap);

	/**
	 * 体检人次
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryTiJianRenShu(Map<String, String> dateMap);

	/**
	 * 出院患者实际占用总床日
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryChuYuanZongChuangRi(Map<String, String> dateMap);

	/**
	 * 出院患者实际占用总床日 按科室
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryChuYuanZongChuangRiByDeptId(Map<String, String> dateMap);

	/**
	 * 住院手术例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryZhuYuanShouShuLiShu(Map<String, String> dateMap);

	/**
	 * 门诊手术例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryMenZhenShouShuLiShu(Map<String, String> dateMap);
	
	/**
	 * 留观人次
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryLiuGuanRenCi(Map<String, String> dateMap);

	/**
	 * 住院患者死亡例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryZhuYuanSiWangShu(Map<String, String> dateMap);

	/**
	 * 住院手术死亡例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryZhuYuanShouShuSiWangShu(Map<String, String> dateMap);

	/**
	 * 新生儿患者出院人数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryXinShengErChuYuanShu(Map<String, String> dateMap);

	/**
	 * 新生儿患者出院死亡人数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryXinShengErSiWangShu(Map<String, String> dateMap);

	/**
	 * 住院危重抢救例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryZhuYuanWeiZhongQiangQiu(Map<String, String> dateMap);

	/**
	 * 住院危重抢救死亡例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryZhuYuanWeiZhongQiangQiuSiWang(Map<String, String> dateMap);

	/**
	 * 急诊科危重抢救例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryJiZhenWeiZhongQiangJiu(Map<String, String> dateMap);

	/**
	 * 急诊科危重抢救死亡例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryJiZhenWeiZhongQiangJiuSiWang(Map<String, String> dateMap);
	
	/**
	 * 住院患者自动出院例数(无费出院)
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryZiDongLiYuan(Map<String, String> dateMap);

	/**
	 * 恶性肿瘤手术前诊断与术后病理诊断符合例数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryShuQianZhenDuanFuHe(Map<String, String> dateMap);

	/**
	 * 换床总次数
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryHuanChuangShu(Map<String, String> dateMap);

	/**
	 * 医疗材料收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryYiliaoCaiLiaoShouRu(Map<String, String> dateMap);

	/**
	 * 住院收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public ZhuYuanShouRuDto queryZhuYuanShouRu(Map<String, String> dateMap);

	/**
	 * 门诊挂号收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryGuaHaoShouRu(Map<String, String> dateMap);

	/**
	 * 门诊收费收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryMenZhenShouFeiShouRu(Map<String, String> dateMap);

	/**
	 * 体检收入
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public double queryTiJianShouRu(Map<String, String> dateMap);

	/**
	 * 查询医疗部门
	 * 
	 * @return
	 */
	public List<DeptDateDto> queryYiLiaoDept();
	
	/**
	 * 查询住院日报部门
	 * 
	 * @return
	 */
	public List<Department> queryZhuYuanRiBaoDept();

	/**
	 * 根据科室id查询科室抢救成功率
	 * 
	 * @param dateMap
	 *            <StartTime, EndTime, id>
	 * @return
	 */
	public List<Double> queryQiangJiuChengGongLvByDeptId(Map<String, String> dateMap);
	
	/**
	 * 出院数 按科室
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public ZhuYuanRiBao queryZhuYuanRiBaoByDeptId(Map<String, String> dateMap);

	/**
	 * 在院病人分布
	 * 
	 * @return
	 */
	public List<ZaiYuanBingRenFenBuDto> queryZaiYuanBingRenFenBu();

	/**
	 * 病床工作日 按月查询
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public int queryBingChuangGongZuoRiByMonth(Map<String, String> dateMap);
	
	/**
	 * 病床工作日 按科室
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public List<BingChuangGongZuoRiDto> queryBingChuangGongZuoRiByDept(Map<String, String> dateMap);
	
	/**
	 * 病床周转次数 按月
	 * 
	 * @param dateMap
	 *            <StartTime, EndTime>
	 * @return
	 */
	public double queryBedTurnoverTimes(Map<String, String> dateMap);

	/**
	 * 病床周转次数 按科室
	 * 
	 * @param dateMap
	 *            <StartTime, EndTime>
	 * @return
	 */
	public List<DataDto> queryBedTurnoverTimesByDept(Map<String, String> dateMap);

	/**
	 * 门诊诊断符合率
	 * 
	 * @param dateMap<StartTime, EndTime>
	 * @return
	 */
	public OpDiagnosticDto queryOpDiagnosticRate(Map<String, String> dateMap);
	
	/**
	 * 全院临床病理符合率 按月
	 * 
	 * @param dateMap
	 *            <StartTime, EndTime>
	 * @return
	 */
	public OpDiagnosticDto queryPathologicalRate(Map<String, String> dateMap);

	/**
	 * 全院临床病理符合率 按科室
	 * 
	 * @param dateMap
	 *            <StartTime, EndTime>
	 * @return
	 */
	public List<PathologicalRateByDeptDto> queryPathologicalRateByDept(Map<String, String> dateMap);

	/**
	 * 设备阳性率
	 * 
	 * @param dateMap
	 *            <StartTime, EndTime>
	 * @return EquipmentPositiveRate
	 */
	public EquipmentPositiveRate queryEquipmentPositiveRate(Map<String, String> dateMap);

	/**
	 * 好转率 按月份
	 * 
	 * @param dateMap
	 * @return
	 */
	public ComputeRateModel queryImprovementRateByMonth(Map<String, String> dateMap);

	/**
	 * 治愈率 按月份
	 * 
	 * @param dateMap
	 * @return
	 */
	public ComputeRateModel queryCureRateByMonth(Map<String, String> dateMap);

	/**
	 * 死亡率 按月份
	 * 
	 * @param dateMap
	 * @return
	 */
	public ComputeRateModel queryDeathRateByMonth(Map<String, String> dateMap);

	/**
	 * 好转率 按科室
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<ComputeRateModel> queryImprovementRateByDept(Map<String, String> dateMap);

	/**
	 * 治愈率 按科室
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<ComputeRateModel> queryCureRateByDept(Map<String, String> dateMap);

	/**
	 * 死亡率 按科室
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<ComputeRateModel> queryDeathRateByDept(Map<String, String> dateMap);

	/**
	 * 手术明细表 愈合 甲
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationDetail> queryOperationDetailFirst(Map<String, String> dateMap);

	/**
	 * 手术明细表 愈合 乙
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationDetail> queryOperationDetailSecond(Map<String, String> dateMap);

	/**
	 * 手术明细表 愈合 丙
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationDetail> queryOperationDetailThird(Map<String, String> dateMap);

	/**
	 * 手术明细表 愈合 丁
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationDetail> queryOperationDetailForth(Map<String, String> dateMap);

	/**
	 * 分科病人手术操作质量 全院
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationQuality> queryOperationQualityByDept(Map<String, String> dateMap);

	/**
	 * 分科病人手术操作质量 外科系统
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationQuality> queryOperationQualityByDeptWaiKe(Map<String, String> dateMap);

	/**
	 * 分科病人手术操作质量 内科系统
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationQuality> queryOperationQualityByDeptNeiKe(Map<String, String> dateMap);

	/**
	 * 入出院诊断符合率
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<DiagnosticDto> queryDiagnosticRate(Map<String, String> dateMap);

	/**
	 * 手术前后诊断符合率
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<OperationDiagnostic> queryOperationDiagnosticRate(Map<String, String> dateMap);

	/**
	 * 临床主要诊断与病理诊断符合率
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<BingLiZhenDuanFuHeLvDto> queryBingLiZhenDuanFuHeLv(Map<String, String> dateMap);

	/**
	 * 重点手术疗效及费用(ICD)18以上
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<ZhongDianShouShuLiaoXiao18Dto> queryZhongDianShouShuLiaoXiao18(Map<String, String> dateMap);

	/**
	 * 重点疾病疗效及费用(ICD)18以上
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<ZhongDianJiBingLiaoXiao18Dto> queryZhongDianJiBingLiaoXiao(Map<String, String> dateMap);

	/**
	 * 重点疾病疗效及费用(ICD)18以上 卫生部
	 * 
	 * @param dateMap
	 * @return
	 */
	public List<ZhongDianJiBingLiaoXiao18Dto> queryZhongDianJiBingLiaoXiaoWeiShengBu(Map<String, String> dateMap);
}
