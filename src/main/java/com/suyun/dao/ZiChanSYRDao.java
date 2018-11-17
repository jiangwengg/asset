package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_shiyongren;

public interface ZiChanSYRDao extends BaseDao<Zichan_shiyongren>{

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findsyrpage(String mc, PageParam pageParam);

}
