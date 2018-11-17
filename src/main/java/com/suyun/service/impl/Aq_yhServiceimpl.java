package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.tool.MD5;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Aq_yhDao;
import com.suyun.entity.Aq_yh;
import com.suyun.service.Aq_yhService;

@Transactional
@Service("aq_yhService")
public class Aq_yhServiceimpl implements Aq_yhService {

	@Autowired
	private Aq_yhDao aq_yhDao;

	@Override
	public List<Aq_yh> findYhList() {
		return aq_yhDao.getEntityList(Aq_yh.class);
	}

	@Override
	public PageBean findPageList(String keywords, PageParam pageParam) {
		return aq_yhDao.findPageList(keywords, pageParam);
	}

	@Override
	public Aq_yh findYhById(Long id) {
		return aq_yhDao.getByKey(id, Aq_yh.class);
	}

	@Override
	public int update(Aq_yh yh) {
		if (yh.getId() != null) {
			Aq_yh exist= aq_yhDao.getByKey(yh.getId(), Aq_yh.class);
			if(!yh.getMm().equalsIgnoreCase(exist.getMm())){
				yh.setMm(MD5.getMD5Str(yh.getMm()));
			}
			yh.setZt(exist.getZt());
			return aq_yhDao.update(yh);
		} else {
			yh.setMm(MD5.getMD5Str(yh.getMm()));
			return aq_yhDao.insert(yh);
		}
	}

	@Override
	public int changeZt(Long id, Long zt) {
		Aq_yh yh = aq_yhDao.getByKey(id, Aq_yh.class);
		yh.setZt(zt);
		return aq_yhDao.update(yh);
	}

	@Override
	public Aq_yh findYhByYhm(String yhm) {
		return aq_yhDao.findYhByYhm(yhm);
	}

}
