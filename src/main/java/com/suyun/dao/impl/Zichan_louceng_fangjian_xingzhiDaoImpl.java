package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_louceng_fangjian_xingzhiDao;
import com.suyun.entity.Zichan_louceng_fangjian_xingzhi;

@Transactional
@Repository("zichan_louceng_fangjian_xingzhiDaoDao")
public class Zichan_louceng_fangjian_xingzhiDaoImpl extends
		BaseDaoImpl<Zichan_louceng_fangjian_xingzhi> implements
		Zichan_louceng_fangjian_xingzhiDao {

	@Override
	public PageBean findxingzhiPage(String mc, PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		return listPage(pageParam, paramMap, "pagelist1");
	}

}
