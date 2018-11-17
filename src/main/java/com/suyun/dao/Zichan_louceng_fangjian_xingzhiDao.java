package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian_xingzhi;

public interface Zichan_louceng_fangjian_xingzhiDao extends BaseDao<Zichan_louceng_fangjian_xingzhi> {

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findxingzhiPage(String mc, PageParam pageParam);



}