package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng;

public interface Zichan_loucengDao extends BaseDao<Zichan_louceng> {

	/**
	 * 通过资产查询资产楼层列表
	 * 
	 * @param zichan
	 * @return
	 */
	List<Zichan_louceng> findZclList(Long zichan);

	/**
	 * 分页查询
	 * 
	 * @param vo
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(Long zichanId, Long bh, String mc, PageParam pageParam);

}