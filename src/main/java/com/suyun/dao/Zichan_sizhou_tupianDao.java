package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_sizhou_tupian;

public interface Zichan_sizhou_tupianDao extends BaseDao<Zichan_sizhou_tupian> {

	/**
	 * 查询资产四周图片列表
	 * 
	 * @param keywords
	 * @param zichan
	 * @param pageParam
	 * @return
	 */
	PageBean findZcTpList(String keywords, Long zichan, PageParam pageParam);

	/**
	 * 通过资产查询图片
	 * @param zcid
	 * @return
	 */
	Zichan_sizhou_tupian getZcTpByZichan(Long zcid);

}