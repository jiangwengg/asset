package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Aq_yhDao;
import com.suyun.entity.Aq_yh;

@Repository("aq_yhDao")
public class Aq_yhDaoImpl extends BaseDaoImpl<Aq_yh> implements Aq_yhDao {

	@Override
	public PageBean findPageList(String keywords, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		return listPage(pageParam, paramMap, "findAqYhPage");
	}

	@Override
	public Aq_yh findYhByYhm(String yhm) {
		return getByUnique(yhm, "yhm", Aq_yh.class);
	}

}
