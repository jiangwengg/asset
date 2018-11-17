package com.suyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_biaoji_feiyongDao;
import com.suyun.entity.Zichan_biaoji_feiyong;
import com.suyun.service.Zichan_biaoji_feiyongService;

@Service("zichan_biaoji_feiyongService")
public class Zichan_biaoji_feiyongServiceImpl implements
		Zichan_biaoji_feiyongService {

	@Autowired
	private Zichan_biaoji_feiyongDao zichan_biaoji_feiyongDao;

	@Override
	public PageBean findPageList(Long biaoji, String bjlx, String keywords,
			PageParam pageParam) {
		return zichan_biaoji_feiyongDao.findPageList(biaoji, bjlx, keywords,
				pageParam);
	}

	@Override
	public Zichan_biaoji_feiyong getBiaoJiFeiYongByid(Long id) {
		return zichan_biaoji_feiyongDao.getByKey(id,
				Zichan_biaoji_feiyong.class);
	}

	@Override
	public int updateZcbjfy(Zichan_biaoji_feiyong zcbjfy) {
		if (zcbjfy.getId() != null) {
			return zichan_biaoji_feiyongDao.update(zcbjfy);
		} else {
			return zichan_biaoji_feiyongDao.insert(zcbjfy);
		}
	}

}
