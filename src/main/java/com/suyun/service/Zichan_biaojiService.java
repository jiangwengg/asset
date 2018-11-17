package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_biaoji;
import com.suyun.response.Zichan_biaojiResp;

public interface Zichan_biaojiService {

	/**
	 * 查询资产表计列表
	 * 
	 * @param zichan
	 * @param lx
	 * @param keywords
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(Long zichan, String lx, String keywords,
			PageParam pageParam);

	/**
	 * 根据id查询一条记录
	 * 
	 * @param id
	 * @return
	 */
	Zichan_biaojiResp getBiaoJiByid(Long id);

	/**
	 * 更新资产表计
	 * 
	 * @param zcbj
	 * @return
	 */
	int updateZcbj(Zichan_biaojiResp zcbj);

	/**
	 * 根据类型查询表计
	 * 
	 * @param lx
	 * @return
	 */
	List<Zichan_biaoji> findBiaoJiList(String lx);
}
