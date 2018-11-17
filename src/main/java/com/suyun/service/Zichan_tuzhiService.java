package com.suyun.service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_tuzhi;

public interface Zichan_tuzhiService {

	/**
	 * 查询资产四周图纸
	 * 
	 * @param keywords
	 * @param zichan
	 * @param pageParam
	 * @return
	 */
	PageBean findZcTzList(String keywords, Long zichan, PageParam pageParam);

	/**
	 * 新增或修改资产图纸
	 * 
	 * @param ZcTz
	 * @return
	 */
	int updateZcTz(Zichan_tuzhi ZcTz);

	/**
	 * 通过ID查询四周图纸
	 * 
	 * @param id
	 * @return
	 */
	Zichan_tuzhi getZcTzById(Long id);

	/**
	 * 通过资产ID查询图纸
	 * 
	 * @param zcid
	 * @return
	 */
	Zichan_tuzhi getZcTzByZichan(Long zcid);

	/**
	 * 更新状态
	 * 
	 * @param id
	 * @param zt
	 * @return
	 */
	int updateZt(Long id, String zt);
}
