package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Danwei_bumen;

public interface Danwei_bumenService {

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findBumenPage(String mc, PageParam pageParam);

	/**
	 * 修改
	 * @param bumen
	 * @return
	 */
	int update(Danwei_bumen bumen);

	/**
	 * 根据Id查询数据
	 * @param id
	 * @return
	 */
	Danwei_bumen danweibyid(Long id);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 查询状态为1的部门
	 * @return
	 */
	List<Danwei_bumen> findBumenMc();

}
