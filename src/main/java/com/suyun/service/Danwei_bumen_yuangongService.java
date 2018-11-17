package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Danwei_bumen_yuangong;

public interface Danwei_bumen_yuangongService {

	/**
	 * 分页查询
	 * 
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findYuangoongPage(String mc, PageParam pageParam);

	/**
	 * 修改
	 * 
	 * @param yuangong
	 * @return
	 */
	int update(Danwei_bumen_yuangong yuangong);

	/**
	 * 根据id修改数据
	 * 
	 * @param id
	 * @return
	 */
	Danwei_bumen_yuangong danweibyid(Long id);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 查询单位部门员工列表
	 * 
	 * @return
	 */
	List<Danwei_bumen_yuangong> findYuangongList();
}
