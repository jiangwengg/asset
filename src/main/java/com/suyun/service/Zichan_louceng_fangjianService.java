package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian;
import com.suyun.response.Zichan_louceng_fangjianResp;

public interface Zichan_louceng_fangjianService {

	/**
	 * 查询资产楼层房间列表
	 * 
	 * @param zichan
	 * @param louceng
	 * @param pageParam
	 * @return
	 */
	PageBean findZlfangList(String keywords, Long zichan, Long louceng,
			PageParam pageParam);

	/**
	 * 通过id查询资产楼层的信息
	 * 
	 * @param id
	 * @return
	 */
	Zichan_louceng_fangjianResp findZlfangById(Long id);

	/**
	 * 新增或者修改资产楼层房间
	 * 
	 * @param zlfj
	 * @return
	 */
	int updateZlfj(Zichan_louceng_fangjian zlfj, String renyuans);

	/**
	 * 查询房间列表不分页
	 * 
	 * @return
	 */
	List<Zichan_louceng_fangjian> findZlfjList(Long zichanId, Long lcid);

	/**
	 * 删除记录
	 * 
	 * @param id
	 * @param zt
	 * @return
	 */
	int changeZt(Long id, String zt);
}
