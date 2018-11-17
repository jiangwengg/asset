package com.suyun.response;

import com.suyun.base.model.BaseModel;

public class Zichan_louceng_fangjian_bujuResp extends BaseModel {

	private Long id;
	private Long fang_jian;
	private String mc;
	private String dz;
	private Long lou_ceng;
	private Long zichan;
	private String loucengMc;
	private Long fangjianMc;
	private String zichanMc;

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

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public Long getLou_ceng() {
		return lou_ceng;
	}

	public void setLou_ceng(Long lou_ceng) {
		this.lou_ceng = lou_ceng;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
	}

	public String getLoucengMc() {
		return loucengMc;
	}

	public void setLoucengMc(String loucengMc) {
		this.loucengMc = loucengMc;
	}

	public Long getFangjianMc() {
		return fangjianMc;
	}

	public void setFangjianMc(Long fangjianMc) {
		this.fangjianMc = fangjianMc;
	}

	public String getZichanMc() {
		return zichanMc;
	}

	public void setZichanMc(String zichanMc) {
		this.zichanMc = zichanMc;
	}

}