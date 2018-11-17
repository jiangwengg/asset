package com.suyun.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.ZiChanDao;
import com.suyun.entity.Zichan;
import com.suyun.entity.Zichan_quanli_xz;
import com.suyun.vo.ZiChanVO;

@Repository
public class ZiChanDaoImpl extends BaseDaoImpl<Zichan> implements ZiChanDao {

	@Override
	public PageBean findPageList(String keywords, String mc,
			String zhengjian_zt, Long quanli_lx, Long quanli_xingzhi,
			PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isNoneBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		if (StringUtils.isNoneBlank(mc)) {
			paramMap.put("mc", mc);
		}
		if (StringUtils.isNoneBlank(zhengjian_zt)) {
			paramMap.put("zhengjian_zt", zhengjian_zt);
		}
		if (quanli_lx != null) {
			paramMap.put("quanli_lx", quanli_lx);
		}
		if (quanli_xingzhi != null) {
			paramMap.put("quanli_xingzhi", quanli_xingzhi);
		}
		return listPage(pageParam, paramMap, "findPageList");
	}

	@Override
	public List<Zichan> findZcList() {
		return super.getSqlSession().selectList("findZcList");
	}

	@Override
	public ZiChanVO details(Long id) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (id != null || ("").equals(id)) {
			paramMap.put("id", id);
		}
		return super.getSqlSession().selectOne("details", paramMap);
	}

	@Override
	public List<Zichan_quanli_xz> findIdMc() {
		HashMap<String, Object> paramMap = new HashMap<>();
		return listBy(paramMap, "findIdMc");
	}

}
