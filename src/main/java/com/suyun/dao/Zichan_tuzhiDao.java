package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_tuzhi;

public interface Zichan_tuzhiDao extends BaseDao<Zichan_tuzhi> {

	/**
	 * 查询资产四周图纸列表
	 * 
	 * @param keywords
	 * @param zichan
	 * @param pageParam
	 * @return
	 */
	PageBean findZcTzList(String keywords, Long zichan, PageParam pageParam);

	/**
	 * 通过资产查询图纸
	 * 
	 * @param zcid
	 * @return
	 */
	Zichan_tuzhi getZcTzByZichan(Long zcid);

}