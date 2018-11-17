package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.DanweiDao;
import com.suyun.entity.Danwei;
import com.suyun.service.DanweiService;

@Service
public class DanweiServiceImpl implements DanweiService{
	
	@Autowired
	private DanweiDao danweiDao;

	@Override
	public PageBean finddanweiPage(String mc, PageParam pageParam) {
		return danweiDao.finddanweiPage(mc,pageParam);
	}

	@Override
	public int update(Danwei danwei) {
		if (danwei.getId()!=null) {
			Danwei data = danweiDao.getByKey(danwei.getId(), Danwei.class);
			danwei.setZt(data.getZt());
			return danweiDao.update(danwei);
		}else {
			return danweiDao.insert(danwei);
		}
	}

	@Override
	public Danwei danweibyid(Long id) {
		Danwei data = danweiDao.getByKey(id, Danwei.class);
		return data;
	}

	@Override
	public int danweidelete(Long id) {
		Danwei danwei = danweiDao.getByKey(id, Danwei.class);
		danwei.setZt("0");
		return danweiDao.update(danwei);
	}

	@Override
	public List<Danwei> findDanweiMc() {
		return danweiDao.findDanweiMc();
	}
}
