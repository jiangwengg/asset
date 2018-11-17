package com.suyun.entity;

import java.math.BigDecimal;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_louceng")
public class Zichan_louceng extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal mianji;
	private String mc;
	private Long bh;
	private Long zichan;
	private String zt;

	public BigDecimal getMianji() {
		return mianji;
	}

	public void setMianji(BigDecimal mianji) {
		this.mianji = mianji;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public Long getBh() {
		return bh;
	}

	public void setBh(Long bh) {
		this.bh = bh;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

}