package com.suyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suyun.dao.SeqDao;
import com.suyun.entity.Seq;
import com.suyun.service.SeqService;

@Transactional
@Service("seqService")
public class SeqServiceimpl implements SeqService {

	@Autowired
	private SeqDao seqDao;

	@Override
	public Long getSeqByName(String name) {
		Seq seq = seqDao.getSeqByName(name);
		seq.setCurrentvalue(seq.getCurrentvalue() + seq.getIncrement());
		seqDao.update(seq);
		return seq.getCurrentvalue() + seq.getIncrement();
	}

	@Override
	public int updateSeq(Seq seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
