package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.DanweiDao;
import com.suyun.entity.Danwei;

@Transactional
@Repository
public class DanweiDaoImpl extends BaseDaoImpl<Danwei> implements DanweiDao{

	@Override
	public PageBean finddanweiPage(String mc, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		return listPage(pageParam, paramMap, "finddanweiPage");
	}

	@Override
	public List<Danwei> findDanweiMc() {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return listBy(paramMap, "findDanweiMc");
	}

}
