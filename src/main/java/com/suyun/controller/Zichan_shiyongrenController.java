package com.suyun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suyun.common.MediaType;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_shiyongren;
import com.suyun.response.AppResponse;
import com.suyun.service.ZichanSYRService;

@Controller
@RequestMapping("/shiyongren")
public class Zichan_shiyongrenController {
	@Autowired
	private ZichanSYRService zichanSYRService;

	/**
	 * 分页查询使用人
	 * 
	 * @param mc
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public AppResponse findsyrpage(@RequestParam(required = false) String mc,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = zichanSYRService.findsyrpage(mc, pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 使用人列表
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findAll(HttpServletRequest req) {
		List<Zichan_shiyongren> data = zichanSYRService.findAll();
		return AppResponse.okList(data);
	}

	/**
	 * 使用人修改
	 * 
	 * @param zichan_quanli_xz
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse syrUpdate(@ModelAttribute Zichan_shiyongren shiyongren,
			HttpServletRequest req) {
		int result = zichanSYRService.update(shiyongren);
		return AppResponse.okData(result);

	}

	/**
	 * 根据Id查找数据
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "byid", method = RequestMethod.POST)
	public AppResponse syrbyid(@Param("id") Long id, HttpServletRequest req) {
		Zichan_shiyongren data = zichanSYRService.syrbyid(id);
		return AppResponse.okData(data);

	}

	/**
	 * 删除使用人
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public AppResponse syrdelete(@Param("id") Long id, HttpServletRequest req) {
		int result = zichanSYRService.syrdelete(id);
		return AppResponse.okData(result);
	}
}
