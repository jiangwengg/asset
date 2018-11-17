package com.suyun.entity;

import java.math.BigDecimal;

import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;

@Table("zichan")
public class Zichan extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private BigDecimal mianji_shiyong;
	private String zhengjian_bianhao;
	private String dihao;
	private String qixian_jieshu;
	private String zhengjian_zt;
	private BigDecimal mianji_pingfangmi;
	private String danyuan_bh;
	private String quanli_qita;
	private Long gongyou;
	private Long quanli_xingzhi;
	private Long shiyongren;
	private BigDecimal mianji_fentan;
	private Long quanli_lx;
	private String qixian_kaishi;
	private Long zhengjain_bianhao_nianfen;
	private String yongtu;
	private String zhengjian_rq;
	private String tuhao;
	private String mc;
	private String zuoluo;
	private BigDecimal mianji_mu;

	public BigDecimal getMianji_shiyong() {
		return mianji_shiyong;
	}

	public void setMianji_shiyong(BigDecimal mianji_shiyong) {
		this.mianji_shiyong = mianji_shiyong;
	}

	public String getZhengjian_bianhao() {
		return zhengjian_bianhao;
	}

	public void setZhengjian_bianhao(String zhengjian_bianhao) {
		this.zhengjian_bianhao = zhengjian_bianhao;
	}

	public String getDihao() {
		return dihao;
	}

	public void setDihao(String dihao) {
		this.dihao = dihao;
	}

	public String getQixian_jieshu() {
		return qixian_jieshu;
	}

	public void setQixian_jieshu(String qixian_jieshu) {
		this.qixian_jieshu = qixian_jieshu;
	}

	public String getZhengjian_zt() {
		return zhengjian_zt;
	}

	public void setZhengjian_zt(String zhengjian_zt) {
		this.zhengjian_zt = zhengjian_zt;
	}

	public BigDecimal getMianji_pingfangmi() {
		return mianji_pingfangmi;
	}

	public void setMianji_pingfangmi(BigDecimal mianji_pingfangmi) {
		this.mianji_pingfangmi = mianji_pingfangmi;
	}

	public String getDanyuan_bh() {
		return danyuan_bh;
	}

	public void setDanyuan_bh(String danyuan_bh) {
		this.danyuan_bh = danyuan_bh;
	}

	public String getQuanli_qita() {
		return quanli_qita;
	}

	public void setQuanli_qita(String quanli_qita) {
		this.quanli_qita = quanli_qita;
	}

	public Long getGongyou() {
		return gongyou;
	}

	public void setGongyou(Long gongyou) {
		this.gongyou = gongyou;
	}

	public Long getQuanli_xingzhi() {
		return quanli_xingzhi;
	}

	public void setQuanli_xingzhi(Long quanli_xingzhi) {
		this.quanli_xingzhi = quanli_xingzhi;
	}

	public Long getShiyongren() {
		return shiyongren;
	}

	public void setShiyongren(Long shiyongren) {
		this.shiyongren = shiyongren;
	}

	public BigDecimal getMianji_fentan() {
		return mianji_fentan;
	}

	public void setMianji_fentan(BigDecimal mianji_fentan) {
		this.mianji_fentan = mianji_fentan;
	}

	public Long getQuanli_lx() {
		return quanli_lx;
	}

	public void setQuanli_lx(Long quanli_lx) {
		this.quanli_lx = quanli_lx;
	}

	public String getQixian_kaishi() {
		return qixian_kaishi;
	}

	public void setQixian_kaishi(String qixian_kaishi) {
		this.qixian_kaishi = qixian_kaishi;
	}

	public Long getZhengjain_bianhao_nianfen() {
		return zhengjain_bianhao_nianfen;
	}

	public void setZhengjain_bianhao_nianfen(Long zhengjain_bianhao_nianfen) {
		this.zhengjain_bianhao_nianfen = zhengjain_bianhao_nianfen;
	}

	public String getYongtu() {
		return yongtu;
	}

	public void setYongtu(String yongtu) {
		this.yongtu = yongtu;
	}

	public String getZhengjian_rq() {
		return zhengjian_rq;
	}

	public void setZhengjian_rq(String zhengjian_rq) {
		this.zhengjian_rq = zhengjian_rq;
	}

	public String getTuhao() {
		return tuhao;
	}

	public void setTuhao(String tuhao) {
		this.tuhao = tuhao;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getZuoluo() {
		return zuoluo;
	}

	public void setZuoluo(String zuoluo) {
		this.zuoluo = zuoluo;
	}

	public BigDecimal getMianji_mu() {
		return mianji_mu;
	}

	public void setMianji_mu(BigDecimal mianji_mu) {
		this.mianji_mu = mianji_mu;
	}

}