package com.suyun.entity;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("danwei_bumen")
public class Danwei_bumen extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String mc;
	private Long danwei;
	private String zt;

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public Long getDanwei() {
		return danwei;
	}

	public void setDanwei(Long danwei) {
		this.danwei = danwei;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}
}