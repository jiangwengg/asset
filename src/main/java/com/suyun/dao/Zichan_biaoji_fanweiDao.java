package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_biaoji_fanwei;

public interface Zichan_biaoji_fanweiDao extends BaseDao<Zichan_biaoji_fanwei> {

	/**
	 * 分页查询
	 * 
	 * @param zichan
	 * @param louceng
	 * @param fangjian
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(String zichan, String louceng, String fangjian,
			PageParam pageParam);

	/**
	 * 通过表计查询范围
	 * 
	 * @param id
	 * @return
	 */
	Zichan_biaoji_fanwei getZcbjfwByBiaoji(Long biaoji);

}
