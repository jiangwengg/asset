package com.suyun.dao;

import java.util.List;

import com.suyun.base.dao.BaseDao;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_zuobiao;
import com.suyun.response.Zichan_zuobiaoResp;

public interface Zichan_zuobiaoDao extends BaseDao<Zichan_zuobiao> {

	PageBean findZcZuoBiaoList(String keywords, Long zichan, PageParam pageParam);

	Zichan_zuobiao getZcZbByZichan(Long zcId);

	Zichan_zuobiaoResp getZcZbById(Long id);

	List<Zichan_zuobiaoResp> getZcZuoBiaoList();
}