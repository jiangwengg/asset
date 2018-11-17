package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_zuobiaoDao;
import com.suyun.entity.Zichan_zuobiao;
import com.suyun.response.Zichan_zuobiaoResp;

@Repository("zichan_zuobiaoDao")
public class Zichan_zuobiaoDaoImpl extends BaseDaoImpl<Zichan_zuobiao>
		implements Zichan_zuobiaoDao {

	@Override
	public PageBean findZcZuoBiaoList(String keywords, Long zichan,
			PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		if (zichan != null) {
			paramMap.put("zichan", zichan);
		}
		return listPage(pageParam, paramMap, "findZcZuoBiaoList");
	}

	@Override
	public Zichan_zuobiao getZcZbByZichan(Long zcId) {
		return super.getByUnique(zcId, "zichan", Zichan_zuobiao.class);
	}

	@Override
	public Zichan_zuobiaoResp getZcZbById(Long id) {
		return super.getSqlSession().selectOne("getZcZbById", id);
	}

	@Override
	public List<Zichan_zuobiaoResp> getZcZuoBiaoList() {
		return super.getSqlSession().selectList("getZcZuoBiaoList");
	}
}
