package com.suyun.service;

import java.util.List;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan;
import com.suyun.entity.Zichan_quanli_xz;
import com.suyun.vo.ZiChanVO;

public interface ZiChanService {

	/**
	 * 分页查询
	 * 
	 * @param keywords
	 * @param pageParam
	 * @return
	 */
	PageBean findPageList(String keywords,String mc,String zhengjian_zt,Long quanli_lx,Long quanli_xingzhi,PageParam pageParam);

	/**
	 * 查询资产列表
	 * 
	 * @return
	 */
	List<Zichan> findZcList();

	/**
	 * 根据Id查询数据
	 * @param id
	 * @return
	 */
	Zichan findById(Long id);

	/**
	 * 添加/修改数据
	 * @param zichan
	 * @return
	 */
	int updateZichan(Zichan zichan);

	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	ZiChanVO details(Long id);

	/**
	 * 查询所有资产id和名称
	 * @return
	 */
	List<Zichan_quanli_xz> findIdMc();

}
