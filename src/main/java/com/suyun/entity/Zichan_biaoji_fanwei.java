package com.suyun.entity;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_biaoji_fanwei")
public class Zichan_biaoji_fanwei extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long fang_jian;
	private Long lou_ceng;
	private Long biaoji;
	private String lx;
	private Long zichan;

	public Long getFang_jian() {
		return fang_jian;
	}

	public void setFang_jian(Long fang_jian) {
		this.fang_jian = fang_jian;
	}

	public Long getLou_ceng() {
		return lou_ceng;
	}

	public void setLou_ceng(Long lou_ceng) {
		this.lou_ceng = lou_ceng;
	}

	public Long getBiaoji() {
		return biaoji;
	}

	public void setBiaoji(Long biaoji) {
		this.biaoji = biaoji;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
	}
}