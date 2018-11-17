package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.dao.Zichan_louceng_fangjian_renyuanDao;
import com.suyun.entity.Zichan_louceng_fangjian_renyuan;
import com.suyun.response.Zichan_louceng_fangjian_renyuanResp;

@Transactional
@Repository("zichan_louceng_fangjian_renyuanDaoDao")
public class Zichan_louceng_fangjian_renyuanDaoImpl extends
		BaseDaoImpl<Zichan_louceng_fangjian_renyuan> implements
		Zichan_louceng_fangjian_renyuanDao {

	@Override
	public List<Zichan_louceng_fangjian_renyuanResp> findZlfryList(
			Long zichanId, Long loucengId, Long fangjianId) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (zichanId != null) {
			paramMap.put("zichan", zichanId);
		}
		if (loucengId != null) {
			paramMap.put("lou_ceng", loucengId);
		}
		if (fangjianId != null) {
			paramMap.put("fangjianId", fangjianId);
		}
		return super.getSqlSession().selectList("getRenYuanByFj", paramMap);
	}

	@Override
	public Zichan_louceng_fangjian_renyuan getRenYuanByFilter(Long zichanId,
			Long loucengId, Long fangjianId, Long renyuanId) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (zichanId != null) {
			paramMap.put("zichan", zichanId);
		}
		if (loucengId != null) {
			paramMap.put("lou_ceng", loucengId);
		}
		if (fangjianId != null) {
			paramMap.put("fang_jian", fangjianId);
		}
		if (renyuanId != null) {
			paramMap.put("renyuan", renyuanId);
		}
		return super.getByFilter(paramMap,
				Zichan_louceng_fangjian_renyuan.class);
	}

	@Override
	public int deleteRenYuanByFilter(Long zichanId, Long loucengId,
			Long fangjianId) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (zichanId != null) {
			paramMap.put("zichan", zichanId);
		}
		if (loucengId != null) {
			paramMap.put("lou_ceng", loucengId);
		}
		if (fangjianId != null) {
			paramMap.put("fang_jian", fangjianId);
		}
		return super.getSqlSession().delete("deleteRenYuanByFilter", paramMap);
	}

}
