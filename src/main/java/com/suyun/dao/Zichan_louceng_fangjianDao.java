package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian;
import com.suyun.response.Zichan_louceng_fangjianResp;

public interface Zichan_louceng_fangjianDao extends
		BaseDao<Zichan_louceng_fangjian> {

	/**
	 * 查询资产楼层房间列表
	 * 
	 * @param keywords
	 * @param zichan
	 * @param louceng
	 * @param pageParam
	 * @return
	 */
	PageBean findZlfangList(String keywords, Long zichan, Long louceng,
			PageParam pageParam);

	/**
	 * 通过房间Id查询资产楼层房间信息
	 * 
	 * @param id
	 * @return
	 */
	Zichan_louceng_fangjianResp findZlfangById(Long id);

	/**
	 * 通过楼层编号查询房间列表
	 * 
	 * @param zichanId
	 * @param lcid
	 * @return
	 */
	List<Zichan_louceng_fangjian> findZlfjList(Long zichanId, Long lcid);

}