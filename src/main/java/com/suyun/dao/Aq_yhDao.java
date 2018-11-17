package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Aq_yh;

public interface Aq_yhDao extends BaseDao<Aq_yh> {

	PageBean findPageList(String keywords, PageParam pageParam);

	Aq_yh findYhByYhm(String yhm);

	
	
}