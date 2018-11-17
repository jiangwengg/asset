package com.suyun.entity;
import com.suyun.base.annotation.Table;
import com.suyun.base.model.BaseEntity;
@Table("zichan_louceng_fangjian_buju")  
public class Zichan_louceng_fangjian_buju extends BaseEntity{
private static final long serialVersionUID = 1L;  
private Long fang_jian;
private String mc;
private String dz;
private Long lou_ceng;
private Long zichan;
public Long getFang_jian() {return fang_jian;}
public void setFang_jian(Long fang_jian) {this.fang_jian = fang_jian;}
public String getMc() {return mc;}
public void setMc(String mc) {this.mc = mc;}
public String getDz() {return dz;}
public void setDz(String dz) {this.dz = dz;}
public Long getLou_ceng() {return lou_ceng;}
public void setLou_ceng(Long lou_ceng) {this.lou_ceng = lou_ceng;}
public Long getZichan() {return zichan;}
public void setZichan(Long zichan) {this.zichan = zichan;}
}