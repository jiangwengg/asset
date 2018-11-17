package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_shiyongren;

public interface ZichanSYRService {

	/**
	 * 查询所有使用人
	 * @return
	 */
	List<Zichan_shiyongren> findAll();

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findsyrpage(String mc, PageParam pageParam);

	/**
	 * 修改
	 * @param zichan_quanli_xz
	 * @return
	 */
	int update(Zichan_shiyongren shiyongren);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	Zichan_shiyongren syrbyid(Long id);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int syrdelete(Long id);

}
