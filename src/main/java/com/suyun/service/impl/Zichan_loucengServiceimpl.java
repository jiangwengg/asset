package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_loucengDao;
import com.suyun.entity.Zichan_louceng;
import com.suyun.service.Zichan_loucengService;

@Transactional
@Service("zichan_loucengService")
public class Zichan_loucengServiceimpl implements Zichan_loucengService {

	@Autowired
	private Zichan_loucengDao zichan_loucengDao;

	@Override
	public List<Zichan_louceng> findZclList(Long zichan) {
		return zichan_loucengDao.findZclList(zichan);

	}

	@Override
	public PageBean findPageList(Long zichanId, Long bh, String mc,
			PageParam pageParam) {
		return zichan_loucengDao.findPageList(zichanId, bh, mc, pageParam);
	}

	@Override
	public Zichan_louceng findById(Long id) {
		return zichan_loucengDao.getByKey(id, Zichan_louceng.class);
	}

	@Override
	public int update(Zichan_louceng zichan_louceng) {
		if (zichan_louceng.getId() != null) {
			Zichan_louceng lc = zichan_loucengDao.getByKey(
					zichan_louceng.getId(), Zichan_louceng.class);
			zichan_louceng.setZt("1");// 正常
			zichan_louceng.setMianji(lc.getMianji());// 面积不改变
			return zichan_loucengDao.update(zichan_louceng);
		}
		if (zichan_louceng.getId() == null) {
			return zichan_loucengDao.insert(zichan_louceng);
		}
		return 0;
	}

	@Override
	public int changeZt(Long id, String zt) {
		Zichan_louceng lc = zichan_loucengDao
				.getByKey(id, Zichan_louceng.class);
		lc.setZt("9");// 删除
		return zichan_loucengDao.update(lc);
	}

}
