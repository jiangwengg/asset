package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_quanli_lx;

public interface QuanLi_lxDao extends BaseDao<Zichan_quanli_lx>{

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findqllxPage(String mc, PageParam pageParam);

}
