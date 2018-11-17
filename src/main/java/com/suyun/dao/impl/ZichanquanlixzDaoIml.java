package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.ZichanquanlixzDao;
import com.suyun.entity.Zichan_quanli_xz;

@Transactional
@Repository
public class ZichanquanlixzDaoIml extends BaseDaoImpl<Zichan_quanli_xz> implements ZichanquanlixzDao {

	@Override
	public PageBean findqlxzPage(String mc,PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		return listPage(pageParam, paramMap, "findqlxzPage");
	}
	
}
