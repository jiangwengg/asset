package com.suyun.entity;

import java.math.BigDecimal;

import com.suyun.base.annotation.PrimaryKey;
import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_louceng_fangjian")
public class Zichan_louceng_fangjian extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private BigDecimal mianji;
	private String mc;
	private Long lou_ceng;
	private Long xingzhi;
	private Long zichan;
	private String zt;

	
	@PrimaryKey //懒更新中的主键
//	@AutoIncrement //自增字段不参与插入
//	@NotBatchInsert // 不参与批量插入
	public Long getId() {
		return super.getId();
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

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

}