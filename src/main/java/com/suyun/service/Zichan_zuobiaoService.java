package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_zuobiao;
import com.suyun.response.Zichan_zuobiaoResp;

public interface Zichan_zuobiaoService {

	/**
	 * 查询资产坐标
	 * 
	 * @param keywords
	 * @param zichan
	 * @param pageParam
	 * @return
	 */
	PageBean findZcZuoBiaoList(String keywords, Long zichan, PageParam pageParam);

	/**
	 * 获取列表
	 * 
	 * @return
	 */
	List<Zichan_zuobiaoResp> getZcZuoBiaoList();

	/**
	 * 新增或修改资产坐标
	 * 
	 * @param zuoBiao
	 * @return
	 */
	int updateZcZuoBiao(Zichan_zuobiao zuoBiao);

	/**
	 * 通过ID查询坐标
	 * 
	 * @param id
	 * @return
	 */
	Zichan_zuobiaoResp getZcZbById(Long id);

	/**
	 * 通过资产ID查询坐标
	 * 
	 * @param zcid
	 * @return
	 */
	Zichan_zuobiao getZcZbByZichan(Long zcId);

}
