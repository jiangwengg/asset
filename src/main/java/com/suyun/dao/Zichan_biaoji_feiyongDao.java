package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_biaoji_feiyong;

public interface Zichan_biaoji_feiyongDao extends
		BaseDao<Zichan_biaoji_feiyong> {

	/**
	 * 查询表计费用列表
	 * 
	 * @param zichan
	 * @param bjlx
	 * @param keywords
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(Long biaoji, String bjlx, String keywords,
			PageParam pageParam);

}
