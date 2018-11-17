package com.suyun.response;

import com.suyun.base.model.BaseModel;

public class Zichan_biaojiResp extends BaseModel {
	private Long id;
	private String mc;
	private String bianhao;
	private String lx; // 类型：1:电表，2:水表

	private Long zichan;

	private Long fang_jian;
	private Long lou_ceng;
	private Long fanweiId;
	private String gllx; // 类型:1:联楼宇，2:关联楼层，3:房间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
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

	public Long getFanweiId() {
		return fanweiId;
	}

	public void setFanweiId(Long fanweiId) {
		this.fanweiId = fanweiId;
	}

	public String getGllx() {
		return gllx;
	}

	public void setGllx(String gllx) {
		this.gllx = gllx;
	}

}