package com.suyun.response;

import com.suyun.base.model.BaseModel;

public class Zichan_biaojiListResp extends BaseModel {
	private Long id;
	private String mc;
	private String bianhao;
	private String lx;
	private Long zichan;

	private Long fwlx;
	private Long fang_jian;
	private Long lou_ceng;
	private Long fwid;
	private String lcmc;
	private String fjmc;
	private String zcmc;
	private Long fjs;// 房间数

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

	public Long getFwlx() {
		return fwlx;
	}

	public void setFwlx(Long fwlx) {
		this.fwlx = fwlx;
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

	public Long getFwid() {
		return fwid;
	}

	public void setFwid(Long fwid) {
		this.fwid = fwid;
	}

	public String getLcmc() {
		return lcmc;
	}

	public void setLcmc(String lcmc) {
		this.lcmc = lcmc;
	}

	public String getFjmc() {
		return fjmc;
	}

	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}

	public String getZcmc() {
		return zcmc;
	}

	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}

	public Long getFjs() {
		return fjs;
	}

	public void setFjs(Long fjs) {
		this.fjs = fjs;
	}

}