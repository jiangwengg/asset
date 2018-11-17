package com.suyun.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.base.tool.StringUtil;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_loucengDao;
import com.suyun.dao.Zichan_louceng_fangjianDao;
import com.suyun.dao.Zichan_louceng_fangjian_renyuanDao;
import com.suyun.entity.Zichan_louceng;
import com.suyun.entity.Zichan_louceng_fangjian;
import com.suyun.entity.Zichan_louceng_fangjian_renyuan;
import com.suyun.response.Zichan_louceng_fangjianResp;
import com.suyun.response.Zichan_louceng_fangjian_renyuanResp;
import com.suyun.service.SeqService;
import com.suyun.service.Zichan_louceng_fangjianService;

@Transactional
@Service("zichan_louceng_fangjianService")
public class Zichan_louceng_fangjianServiceimpl implements
		Zichan_louceng_fangjianService {

	@Autowired
	private Zichan_louceng_fangjianDao zichan_louceng_fangjianDao;
	@Autowired
	private Zichan_loucengDao zichan_loucengDao;
	@Autowired
	private Zichan_louceng_fangjian_renyuanDao zichan_louceng_fangjian_renyuanDao;
	@Autowired
	private SeqService seqService;

	@Override
	public PageBean findZlfangList(String keywords, Long zichan, Long louceng,
			PageParam pageParam) {
		PageBean pb = zichan_louceng_fangjianDao.findZlfangList(keywords,
				zichan, louceng, pageParam);
		List<Zichan_louceng_fangjianResp> fjList = pb.getRecordList();
		for (Zichan_louceng_fangjianResp fj : fjList) {
			List<Zichan_louceng_fangjian_renyuanResp> renyuanList = zichan_louceng_fangjian_renyuanDao
					.findZlfryList(fj.getZichan(), fj.getLou_ceng(), fj.getId());
			String name = null;
			String ids = null;
			if (renyuanList != null) {
				for (Zichan_louceng_fangjian_renyuanResp renyuan : renyuanList) {
					if (StringUtil.isNotBlank(name)) {
						name = name + "," + renyuan.getRenyuanMc();
						ids = ids + "," + renyuan.getRenyuan();
					} else {
						name = renyuan.getRenyuanMc();
						ids = renyuan.getRenyuan().toString();
					}
				}
			}
			fj.setRenyuanMc(name);
			fj.setRenyuanIds(ids);
		}

		return pb;
	}

	@Override
	public Zichan_louceng_fangjianResp findZlfangById(Long id) {
		return zichan_louceng_fangjianDao.findZlfangById(id);
	}

	@Override
	public int updateZlfj(Zichan_louceng_fangjian zlfj, String renyuans) {
		Long fangjianId = null;
		if (zlfj.getId() != null) {
			fangjianId = zlfj.getId();
			zlfj.setZt("1");
			// 更新楼层总面积
			Zichan_louceng_fangjian zlf = zichan_louceng_fangjianDao.getByKey(
					zlfj.getId(), Zichan_louceng_fangjian.class);

			Zichan_louceng zl = zichan_loucengDao.getByKey(zlf.getLou_ceng(),
					Zichan_louceng.class);
			BigDecimal zongmianji = zl.getMianji();
			BigDecimal mianji = zlf.getMianji();
			if (mianji != zlfj.getMianji()) {// 面积有变化
				zongmianji = zongmianji.subtract(mianji); // 将以前的减掉
				zl.setMianji(zongmianji.add(zlfj.getMianji())); // 加上新数据
				zichan_loucengDao.update(zl);
			}
			zichan_louceng_fangjianDao.update(zlfj);
		} else {
			// 更新楼层总面积
			Zichan_louceng zl = zichan_loucengDao.getByKey(zlfj.getLou_ceng(),
					Zichan_louceng.class);
			BigDecimal zongmianji = zl.getMianji();
			BigDecimal mianji = zlfj.getMianji();
			zl.setMianji(zongmianji.add(mianji));
			zichan_loucengDao.update(zl);
			fangjianId = seqService.getSeqByName("zichan_louceng_fangjian");
			zlfj.setId(fangjianId);
			zichan_louceng_fangjianDao.insert(zlfj);
		}
		// 更新房间人员
		String renyuan[] = renyuans.split(",");
		// 先删除 再循环更新
		zichan_louceng_fangjian_renyuanDao.deleteRenYuanByFilter(
				zlfj.getZichan(), zlfj.getLou_ceng(), fangjianId);
		for (int i = 0; i < renyuan.length; i++) {
			if (StringUtil.isBlank(renyuan[i])) {
				continue;
			}
			Zichan_louceng_fangjian_renyuan ry = new Zichan_louceng_fangjian_renyuan();
			ry.setZichan(zlfj.getZichan());
			ry.setLou_ceng(zlfj.getLou_ceng());
			ry.setRenyuan(Long.valueOf(renyuan[i]));
			ry.setFang_jian(fangjianId);
			zichan_louceng_fangjian_renyuanDao.insert(ry);
		}
		return 0;
	}

	@Override
	public List<Zichan_louceng_fangjian> findZlfjList(Long zichanId, Long lcid) {
		return zichan_louceng_fangjianDao.findZlfjList(zichanId,lcid);
	}

	@Override
	public int changeZt(Long id, String zt) {
		Zichan_louceng_fangjian zlf = zichan_louceng_fangjianDao.getByKey(id,
				Zichan_louceng_fangjian.class);
		zlf.setZt(zt);
		zichan_louceng_fangjianDao.update(zlf);
		// 更新楼层总面积
		Zichan_louceng zl = zichan_loucengDao.getByKey(zlf.getLou_ceng(),
				Zichan_louceng.class);
		BigDecimal zongmianji = zl.getMianji();
		BigDecimal mianji = zlf.getMianji();
		zl.setMianji(zongmianji.subtract(mianji));
		zichan_loucengDao.update(zl);
		return 0;
	}

}
