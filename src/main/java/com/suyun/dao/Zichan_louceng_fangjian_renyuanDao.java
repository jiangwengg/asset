package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.entity.Zichan_louceng_fangjian_renyuan;
import com.suyun.response.Zichan_louceng_fangjian_renyuanResp;

public interface Zichan_louceng_fangjian_renyuanDao extends
		BaseDao<Zichan_louceng_fangjian_renyuan> {

	List<Zichan_louceng_fangjian_renyuanResp> findZlfryList(Long zichanId,
			Long loucengId, Long fangjianId);

	Zichan_louceng_fangjian_renyuan getRenYuanByFilter(Long zichanId,
			Long loucengId, Long fangjianId, Long renyuanId);

	int deleteRenYuanByFilter(Long zichanId, Long loucengId, Long fangjianId);
}