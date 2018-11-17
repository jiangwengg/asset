package com.suyun.service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_sizhou_tupian;

public interface Zichan_sizhou_tupianService {

	/**
	 * 查询资产四周图片
	 * 
	 * @param keywords
	 * @param zichan
	 * @param pageParam
	 * @return
	 */
	PageBean findZcTpList(String keywords, Long zichan, PageParam pageParam);

	/**
	 * 新增或修改资产图片
	 * 
	 * @param zctp
	 * @return
	 */
	int updateZcTp(Zichan_sizhou_tupian zctp);

	/**
	 * 通过ID查询四周图片
	 * 
	 * @param id
	 * @return
	 */
	Zichan_sizhou_tupian getZcTpById(Long id);

	/**
	 * 通过资产ID查询图片
	 * 
	 * @param zcid
	 * @return
	 */
	Zichan_sizhou_tupian getZcTpByZichan(Long zcid);
}
