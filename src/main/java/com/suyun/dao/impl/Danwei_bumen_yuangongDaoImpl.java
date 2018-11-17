package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Danwei_bumen_yuangongDao;
import com.suyun.entity.Danwei_bumen_yuangong;

@Transactional
@Repository
public class Danwei_bumen_yuangongDaoImpl extends BaseDaoImpl<Danwei_bumen_yuangong> 
		implements Danwei_bumen_yuangongDao {

	@Override
	public PageBean findYuangoongPage(String mc, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		return listPage(pageParam, paramMap, "findYuangongPage");
	}

	@Override
	public List<Danwei_bumen_yuangong> findYuangongList() {
		return super.getSqlSession().selectList("findYuangongPage");
	}

			
}
