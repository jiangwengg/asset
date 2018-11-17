package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Danwei;

public interface DanweiDao extends BaseDao<Danwei>{

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean finddanweiPage(String mc, PageParam pageParam);

	/**
	 * 查询单位名称
	 * @return
	 */
	List<Danwei> findDanweiMc();

}
