package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Danwei;

public interface DanweiService {

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean finddanweiPage(String mc, PageParam pageParam);

	/**
	 * 修改
	 * @param zichan_quanli_xz
	 * @return
	 */
	int update(Danwei danwei);

	/**
	 * 根据Id查询数据
	 * @param id
	 * @return
	 */
	Danwei danweibyid(Long id);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int danweidelete(Long id);

	/**
	 * 查询单位名称
	 * @return
	 */
	List<Danwei> findDanweiMc();

}
