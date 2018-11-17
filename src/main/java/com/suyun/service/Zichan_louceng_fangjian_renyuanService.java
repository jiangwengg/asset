package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian_renyuan;
import com.suyun.response.Zichan_louceng_fangjian_renyuanResp;

public interface Zichan_louceng_fangjian_renyuanService {

	/**
	 * 资产楼层房间人员
	 * 
	 * @return
	 */
	List<Zichan_louceng_fangjian_renyuanResp> findZlfryList(Long zichanId,
			Long loucengId, Long fangjianId);

	/**
	 * 分页查询
	 * 
	 * @param keywords
	 * @param pageParam
	 * @return
	 */
	PageBean findRenYuanPage(String keywords, PageParam pageParam);

	/**
	 * 楼层房间人员修改
	 * 
	 * @param renyuan
	 * @return
	 */
	int update(Zichan_louceng_fangjian_renyuan renyuan);

	/**
	 * 根据Id查找数据
	 * 
	 * @param id
	 * @return
	 */
	Zichan_louceng_fangjian_renyuan getRenYuanById(Long id);

	/**
	 * 改变状态
	 * 
	 * @param id
	 * @return
	 */
	int changeRenYuan(Long id, Long ztf);

	/**
	 * 查询是否存在
	 * 
	 * @param zichanId
	 * @param loucengId
	 * @param fangjianId
	 * @return
	 */
	Zichan_louceng_fangjian_renyuan getRenYuanByFilter(Long zichanId,
			Long loucengId, Long fangjianId, Long renyuanId);

	/**
	 * 删除房间人员
	 * 
	 * @param zichanId
	 * @param loucengId
	 * @param fangjianId
	 * @return
	 */
	int deleteRenYuanByFilter(Long zichanId, Long loucengId, Long fangjianId);
}
