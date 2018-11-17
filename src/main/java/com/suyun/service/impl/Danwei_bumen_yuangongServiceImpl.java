package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Danwei_bumen_yuangongDao;
import com.suyun.entity.Danwei_bumen_yuangong;
import com.suyun.service.Danwei_bumen_yuangongService;

@Service
public class Danwei_bumen_yuangongServiceImpl implements Danwei_bumen_yuangongService{

	@Autowired
	private Danwei_bumen_yuangongDao yuangongDao;
	
	@Override
	public PageBean findYuangoongPage(String mc, PageParam pageParam) {
		return yuangongDao.findYuangoongPage(mc,pageParam);
	}

	@Override
	public int update(Danwei_bumen_yuangong yuangong) {
		if (yuangong.getId()!=null) {
			Danwei_bumen_yuangong data = yuangongDao.getByKey(yuangong.getId(), Danwei_bumen_yuangong.class);
			yuangong.setZt(data.getZt());
			return yuangongDao.update(yuangong);
		}else {
			return yuangongDao.insert(yuangong);
		}
	}

	@Override
	public Danwei_bumen_yuangong danweibyid(Long id) {
		Danwei_bumen_yuangong data = yuangongDao.getByKey(id, Danwei_bumen_yuangong.class);
		return data;
	}

	@Override
	public int delete(Long id) {
		Danwei_bumen_yuangong yuangong = yuangongDao.getByKey(id, Danwei_bumen_yuangong.class);
		yuangong.setZt("0");
		return yuangongDao.update(yuangong);
	}

	@Override
	public List<Danwei_bumen_yuangong> findYuangongList() {
		return yuangongDao.findYuangongList();
	}

}
