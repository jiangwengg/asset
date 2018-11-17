package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_louceng_fangjian_bujuDao;
import com.suyun.entity.Zichan_louceng_fangjian_buju;
import com.suyun.response.Zichan_louceng_fangjian_bujuResp;

@Repository("zichan_louceng_fangjian_bujuDao")
public class Zichan_louceng_fangjian_bujuDaoImpl extends
		BaseDaoImpl<Zichan_louceng_fangjian_buju> implements
		Zichan_louceng_fangjian_bujuDao {

	@Override
	public PageBean findZlfbjList(String keywords, Long zichan, Long louceng,
			Long fangjian, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (StringUtils.isNotBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		if (zichan != null) {
			paramMap.put("zichan", zichan);
		}
		if (louceng != null) {
			paramMap.put("louceng", louceng);
		}
		if (zichan != null) {
			paramMap.put("fangjian", fangjian);
		}
		return listPage(pageParam, paramMap, "findZlfbjList");
	}

	@Override
	public Zichan_louceng_fangjian_bujuResp getZlfbjById(Long id) {
		return super.getSqlSession().selectOne("getZlfbjById", id);
	}

}
