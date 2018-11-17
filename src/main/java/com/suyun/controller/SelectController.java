package com.suyun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suyun.entity.Zichan_gongyou;
import com.suyun.entity.Zichan_quanli_xz;
import com.suyun.entity.Zichan_shiyongren;
import com.suyun.response.AppResponse;
import com.suyun.service.ZiChanGYService;
import com.suyun.service.ZiChanService;
import com.suyun.service.ZichanSYRService;

@Controller
@RequestMapping("select")
public class SelectController {

	@Autowired
	private ZiChanGYService ziChanGYService;
	@Autowired
	private ZichanSYRService zichanSYRService;
	@Autowired
	private ZiChanService ziChanService;

	/**
	 * 查询所有共有情况
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "gongyonglist", method = RequestMethod.POST)
	public AppResponse gongyonglist(HttpServletRequest request) {
		List<Zichan_gongyou> list = ziChanGYService.findAll();
		return AppResponse.okList(list);
	}

	/**
	 * 查询所有使用人
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "shiyongrenlist", method = RequestMethod.POST)
	public AppResponse shiyongrenList(HttpServletRequest request) {
		List<Zichan_shiyongren> list = zichanSYRService.findAll();
		return AppResponse.okList(list);
	}

	/**
	 * 查询所有资产id和名字
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "zichanlist", method = RequestMethod.POST)
	public AppResponse zichanlist(HttpServletRequest req) {
		List<Zichan_quanli_xz> list = ziChanService.findIdMc();
		return AppResponse.okList(list);
	}

}
