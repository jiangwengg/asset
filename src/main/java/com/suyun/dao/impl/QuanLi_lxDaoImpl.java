package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.QuanLi_lxDao;
import com.suyun.entity.Zichan_quanli_lx;

@Transactional
@Repository
public class QuanLi_lxDaoImpl extends BaseDaoImpl<Zichan_quanli_lx> implements QuanLi_lxDao{

	@Override
	public PageBean findqllxPage(String mc, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		return listPage(pageParam, paramMap, "pagelist");
	}

}
