package com.suyun.service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian_buju;
import com.suyun.response.Zichan_louceng_fangjian_bujuResp;

public interface Zichan_louceng_fangjian_bujuService {

	/**
	 * 查询资产楼层房间布局列表
	 * 
	 * @param keywords
	 * @param zichan
	 * @param louceng
	 * @param fangjian
	 * @param pageParam
	 * @return
	 */
	PageBean findZlfbjList(String keywords, Long zichan, Long louceng,
			Long fangjian, PageParam pageParam);

	/**
	 * 新增或者修改资产楼层房间布局
	 * 
	 * @param zlfbj
	 * @return
	 */
	int updateZlfbj(Zichan_louceng_fangjian_buju zlfbj);

	/**
	 * 通过Id查询房间布局
	 * 
	 * @param id
	 * @return
	 */
	Zichan_louceng_fangjian_bujuResp getZlfbjById(Long id);

}
