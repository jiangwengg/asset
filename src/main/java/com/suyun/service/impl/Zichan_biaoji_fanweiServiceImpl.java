package com.suyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_biaoji_fanweiDao;
import com.suyun.service.Zichan_biaoji_fanweiService;

@Service
public class Zichan_biaoji_fanweiServiceImpl implements Zichan_biaoji_fanweiService{

	@Autowired
	private Zichan_biaoji_fanweiDao zichan_biaoji_fanweiDao;
	
	@Override
	public PageBean findPageList(String zichan, String louceng,
			String fangjian, PageParam pageParam) {
		return zichan_biaoji_fanweiDao.findPageList(zichan,louceng,fangjian,pageParam);
	}

}
