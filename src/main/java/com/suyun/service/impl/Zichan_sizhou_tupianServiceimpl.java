package com.suyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.dao.Zichan_sizhou_tupianDao;
import com.suyun.entity.Zichan_sizhou_tupian;
import com.suyun.service.Zichan_sizhou_tupianService;

@Transactional
@Service("zichan_sizhou_tupianService")
public class Zichan_sizhou_tupianServiceimpl implements
		Zichan_sizhou_tupianService {

	@Autowired
	private Zichan_sizhou_tupianDao zichan_sizhou_tupianDao;

	@Override
	public PageBean findZcTpList(String keywords, Long zichan,
			PageParam pageParam) {
		PageBean pb = zichan_sizhou_tupianDao.findZcTpList(keywords, zichan,
				pageParam);
		/*
		 * List<Zichan_sizhou_tupianResp> tpList = pb.getRecordList(); for
		 * (Zichan_sizhou_tupianResp tp : tpList) { if (tp.getFangwei() != null
		 * && tp.getDz() != null) { String fws[] = tp.getFangwei().split(",");
		 * String dzs[] = tp.getDz().split(","); for (int i = 0; i < fws.length;
		 * i++) { if ("1".equals(fws[i])) { // 东 tp.setDongdz(dzs[i]); } else if
		 * ("2".equals(fws[i])) {// 南 tp.setNandz(dzs[i]); } else if
		 * ("3".equals(fws[i])) {// 西 tp.setXidz(dzs[i]); } else if
		 * ("4".equals(fws[i])) {// 北 tp.setBeidz(dzs[i]); } else if
		 * ("12".equals(fws[i])) {// 东南 tp.setDongnandz(dzs[i]); } else if
		 * ("14".equals(fws[i])) {// 东北 tp.setDongbeidz(dzs[i]); } else if
		 * ("32".equals(fws[i])) {// 西南 tp.setXinandz(dzs[i]); } else if
		 * ("34".equals(fws[i])) {// 西北 tp.setXibeidz(dzs[i]); } } } }
		 */
		return pb;
	}

	@Override
	public int updateZcTp(Zichan_sizhou_tupian zctp) {
		if (zctp.getId() != null) {
			return zichan_sizhou_tupianDao.update(zctp);

		} else {
			return zichan_sizhou_tupianDao.insert(zctp);
		}
	}

	@Override
	public Zichan_sizhou_tupian getZcTpById(Long id) {
		return zichan_sizhou_tupianDao.getByKey(id, Zichan_sizhou_tupian.class);
	}

	@Override
	public Zichan_sizhou_tupian getZcTpByZichan(Long zcid) {
		return zichan_sizhou_tupianDao.getZcTpByZichan(zcid);
	}

}
