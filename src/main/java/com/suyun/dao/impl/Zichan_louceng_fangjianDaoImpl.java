package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_louceng_fangjianDao;
import com.suyun.entity.Zichan_louceng_fangjian;
import com.suyun.response.Zichan_louceng_fangjianResp;

@Repository("zichan_louceng_fangjianDao")
public class Zichan_louceng_fangjianDaoImpl extends
		BaseDaoImpl<Zichan_louceng_fangjian> implements
		Zichan_louceng_fangjianDao {

	@Override
	public PageBean findZlfangList(String keywords, Long zichan, Long louceng,
			PageParam pageParam) {
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
		return listPage(pageParam, paramMap, "findZlfangList");
	}

	@Override
	public Zichan_louceng_fangjianResp findZlfangById(Long id) {
		return super.getSqlSession().selectOne("findZlfangById", id);
	}

	@Override
	public List<Zichan_louceng_fangjian> findZlfjList(Long zichanId, Long lcid) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (zichanId != null) {
			paramMap.put("zichanId", zichanId);
		}
		if (lcid != null) {
			paramMap.put("lcid", lcid);
		}
		return super.getSqlSession().selectList("findZlfjList", paramMap);
	}
}
