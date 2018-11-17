package com.suyun.vo;

import java.math.BigDecimal;

public class LouCengVO {
	private Long id;
	private long zichan;
	private long bh;
	private String mc;
	private BigDecimal mianji;
	private String zcmc;
	
	public long getZichan() {
		return zichan;
	}
	public long getBh() {
		return bh;
	}
	public String getMc() {
		return mc;
	}
	public void setZichan(long zichan) {
		this.zichan = zichan;
	}
	public void setBh(long bh) {
		this.bh = bh;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Long getId() {
		return id;
	}
	public BigDecimal getMianji() {
		return mianji;
	}
	public String getZcmc() {
		return zcmc;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMianji(BigDecimal mianji) {
		this.mianji = mianji;
	}
	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}
	
	
}
