package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.QuanLi_lxDao;
import com.suyun.entity.Zichan_quanli_lx;
import com.suyun.service.QuanLi_lxService;

@Service
public class QuanLi_lxServiceImpl implements QuanLi_lxService{
	
	@Autowired
	private QuanLi_lxDao quanLi_lxDao;

	@Override
	public List<Zichan_quanli_lx> findAll() {
		return quanLi_lxDao.getEntityList(Zichan_quanli_lx.class);
	}

	@Override
	public PageBean findqllxPage(String mc, PageParam pageParam) {
		return quanLi_lxDao.findqllxPage(mc,pageParam);
	}

	@Override
	public int update(Zichan_quanli_lx quanli_lx) {
		if (quanli_lx.getId()!=null) {
			Zichan_quanli_lx data = quanLi_lxDao.getByKey(quanli_lx.getId(), Zichan_quanli_lx.class);
			quanli_lx.setZt(data.getZt());
			return quanLi_lxDao.update(quanli_lx);
		}else {
			return quanLi_lxDao.insert(quanli_lx);
		}
	}

	@Override
	public Zichan_quanli_lx qllxbyid(Long id) {
		Zichan_quanli_lx data = quanLi_lxDao.getByKey(id, Zichan_quanli_lx.class);
		return data;
	}

	@Override
	public int qllxdelete(Long id) {
		Zichan_quanli_lx quanli_lx = quanLi_lxDao.getByKey(id, Zichan_quanli_lx.class);
		quanli_lx.setZt("0");
		return quanLi_lxDao.update(quanli_lx);
	}
	

}
