package com.suyun.entity;

import java.math.BigDecimal;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_zuobiao")
public class Zichan_zuobiao extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private BigDecimal zuobiao_y;
	private BigDecimal zuobiao_x;
	private BigDecimal bianchang;
	private String bianhao;
	private Long zichan;

	public BigDecimal getZuobiao_y() {
		return zuobiao_y;
	}

	public void setZuobiao_y(BigDecimal zuobiao_y) {
		this.zuobiao_y = zuobiao_y;
	}

	public BigDecimal getZuobiao_x() {
		return zuobiao_x;
	}

	public void setZuobiao_x(BigDecimal zuobiao_x) {
		this.zuobiao_x = zuobiao_x;
	}

	public BigDecimal getBianchang() {
		return bianchang;
	}

	public void setBianchang(BigDecimal bianchang) {
		this.bianchang = bianchang;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public Long getZichan() {
		return zichan;
	}

	public void setZichan(Long zichan) {
		this.zichan = zichan;
	}
}