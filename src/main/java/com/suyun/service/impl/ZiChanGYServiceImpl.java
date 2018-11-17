package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.ZiChanGYDao;
import com.suyun.entity.Zichan_gongyou;
import com.suyun.service.ZiChanGYService;

@Service
public class ZiChanGYServiceImpl implements ZiChanGYService{

	@Autowired
	private ZiChanGYDao ziChanGYDao;
	
	@Override
	public List<Zichan_gongyou> findAll() {
		
		return ziChanGYDao.getEntityList(Zichan_gongyou.class);
	}

	@Override
	public PageBean findgypage(String mc, PageParam pageParam) {
		return ziChanGYDao.findgypage(mc,pageParam);
	}

	@Override
	public int update(Zichan_gongyou gongyou) {
		if (gongyou.getId()!=null) {
			Zichan_gongyou data = ziChanGYDao.getByKey(gongyou.getId(), Zichan_gongyou.class);
			gongyou.setZt(data.getZt());
			return ziChanGYDao.update(gongyou);
		}else {
			return ziChanGYDao.insert(gongyou);
		}
	}

	@Override
	public Zichan_gongyou gybyid(Long id) {
		Zichan_gongyou data = ziChanGYDao.getByKey(id, Zichan_gongyou.class);
		return data;
	}

	@Override
	public int gydelete(Long id) {
		Zichan_gongyou gongyou = ziChanGYDao.getByKey(id, Zichan_gongyou.class);
		gongyou.setZt("0");
		return ziChanGYDao.update(gongyou);
	}

}
