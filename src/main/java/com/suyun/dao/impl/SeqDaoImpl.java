package com.suyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.suyun.base.dao.impl.BaseDaoImpl;
import com.suyun.dao.SeqDao;
import com.suyun.entity.Seq;

@Repository("seqDao")
public class SeqDaoImpl extends BaseDaoImpl<Seq> implements SeqDao {

	@Override
	public Seq getSeqByName(String name) {
		return super.getSqlSession().selectOne("getSeqByName", name);
	}

}
