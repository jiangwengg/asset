package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan;
import com.suyun.entity.Zichan_quanli_xz;
import com.suyun.vo.ZiChanVO;

public interface ZiChanDao extends BaseDao<Zichan> {

	/**
	 * 分页查询数据
	 * 
	 * @param keywords
	 * @param quanli_xingzhi 
	 * @param quanli_lx 
	 * @param zhengjian_zt 
	 * @param mc 
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(String keywords, String mc, String zhengjian_zt, Long quanli_lx, Long quanli_xingzhi, PageParam pageParam);

	/**
	 * 查询资产列表
	 * 
	 * @return
	 */
	List<Zichan> findZcList();

	/**
	 * 根据Id查询数据详情
	 * @param id
	 * @return
	 */
	ZiChanVO details(Long id);

	/**
	 * 查询所有资产id mc
	 * @return
	 */
	List<Zichan_quanli_xz> findIdMc();

}
