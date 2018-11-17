package com.suyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_louceng_fangjian_bujuDao;
import com.suyun.entity.Zichan_louceng_fangjian_buju;
import com.suyun.response.Zichan_louceng_fangjian_bujuResp;
import com.suyun.service.Zichan_louceng_fangjian_bujuService;

@Transactional
@Service("zichan_louceng_fangjian_bujuService")
public class Zichan_louceng_fangjian_bujuServiceimpl implements
		Zichan_louceng_fangjian_bujuService {

	@Autowired
	private Zichan_louceng_fangjian_bujuDao zichan_louceng_fangjian_bujuDao;

	@Override
	public PageBean findZlfbjList(String keywords, Long zichan, Long louceng,
			Long fangjian, PageParam pageParam) {
		return zichan_louceng_fangjian_bujuDao.findZlfbjList(keywords, zichan,
				louceng, fangjian, pageParam);
	}

	@Override
	public int updateZlfbj(Zichan_louceng_fangjian_buju zlfbj) {
		if (zlfbj.getId() != null) {
			return zichan_louceng_fangjian_bujuDao.update(zlfbj);
		} else {
			return zichan_louceng_fangjian_bujuDao.insert(zlfbj);
		}
	}

	@Override
	public Zichan_louceng_fangjian_bujuResp getZlfbjById(Long id) {
		return zichan_louceng_fangjian_bujuDao.getZlfbjById(id);
	}

}
