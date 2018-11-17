package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.ZiChanSYRDao;
import com.suyun.entity.Zichan_shiyongren;
import com.suyun.service.ZichanSYRService;

@Service
public class ZichanSYRServiceImpl implements ZichanSYRService {

	@Autowired
	private ZiChanSYRDao ziChanSYRDao;
	
	@Override
	public List<Zichan_shiyongren> findAll() {
		return ziChanSYRDao.getEntityList(Zichan_shiyongren.class);
	}

	@Override
	public PageBean findsyrpage(String mc, PageParam pageParam) {
		return ziChanSYRDao.findsyrpage(mc,pageParam);
	}

	@Override
	public int update(Zichan_shiyongren shiyongren) {
		if (shiyongren.getId()!=null) {
			Zichan_shiyongren data = ziChanSYRDao.getByKey(shiyongren.getId(), Zichan_shiyongren.class);
			shiyongren.setZt(data.getZt());
			return ziChanSYRDao.update(shiyongren);
		}else {
			return ziChanSYRDao.insert(shiyongren);
		}
	}

	@Override
	public Zichan_shiyongren syrbyid(Long id) {
		Zichan_shiyongren data = ziChanSYRDao.getByKey(id, Zichan_shiyongren.class);
		return data;
		}

	@Override
	public int syrdelete(Long id) {
		Zichan_shiyongren shiyongren = ziChanSYRDao.getByKey(id, Zichan_shiyongren.class);
		shiyongren.setZt("0");
		return ziChanSYRDao.update(shiyongren);
	}

}
