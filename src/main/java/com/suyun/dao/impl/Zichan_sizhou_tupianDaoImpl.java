package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_sizhou_tupianDao;
import com.suyun.entity.Zichan_sizhou_tupian;

@Repository("zichan_sizhou_tupianDao")
public class Zichan_sizhou_tupianDaoImpl extends
		BaseDaoImpl<Zichan_sizhou_tupian> implements Zichan_sizhou_tupianDao {

	@Override
	public PageBean findZcTpList(String keywords, Long zichan,
			PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		if (zichan != null) {
			paramMap.put("zichan", zichan);
		}
		return listPage(pageParam, paramMap, "findZcTpList");
	}

	@Override
	public Zichan_sizhou_tupian getZcTpByZichan(Long zcid) {
		return super.getByUnique(zcid, "zichan", Zichan_sizhou_tupian.class);
	}

}
