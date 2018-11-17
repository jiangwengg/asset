package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_gongyou;

public interface ZiChanGYService {

	/**
	 * 查询所有
	 * @return
	 */
	List<Zichan_gongyou> findAll();

	/**
	 * 分页查询共有情况
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findgypage(String mc, PageParam pageParam);

	/**
	 * 修改
	 * @param shiyongren
	 * @return
	 */
	int update(Zichan_gongyou gongyou);

	/**
	 * 根据Id查找数据
	 * @param id
	 * @return
	 */
	Zichan_gongyou gybyid(Long id);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int gydelete(Long id);


}
