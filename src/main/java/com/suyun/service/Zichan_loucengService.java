package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng;

public interface Zichan_loucengService {

	/**
	 * 查询资产楼层列表
	 * 
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

	/**
	 * 根据Id查询数据
	 * 
	 * @param id
	 * @return
	 */
	Zichan_louceng findById(Long id);

	/**
	 * 添加修改
	 * 
	 * @param zichan_louceng
	 * @return
	 */
	int update(Zichan_louceng zichan_louceng);

	/**
	 * 删除
	 * 
	 * @param id
	 * @param zt
	 * @return
	 */
	int changeZt(Long id, String zt);

}
