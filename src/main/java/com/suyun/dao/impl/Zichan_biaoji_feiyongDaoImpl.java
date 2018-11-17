package com.suyun.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_biaoji_feiyongDao;
import com.suyun.entity.Zichan_biaoji_feiyong;

@Transactional
@Repository
public class Zichan_biaoji_feiyongDaoImpl extends
		BaseDaoImpl<Zichan_biaoji_feiyong> implements Zichan_biaoji_feiyongDao {

	@Override
	public PageBean findPageList(Long biaoji, String bjlx, String keywords,
			PageParam pageParam) {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (biaoji != null) {
			paramMap.put("biaoji", biaoji);
		}
		if (StringUtils.isNoneBlank(bjlx)) {
			paramMap.put("bjlx", bjlx);
		}
		if (StringUtils.isNoneBlank(keywords)) {
			paramMap.put("keywords", keywords);
		}
		return listPage(pageParam, paramMap, "findBiaoJiFeiYongList");
	}

}
