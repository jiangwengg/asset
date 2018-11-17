package com.suyun.entity;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_sizhou_tupian")
public class Zichan_sizhou_tupian extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String dongdz;
	private String xibeidz;
	private String xinandz;
	private String dz;
	private String dongbeidz;
	private String beidz;
	private String dongnandz;
	private String xidz;
	private String fangwei;
	private String nandz;
	private Long zichan;

	public String getDongdz() {
		return dongdz;
	}

	public void setDongdz(String dongdz) {
		this.dongdz = dongdz;
	}

	public String getXibeidz() {
		return xibeidz;
	}

	public void setXibeidz(String xibeidz) {
		this.xibeidz = xibeidz;
	}

	public String getXinandz() {
		return xinandz;
	}

	public void setXinandz(String xinandz) {
		this.xinandz = xinandz;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public String getDongbeidz() {
		return dongbeidz;
	}

	public void setDongbeidz(String dongbeidz) {
		this.dongbeidz = dongbeidz;
	}

	public String getBeidz() {
		return beidz;
	}

	public void setBeidz(String beidz) {
		this.beidz = beidz;
	}

	public String getDongnandz() {
		return dongnandz;
	}

	public void setDongnandz(String dongnandz) {
		this.dongnandz = dongnandz;
	}

	public String getXidz() {
		return xidz;
	}

	public void setXidz(String xidz) {
		this.xidz = xidz;
	}

	public String getFangwei() {
		return fangwei;
	}

	public void setFangwei(String fangwei) {
		this.fangwei = fangwei;
	}

	public String getNandz() {
		return nandz;
	}

	public void setNandz(String nandz) {
		this.nandz = nandz;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
	}
}