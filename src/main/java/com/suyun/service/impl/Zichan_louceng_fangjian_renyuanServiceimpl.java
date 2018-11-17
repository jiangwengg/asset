package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_louceng_fangjian_renyuanDao;
import com.suyun.entity.Zichan_louceng_fangjian_renyuan;
import com.suyun.response.Zichan_louceng_fangjian_renyuanResp;
import com.suyun.service.Zichan_louceng_fangjian_renyuanService;

@Transactional
@Service("zichan_louceng_fangjian_renyuanService")
public class Zichan_louceng_fangjian_renyuanServiceimpl implements
		Zichan_louceng_fangjian_renyuanService {

	@Autowired
	private Zichan_louceng_fangjian_renyuanDao zichan_louceng_fangjian_renyuanDao;

	@Override
	public List<Zichan_louceng_fangjian_renyuanResp> findZlfryList(
			Long zichanId, Long loucengId, Long fangjianId) {
		return zichan_louceng_fangjian_renyuanDao.findZlfryList(zichanId,
				loucengId, fangjianId);
	}

	@Override
	public PageBean findRenYuanPage(String keywords, PageParam pageParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Zichan_louceng_fangjian_renyuan renyuan) {
		if (renyuan.getId() != null) {
			return zichan_louceng_fangjian_renyuanDao.update(renyuan);
		} else {
			return zichan_louceng_fangjian_renyuanDao.insert(renyuan);
		}
	}

	@Override
	public Zichan_louceng_fangjian_renyuan getRenYuanById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changeRenYuan(Long id, Long ztf) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Zichan_louceng_fangjian_renyuan getRenYuanByFilter(Long zichanId,
			Long loucengId, Long fangjianId, Long renyuanId) {
		return zichan_louceng_fangjian_renyuanDao.getRenYuanByFilter(zichanId,
				loucengId, fangjianId, renyuanId);
	}

	@Override
	public int deleteRenYuanByFilter(Long zichanId, Long loucengId,
			Long fangjianId) {
		return zichan_louceng_fangjian_renyuanDao.deleteRenYuanByFilter(
				zichanId, loucengId, fangjianId);
	}

}
