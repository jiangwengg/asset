package com.suyun.entity;

import com.suyun.base.annotation.PrimaryKey;
import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan_biaoji")
public class Zichan_biaoji extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String mc;
	private String bianhao;
	private String lx;
	private Long zichan;

	@PrimaryKey
	// 懒更新中的主键
	// @AutoIncrement //自增字段不参与插入
	// @NotBatchInsert // 不参与批量插入
	public Long getId() {
		return super.getId();
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
}