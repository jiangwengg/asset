package com.suyun.service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;

public interface Zichan_biaoji_fanweiService {

	/**
	 * 分页查询
	 * @param zichan
	 * @param louceng
	 * @param fangjian
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(String zichan, String louceng, String fangjian,
			PageParam pageParam);

}
