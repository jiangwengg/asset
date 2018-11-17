package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_quanli_xz;

public interface ZichanquanlixzService {

	/**
	 * 分页查询权利性质
	 * 
	 * @param mc
	 * @return
	 */
	PageBean findqlxzPage(String mc, PageParam pageParam);

	/**
	 * 修改
	 * 
	 * @param zichan_quanli_xz
	 * @return
	 */
	int update(Zichan_quanli_xz zichan_quanli_xz);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int qlxzdelete(Long id);

	/**
	 * 根据Id查找数据
	 * 
	 * @param id
	 * @return
	 */
	Zichan_quanli_xz qlxzbyid(Long id);

	/**
	 * 查询所有资产权利性质
	 * 
	 * @return
	 */
	List<Zichan_quanli_xz> findAll();
}
