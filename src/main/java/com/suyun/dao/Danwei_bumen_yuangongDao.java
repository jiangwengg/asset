package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Danwei_bumen_yuangong;

public interface Danwei_bumen_yuangongDao extends
		BaseDao<Danwei_bumen_yuangong> {

	/**
	 * 分页查询
	 * 
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findYuangoongPage(String mc, PageParam pageParam);

	/**
	 * 列表
	 * 
	 * @return
	 */
	List<Danwei_bumen_yuangong> findYuangongList();

}
