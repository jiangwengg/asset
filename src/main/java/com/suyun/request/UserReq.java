package com.suyun.request;

import org.springframework.beans.BeanUtils;

import com.suyun.base.model.BaseModel;
import com.suyun.entity.User;

public class UserReq extends BaseModel {

	private String name;

	private String avatar;

	private String phone;

	private String email;

	private String password;

	private Integer status;

	private String smscode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSmscode() {
		return smscode;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}

	public void copyInto(User user) {
		BeanUtils.copyProperties(this, user);
	}
}