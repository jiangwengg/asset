package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_gongyou;

public interface ZiChanGYDao extends BaseDao<Zichan_gongyou> {

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findgypage(String mc, PageParam pageParam);

}
