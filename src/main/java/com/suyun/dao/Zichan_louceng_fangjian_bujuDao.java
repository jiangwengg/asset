package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian_buju;
import com.suyun.response.Zichan_louceng_fangjian_bujuResp;

public interface Zichan_louceng_fangjian_bujuDao extends
		BaseDao<Zichan_louceng_fangjian_buju> {

	/**
	 * 查询房间布局列表
	 * 
	 * @param keywords
	 * @param zichan
	 * @param louceng
	 * @param fangjian
	 * @param pageParam
	 * @return
	 */
	PageBean findZlfbjList(String keywords, Long zichan, Long louceng,
			Long fangjian, PageParam pageParam);

	/**
	 * 通过Id查询布局
	 * 
	 * @param id
	 * @return
	 */
	Zichan_louceng_fangjian_bujuResp getZlfbjById(Long id);
}