package com.suyun.service;

import com.suyun.entity.Seq;

public interface SeqService {

	/**
	 * 通过Id查询
	 * 
	 * @param id
	 * @return
	 */
	Long getSeqByName(String name);

	/**
	 * 新增或者修改
	 * 
	 * @param basetype
	 * @return
	 */
	int updateSeq(Seq seq);

}
