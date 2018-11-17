package com.suyun.entity;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_louceng_fangjian_renyuan")
public class Zichan_louceng_fangjian_renyuan extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long fang_jian;
	private Long lou_ceng;
	private Long renyuan;
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

	public Long getRenyuan() {
		return renyuan;
	}

	public void setRenyuan(Long renyuan) {
		this.renyuan = renyuan;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
	}
}