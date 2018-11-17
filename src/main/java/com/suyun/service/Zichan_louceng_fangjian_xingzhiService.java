package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian_xingzhi;

public interface Zichan_louceng_fangjian_xingzhiService {

	/**
	 * 查询资产楼层房间性质列表
	 * 
	 * @return
	 */
	List<Zichan_louceng_fangjian_xingzhi> findZlfxzList();

	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @return
	 */
	PageBean findxingzhiPage(String mc, PageParam pageParam);

	/**
	 * 楼层房间性质修改
	 * @param xingzhi
	 * @return
	 */
	int update(Zichan_louceng_fangjian_xingzhi xingzhi);

	/**
	 * 根据Id查找数据
	 * @param id
	 * @return
	 */
	Zichan_louceng_fangjian_xingzhi xingzhibyid(Long id);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int xingzhidelete(Long id);

}
