package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Danwei_bumenDao;
import com.suyun.entity.Danwei_bumen;

@Transactional
@Repository
public class Danwei_bumenDaoImpl extends BaseDaoImpl<Danwei_bumen> implements Danwei_bumenDao{

	@Override
	public PageBean findBumenPage(String mc, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		return listPage(pageParam, paramMap, "findBumenPage");
	}

	@Override
	public List<Danwei_bumen> findBumenMc() {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return listBy(paramMap, "findBumenMc");
	}

}
