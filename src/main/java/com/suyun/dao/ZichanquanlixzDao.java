package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_quanli_xz;

public interface ZichanquanlixzDao  extends BaseDao<Zichan_quanli_xz>{

	/**
	 * 分页查询数据
	 * @param mc
	 * @return
	 */
	PageBean findqlxzPage(String mc,PageParam pageParam);

}
