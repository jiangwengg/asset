package com.suyun.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NengHaoDengJiVO {
	private Long id;
	private Long biaoji;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date rq_jieshu;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date rq_kaishi;
	private BigDecimal feiyong;
	private BigDecimal feiyong_renjun;
	private BigDecimal shiyongliang;
	private Long biid;
	private String bjmc;
	private String bibh;
	private String bjlx;
	private String fwlx;
	private Long zcid;
	private String zcmc;
	private Long lcid;
	private String lcmc;
	private Long lcfjid;
	private String lcfjmc;
	public Long getId() {
		return id;
	}
	public Long getBiaoji() {
		return biaoji;
	}
	public Date getRq_jieshu() {
		return rq_jieshu;
	}
	public Date getRq_kaishi() {
		return rq_kaishi;
	}
	public BigDecimal getFeiyong() {
		return feiyong;
	}
	public BigDecimal getFeiyong_renjun() {
		return feiyong_renjun;
	}
	public BigDecimal getShiyongliang() {
		return shiyongliang;
	}
	public Long getBiid() {
		return biid;
	}
	public String getBjmc() {
		return bjmc;
	}
	public String getBibh() {
		return bibh;
	}
	public String getBjlx() {
		return bjlx;
	}
	public String getFwlx() {
		return fwlx;
	}
	public Long getZcid() {
		return zcid;
	}
	public String getZcmc() {
		return zcmc;
	}
	public Long getLcid() {
		return lcid;
	}
	public String getLcmc() {
		return lcmc;
	}
	public Long getLcfjid() {
		return lcfjid;
	}
	public String getLcfjmc() {
		return lcfjmc;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBiaoji(Long biaoji) {
		this.biaoji = biaoji;
	}
	public void setRq_jieshu(Date rq_jieshu) {
		this.rq_jieshu = rq_jieshu;
	}
	public void setRq_kaishi(Date rq_kaishi) {
		this.rq_kaishi = rq_kaishi;
	}
	public void setFeiyong(BigDecimal feiyong) {
		this.feiyong = feiyong;
	}
	public void setFeiyong_renjun(BigDecimal feiyong_renjun) {
		this.feiyong_renjun = feiyong_renjun;
	}
	public void setShiyongliang(BigDecimal shiyongliang) {
		this.shiyongliang = shiyongliang;
	}
	public void setBiid(Long biid) {
		this.biid = biid;
	}
	public void setBjmc(String bjmc) {
		this.bjmc = bjmc;
	}
	public void setBibh(String bibh) {
		this.bibh = bibh;
	}
	public void setBjlx(String bjlx) {
		this.bjlx = bjlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public void setZcid(Long zcid) {
		this.zcid = zcid;
	}
	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}
	public void setLcid(Long lcid) {
		this.lcid = lcid;
	}
	public void setLcmc(String lcmc) {
		this.lcmc = lcmc;
	}
	public void setLcfjid(Long lcfjid) {
		this.lcfjid = lcfjid;
	}
	public void setLcfjmc(String lcfjmc) {
		this.lcfjmc = lcfjmc;
	}
	
	
	
}
