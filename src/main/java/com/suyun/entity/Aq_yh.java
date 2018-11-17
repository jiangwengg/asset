package com.suyun.entity;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("aq_yh")
public class Aq_yh extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String mm;
	private Long zt;
	private String yhm;
	private String xm;
	private String yan;
	private String shouji;
	private String zuoji;
	private String email;

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public Long getZt() {
		return zt;
	}

	public void setZt(Long zt) {
		this.zt = zt;
	}

	public String getYhm() {
		return yhm;
	}

	public void setYhm(String yhm) {
		this.yhm = yhm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getYan() {
		return yan;
	}

	public void setYan(String yan) {
		this.yan = yan;
	}

	public String getShouji() {
		return shouji;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public String getZuoji() {
		return zuoji;
	}

	public void setZuoji(String zuoji) {
		this.zuoji = zuoji;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}