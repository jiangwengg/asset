package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Danwei_bumenDao;
import com.suyun.entity.Danwei_bumen;
import com.suyun.service.Danwei_bumenService;

@Service
public class Danwei_bumenServiceImpl implements Danwei_bumenService{

	@Autowired
	private Danwei_bumenDao danwei_bumenDao;
	@Override
	public PageBean findBumenPage(String mc, PageParam pageParam) {
		return danwei_bumenDao.findBumenPage(mc,pageParam);
	}
	@Override
	public int update(Danwei_bumen bumen) {
		if (bumen.getId()!=null) {
			Danwei_bumen data = danwei_bumenDao.getByKey(bumen.getId(), Danwei_bumen.class);
			bumen.setZt(data.getZt());
			return danwei_bumenDao.update(bumen);
		}else {
			return danwei_bumenDao.insert(bumen);
		}
	}
	@Override
	public Danwei_bumen danweibyid(Long id) {
		Danwei_bumen data = danwei_bumenDao.getByKey(id, Danwei_bumen.class);
		return data;
	}
	@Override
	public int delete(Long id) {
		Danwei_bumen bumen = danwei_bumenDao.getByKey(id, Danwei_bumen.class);
		bumen.setZt("0");
		return danwei_bumenDao.update(bumen);
	}
	@Override
	public List<Danwei_bumen> findBumenMc() {
		// TODO Auto-generated method stub
		return danwei_bumenDao.findBumenMc();
	}

}
