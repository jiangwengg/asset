package com.suyun.entity;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_shiyongren")
public class Zichan_shiyongren extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String mc;
	private String zt;

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}
}