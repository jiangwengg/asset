package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_zuobiaoDao;
import com.suyun.entity.Zichan_zuobiao;
import com.suyun.response.Zichan_zuobiaoResp;
import com.suyun.service.Zichan_zuobiaoService;

@Transactional
@Service("zichan_zuobiaoService")
public class Zichan_zuobiaoServiceimpl implements Zichan_zuobiaoService {

	@Autowired
	private Zichan_zuobiaoDao zichan_tuzhiDao;

	@Override
	public PageBean findZcZuoBiaoList(String keywords, Long zichan,
			PageParam pageParam) {
		return zichan_tuzhiDao.findZcZuoBiaoList(keywords, zichan, pageParam);
	}

	@Override
	public int updateZcZuoBiao(Zichan_zuobiao zuoBiao) {
		Zichan_zuobiao zb = zichan_tuzhiDao
				.getZcZbByZichan(zuoBiao.getZichan());
		if (zb != null) {
			zb.setBianhao(zuoBiao.getBianhao());
			zb.setZichan(zuoBiao.getZichan());
			zb.setZuobiao_x(zuoBiao.getZuobiao_x());
			zb.setZuobiao_y(zuoBiao.getZuobiao_y());
			zichan_tuzhiDao.update(zb);
		} else {
			zichan_tuzhiDao.insert(zuoBiao);
		}
		return 1;
	}

	@Override
	public Zichan_zuobiaoResp getZcZbById(Long id) {
		return zichan_tuzhiDao.getZcZbById(id);
	}

	@Override
	public Zichan_zuobiao getZcZbByZichan(Long zcId) {
		return zichan_tuzhiDao.getZcZbByZichan(zcId);
	}

	@Override
	public List<Zichan_zuobiaoResp> getZcZuoBiaoList() {
		return zichan_tuzhiDao.getZcZuoBiaoList();
	}

}
