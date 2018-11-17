package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Danwei_bumen;

public interface Danwei_bumenDao extends BaseDao<Danwei_bumen> {

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findBumenPage(String mc, PageParam pageParam);

	/**
	 * 查询状态为1的部门
	 * @return
	 */
	List<Danwei_bumen> findBumenMc();

}
