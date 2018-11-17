package com.suyun.service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_biaoji_feiyong;

public interface Zichan_biaoji_feiyongService {

	/**
	 * 查询资产表计费用列表
	 * 
	 * @param biaoji
	 * @param bjlx
	 * @param keywords
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(Long biaoji, String bjlx, String keywords,
			PageParam pageParam);

	/**
	 * 根据id查询一条记录
	 * 
	 * @param id
	 * @return
	 */
	Zichan_biaoji_feiyong getBiaoJiFeiYongByid(Long id);

	/**
	 * 更新资产表计费用
	 * 
	 * @param zcbjfy
	 * @return
	 */
	int updateZcbjfy(Zichan_biaoji_feiyong zcbjfy);
}
