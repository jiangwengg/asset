package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_loucengDao;
import com.suyun.entity.Zichan_louceng;

@Repository("zichan_loucengDao")
public class Zichan_loucengDaoImpl extends BaseDaoImpl<Zichan_louceng>
		implements Zichan_loucengDao {

	@Override
	public List<Zichan_louceng> findZclList(Long zichan) {
		return super.getSqlSession().selectList("findZclList", zichan);
	}

	@Override
	public PageBean findPageList(Long zichanId,Long bh, String mc, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		if (bh!=null) {
			paramMap.put("bh", bh);
		}
		if (zichanId!=null) {
			paramMap.put("zichanId",zichanId);
		}
		return listPage(pageParam, paramMap, "findZcLouCengPage");
	}

}
