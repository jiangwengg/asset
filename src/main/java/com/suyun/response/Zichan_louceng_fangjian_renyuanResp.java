package com.suyun.response;

import com.suyun.base.model.BaseModel;

public class Zichan_louceng_fangjian_renyuanResp extends BaseModel {
	private Long id;
	private Long fang_jian;
	private Long lou_ceng;
	private Long renyuan;
	private Long zichan;
	private String renyuanMc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getRenyuanMc() {
		return renyuanMc;
	}

	public void setRenyuanMc(String renyuanMc) {
		this.renyuanMc = renyuanMc;
	}

}