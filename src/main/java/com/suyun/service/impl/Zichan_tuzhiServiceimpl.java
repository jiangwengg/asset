package com.suyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_tuzhiDao;
import com.suyun.entity.Zichan_tuzhi;
import com.suyun.service.Zichan_tuzhiService;

@Transactional
@Service("zichan_tuzhiService")
public class Zichan_tuzhiServiceimpl implements Zichan_tuzhiService {

	@Autowired
	private Zichan_tuzhiDao zichan_tuzhiDao;

	@Override
	public PageBean findZcTzList(String keywords, Long zichan,
			PageParam pageParam) {
		PageBean pb = zichan_tuzhiDao.findZcTzList(keywords, zichan, pageParam);
		return pb;
	}

	@Override
	public int updateZcTz(Zichan_tuzhi zctp) {
		if (zctp.getId() != null) {
			zctp.setZt("1");
			return zichan_tuzhiDao.update(zctp);
		} else {
			return zichan_tuzhiDao.insert(zctp);
		}
	}

	@Override
	public Zichan_tuzhi getZcTzById(Long id) {
		return zichan_tuzhiDao.getByKey(id, Zichan_tuzhi.class);
	}

	@Override
	public Zichan_tuzhi getZcTzByZichan(Long zcid) {
		return zichan_tuzhiDao.getZcTzByZichan(zcid);
	}

	@Override
	public int updateZt(Long id, String zt) {
		Zichan_tuzhi tz = zichan_tuzhiDao.getByKey(id, Zichan_tuzhi.class);
		tz.setZt(zt);
		return zichan_tuzhiDao.update(tz);
	}

}
