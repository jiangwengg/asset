package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_biaoji;
import com.suyun.response.Zichan_biaojiResp;

public interface Zichan_biaojiDao extends BaseDao<Zichan_biaoji> {

	/**
	 * 查询表计分页列表
	 * 
	 * @param zichan
	 * @param lx
	 * @param keywords
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(Long zichan, String lx, String keywords,
			PageParam pageParam);

	/**
	 * 查询一条表计范围详情
	 * 
	 * @param id
	 * @return
	 */
	Zichan_biaojiResp getBiaoJiByid(Long id);

	/**
	 * 查询表计列表
	 * 
	 * @param lx
	 * @return
	 */
	List<Zichan_biaoji> findBiaoJiList(String lx);

}
