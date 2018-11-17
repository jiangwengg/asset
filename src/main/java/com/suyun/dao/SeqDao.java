package com.suyun.dao;

import com.suyun.base.dao.BaseDao;
import com.suyun.entity.Seq;

public interface SeqDao extends BaseDao<Seq> {

	Seq getSeqByName(String name);

}