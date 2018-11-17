package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_quanli_lx;

public interface QuanLi_lxService {

	/**
	 * 查询所有资产权利类型
	 * @return
	 */
	List<Zichan_quanli_lx> findAll();

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findqllxPage(String mc, PageParam pageParam);

	/**
	 * 修改
	 * @param quanli_lx
	 * @return
	 */
	int update(Zichan_quanli_lx quanli_lx);

	/**
	 * 根据id查找数据
	 * @param id
	 * @return
	 */
	Zichan_quanli_lx qllxbyid(Long id);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int qllxdelete(Long id);

}
