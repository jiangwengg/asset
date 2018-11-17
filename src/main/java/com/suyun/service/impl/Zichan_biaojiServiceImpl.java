package com.suyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_biaojiDao;
import com.suyun.dao.Zichan_biaoji_fanweiDao;
import com.suyun.entity.Zichan_biaoji;
import com.suyun.entity.Zichan_biaoji_fanwei;
import com.suyun.entity.Zichan_louceng_fangjian;
import com.suyun.response.Zichan_biaojiListResp;
import com.suyun.response.Zichan_biaojiResp;
import com.suyun.service.SeqService;
import com.suyun.service.Zichan_biaojiService;
import com.suyun.service.Zichan_louceng_fangjianService;

@Service
public class Zichan_biaojiServiceImpl implements Zichan_biaojiService {

	@Autowired
	private Zichan_biaojiDao zichan_biaojiDao;
	@Autowired
	private Zichan_biaoji_fanweiDao zichan_biaoji_fanweiDao;
	@Autowired
	private SeqService seqService;
	@Autowired
	private Zichan_louceng_fangjianService zichan_louceng_fangjianService;

	@Override
	public PageBean findPageList(Long zichan, String lx, String keywords,
			PageParam pageParam) {
		PageBean pb = zichan_biaojiDao.findPageList(zichan, lx, keywords,
				pageParam);

		List<Zichan_biaojiListResp> bjList = pb.getRecordList();
		for (Zichan_biaojiListResp bj : bjList) {
			if (bj.getFwlx() == 1) {// 类型:1:联楼宇，2:关联楼层，3:房间
				List<Zichan_louceng_fangjian> fjList = zichan_louceng_fangjianService
						.findZlfjList(bj.getZichan(), null);
				if (fjList != null) {
					bj.setFjs(Long.valueOf(fjList.size()));
				}
			} else if (bj.getFwlx() == 2) {
				List<Zichan_louceng_fangjian> fjList = zichan_louceng_fangjianService
						.findZlfjList(bj.getZichan(), bj.getLou_ceng());
				if (fjList != null) {
					bj.setFjs(Long.valueOf(fjList.size()));
				}
			} else {
				bj.setFjs(1L);
			}

		}

		return pb;
	}

	@Override
	public Zichan_biaojiResp getBiaoJiByid(Long id) {
		return zichan_biaojiDao.getBiaoJiByid(id);
	}

	@Override
	public int updateZcbj(Zichan_biaojiResp zcbj) {
		if (zcbj.getId() != null) {
			Zichan_biaoji bj = zichan_biaojiDao.getByKey(zcbj.getId(),
					Zichan_biaoji.class);
			bj.setBianhao(zcbj.getBianhao());
			bj.setMc(zcbj.getMc());
			bj.setZichan(zcbj.getZichan());
			zichan_biaojiDao.update(bj); // 更新表计
			Zichan_biaoji_fanwei fw = zichan_biaoji_fanweiDao
					.getZcbjfwByBiaoji(zcbj.getId());
			fw.setFang_jian(zcbj.getFang_jian());
			fw.setLou_ceng(zcbj.getLou_ceng());
			fw.setLx(zcbj.getGllx());
			fw.setZichan(zcbj.getZichan());
			zichan_biaoji_fanweiDao.update(fw);
		} else {
			Long id = seqService.getSeqByName("zichan_biaoji");
			Zichan_biaoji bj = new Zichan_biaoji();
			bj.setId(id);
			bj.setBianhao(zcbj.getBianhao());
			bj.setMc(zcbj.getMc());
			bj.setZichan(zcbj.getZichan());
			bj.setLx(zcbj.getLx());
			zichan_biaojiDao.insert(bj);
			Zichan_biaoji_fanwei fw = new Zichan_biaoji_fanwei();
			fw.setFang_jian(zcbj.getFang_jian());
			fw.setLou_ceng(zcbj.getLou_ceng());
			fw.setLx(zcbj.getGllx());
			fw.setZichan(zcbj.getZichan());
			fw.setBiaoji(id);
			zichan_biaoji_fanweiDao.insert(fw);
		}
		return 0;
	}

	@Override
	public List<Zichan_biaoji> findBiaoJiList(String lx) {
		return zichan_biaojiDao.findBiaoJiList(lx);
	}
}
