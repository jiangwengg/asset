package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_louceng_fangjian_xingzhiDao;
import com.suyun.entity.Zichan_louceng_fangjian_xingzhi;
import com.suyun.service.Zichan_louceng_fangjian_xingzhiService;

@Transactional
@Service("zichan_louceng_fangjian_xingzhiServiceService")
public class Zichan_louceng_fangjian_xingzhiServiceimpl implements
		Zichan_louceng_fangjian_xingzhiService {

	@Autowired
	private Zichan_louceng_fangjian_xingzhiDao zichan_louceng_fangjian_xingzhiDao;

	@Override
	public List<Zichan_louceng_fangjian_xingzhi> findZlfxzList() {
		return zichan_louceng_fangjian_xingzhiDao
				.getEntityList(Zichan_louceng_fangjian_xingzhi.class);
	}

	@Override
	public PageBean findxingzhiPage(String mc, PageParam pageParam) {
		return zichan_louceng_fangjian_xingzhiDao.findxingzhiPage(mc,pageParam);
	}

	@Override
	public int update(Zichan_louceng_fangjian_xingzhi xingzhi) {
		if (xingzhi.getId()!=null) {
			Zichan_louceng_fangjian_xingzhi data = zichan_louceng_fangjian_xingzhiDao.getByKey(xingzhi.getId(), Zichan_louceng_fangjian_xingzhi.class);
			xingzhi.setZt(data.getZt());
			return zichan_louceng_fangjian_xingzhiDao.update(xingzhi);
		}else {
			return zichan_louceng_fangjian_xingzhiDao.insert(xingzhi);
		}
	}

	@Override
	public Zichan_louceng_fangjian_xingzhi xingzhibyid(Long id) {
		Zichan_louceng_fangjian_xingzhi data = zichan_louceng_fangjian_xingzhiDao.getByKey(id, Zichan_louceng_fangjian_xingzhi.class);
		return data;
	}

	@Override
	public int xingzhidelete(Long id) {
		Zichan_louceng_fangjian_xingzhi xingzhi = zichan_louceng_fangjian_xingzhiDao.getByKey(id, Zichan_louceng_fangjian_xingzhi.class);
		xingzhi.setZt("0");
		return zichan_louceng_fangjian_xingzhiDao.update(xingzhi);
	}

}
