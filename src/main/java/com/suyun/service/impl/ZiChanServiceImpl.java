package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.ZiChanDao;
import com.suyun.entity.Zichan;
import com.suyun.entity.Zichan_quanli_xz;
import com.suyun.service.ZiChanService;
import com.suyun.vo.ZiChanVO;

@Transactional
@Service
public class ZiChanServiceImpl implements ZiChanService {

	@Autowired
	private ZiChanDao ziChanDao;

	@Override
	public PageBean findPageList(String keywords, String mc,
			String zhengjian_zt, Long quanli_lx, Long quanli_xingzhi,
			PageParam pageParam) {
		return ziChanDao.findPageList(keywords, mc, zhengjian_zt, quanli_lx,
				quanli_xingzhi, pageParam);
	}

	@Override
	public List<Zichan> findZcList() {
		return ziChanDao.findZcList();
	}

	@Override
	public Zichan findById(Long id) {
		return ziChanDao.getByKey(id, Zichan.class);
	}

	@Override
	public int updateZichan(Zichan zichan) {
		if (zichan.getId() != null) {
			return ziChanDao.update(zichan);
		} else {
			return ziChanDao.insert(zichan);
		}
	}

	@Override
	public ZiChanVO details(Long id) {
		return ziChanDao.details(id);
	}

	@Override
	public List<Zichan_quanli_xz> findIdMc() {
		return ziChanDao.findIdMc();
	}

}
