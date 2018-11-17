package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.ZiChanGYDao;
import com.suyun.entity.Zichan_gongyou;

@Repository
public class ZiChanGYDaoImpl extends BaseDaoImpl<Zichan_gongyou> implements ZiChanGYDao{

	@Override
	public PageBean findgypage(String mc, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		return listPage(pageParam, paramMap, "findgypage");
	}

}
