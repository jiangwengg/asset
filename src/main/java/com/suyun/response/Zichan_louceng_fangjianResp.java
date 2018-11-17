package com.suyun.response;

import java.math.BigDecimal;

import com.suyun.base.model.BaseModel;

public class Zichan_louceng_fangjianResp extends BaseModel {

	private Long id;
	private BigDecimal mianji;
	private String mc;
	private Long lou_ceng;
	private Long xingzhi;
	private Long zichan;
	private String xingzhiMc;// 性质名称
	private String lou_cengMc;
	private Long lou_cengBh;
	private String zichanMc;
	private String renyuanMc;
	private String renyuanIds;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getLou_ceng() {
		return lou_ceng;
	}

	public void setLou_ceng(Long lou_ceng) {
		this.lou_ceng = lou_ceng;
	}

	public Long getXingzhi() {
		return xingzhi;
	}

	public void setXingzhi(Long xingzhi) {
		this.xingzhi = xingzhi;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
	}

	public String getXingzhiMc() {
		return xingzhiMc;
	}

	public void setXingzhiMc(String xingzhiMc) {
		this.xingzhiMc = xingzhiMc;
	}

	public String getLou_cengMc() {
		return lou_cengMc;
	}

	public void setLou_cengMc(String lou_cengMc) {
		this.lou_cengMc = lou_cengMc;
	}

	public Long getLou_cengBh() {
		return lou_cengBh;
	}

	public void setLou_cengBh(Long lou_cengBh) {
		this.lou_cengBh = lou_cengBh;
	}

	public String getZichanMc() {
		return zichanMc;
	}

	public void setZichanMc(String zichanMc) {
		this.zichanMc = zichanMc;
	}

	public String getRenyuanMc() {
		return renyuanMc;
	}

	public void setRenyuanMc(String renyuanMc) {
		this.renyuanMc = renyuanMc;
	}

	public String getRenyuanIds() {
		return renyuanIds;
	}

	public void setRenyuanIds(String renyuanIds) {
		this.renyuanIds = renyuanIds;
	}

}