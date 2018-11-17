package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Aq_yh;

public interface Aq_yhService {

	/**
	 * 查询用户列表
	 * 
	 * @return
	 */
	List<Aq_yh> findYhList();

	/**
	 * 用户分页列表
	 * 
	 * @param keywords
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(String keywords, PageParam pageParam);

	/**
	 * 根据Id查询数据
	 * 
	 * @param id
	 * @return
	 */
	Aq_yh findYhById(Long id);
	
	/**
	 * 
	 * @param yhm
	 * @return
	 */
	Aq_yh findYhByYhm(String yhm);

	/**
	 * 添加修改
	 * 
	 * @param yh
	 * @return
	 */
	int update(Aq_yh yh);

	/**
	 * 删除
	 * 
	 * @param id
	 * @param zt
	 * @return
	 */
	int changeZt(Long id, Long zt);

}
