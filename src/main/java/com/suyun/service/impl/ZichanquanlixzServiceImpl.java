package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.ZichanquanlixzDao;
import com.suyun.entity.Zichan_quanli_xz;
import com.suyun.service.ZichanquanlixzService;

@Service
public class ZichanquanlixzServiceImpl implements ZichanquanlixzService{

	@Autowired
	private ZichanquanlixzDao zichan_quanli_xzDao;
	
	@Override
	public PageBean findqlxzPage(String mc,PageParam pageParam) {
		return zichan_quanli_xzDao.findqlxzPage(mc,pageParam);
	}

	@Override
	public int update(Zichan_quanli_xz zichan_quanli_xz) {
		if (zichan_quanli_xz.getId()!=null) {
			Zichan_quanli_xz data = zichan_quanli_xzDao.getByKey(zichan_quanli_xz.getId(), Zichan_quanli_xz.class);
			zichan_quanli_xz.setZt(data.getZt());
			return zichan_quanli_xzDao.update(zichan_quanli_xz);
		}else {
			return zichan_quanli_xzDao.insert(zichan_quanli_xz);
		}
	}

	@Override
	public int qlxzdelete(Long id) {
		Zichan_quanli_xz quanli_xz = zichan_quanli_xzDao.getByKey(id, Zichan_quanli_xz.class);
		quanli_xz.setZt("0");
		return zichan_quanli_xzDao.update(quanli_xz);
	}

	@Override
	public Zichan_quanli_xz qlxzbyid(Long id) {
		Zichan_quanli_xz data = zichan_quanli_xzDao.getByKey(id, Zichan_quanli_xz.class);
		return data;
	}

	@Override
	public List<Zichan_quanli_xz> findAll() {
		return zichan_quanli_xzDao.getEntityList(Zichan_quanli_xz.class);
	}
}
