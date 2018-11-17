package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_biaojiDao;
import com.suyun.entity.Zichan_biaoji;
import com.suyun.response.Zichan_biaojiResp;

@Transactional
@Repository
public class Zichan_biaojiDaoImpl extends BaseDaoImpl<Zichan_biaoji> implements
		Zichan_biaojiDao {

	@Override
	public PageBean findPageList(Long zichan, String lx, String keywords,
			PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (zichan != null) {
			paramMap.put("zichan", zichan);
		}
		if (StringUtils.isNoneBlank(lx)) {
			paramMap.put("lx", lx);
		}
		if (StringUtils.isNoneBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		return listPage(pageParam, paramMap, "findBiaoJiList");
	}

	@Override
	public Zichan_biaojiResp getBiaoJiByid(Long id) {
		return super.getSqlSession().selectOne("getBiaoJiByid", id);
	}

	@Override
	public List<Zichan_biaoji> findBiaoJiList(String lx) {
		return super.getSqlSession().selectList("findBiaoJiListByLx",lx);
	}

}
