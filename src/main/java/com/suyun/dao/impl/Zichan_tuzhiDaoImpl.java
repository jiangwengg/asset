package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_tuzhiDao;
import com.suyun.entity.Zichan_tuzhi;

@Repository("zichan_tuzhiDao")
public class Zichan_tuzhiDaoImpl extends BaseDaoImpl<Zichan_tuzhi> implements
		Zichan_tuzhiDao {

	@Override
	public PageBean findZcTzList(String keywords, Long zichan,
			PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		if (zichan != null) {
			paramMap.put("zichan", zichan);
		}
		return listPage(pageParam, paramMap, "findZcTzList");
	}

	@Override
	public Zichan_tuzhi getZcTzByZichan(Long zcid) {
		return super.getByUnique(zcid, "zichan", Zichan_tuzhi.class);
	}

}
