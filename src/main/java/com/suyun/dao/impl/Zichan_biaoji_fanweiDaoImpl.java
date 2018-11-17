package com.suyun.dao.impl;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_biaoji_fanweiDao;
import com.suyun.entity.Zichan_biaoji_fanwei;

@Transactional
@Repository
public class Zichan_biaoji_fanweiDaoImpl extends BaseDaoImpl<Zichan_biaoji_fanwei> implements Zichan_biaoji_fanweiDao{

	@Override
	public PageBean findPageList(String zichan, String louceng,
			String fangjian, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (zichan != null) {
			paramMap.put("zichan", zichan);
		}
		if (louceng != null) {
			paramMap.put("louceng", louceng);
		}
		if (zichan != null) {
			paramMap.put("fangjian", fangjian);
		}
		return listPage(pageParam, paramMap, "PageList");
	}

	@Override
	public Zichan_biaoji_fanwei getZcbjfwByBiaoji(Long biaoji) {
		return super.getByUnique(biaoji, "biaoji", Zichan_biaoji_fanwei.class);
	}

}
