package com.suyun.entity;

import java.math.BigDecimal;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_biaoji_feiyong")
public class Zichan_biaoji_feiyong extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private BigDecimal feiyong;
	private BigDecimal shiyongliang;
	private BigDecimal feiyong_renjun;
	// @JsonFormat(pattern = "yyyy-MM-dd")
	private String rq_kaishi;
	// @JsonFormat(pattern = "yyyy-MM-dd")
	private String rq_jieshu;
	private Long biaoji;

	public BigDecimal getFeiyong() {
		return feiyong;
	}

	public void setFeiyong(BigDecimal feiyong) {
		this.feiyong = feiyong;
	}

	public BigDecimal getShiyongliang() {
		return shiyongliang;
	}

	public void setShiyongliang(BigDecimal shiyongliang) {
		this.shiyongliang = shiyongliang;
	}

	public BigDecimal getFeiyong_renjun() {
		return feiyong_renjun;
	}

	public void setFeiyong_renjun(BigDecimal feiyong_renjun) {
		this.feiyong_renjun = feiyong_renjun;
	}

	public String getRq_kaishi() {
		return rq_kaishi;
	}

	public void setRq_kaishi(String rq_kaishi) {
		this.rq_kaishi = rq_kaishi;
	}

	public String getRq_jieshu() {
		return rq_jieshu;
	}

	public void setRq_jieshu(String rq_jieshu) {
		this.rq_jieshu = rq_jieshu;
	}

	public Long getBiaoji() {
		return biaoji;
	}

	public void setBiaoji(Long biaoji) {
		this.biaoji = biaoji;
	}
}