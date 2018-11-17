package com.suyun.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.suyun.entity.Zichan_sizhou_tupian;
import com.suyun.response.AppResponse;
import com.suyun.service.Zichan_sizhou_tupianService;

@Controller
@RequestMapping("/zctp")
public class Zichan_sizhou_tupianController {
	@Autowired
	private Zichan_sizhou_tupianService Zichan_sizhou_tupianService;

	/**
	 * 查询资产图片列表
	 * 
	 * @param zichan
	 * @param keywords
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.POST)
	public AppResponse findPageList(
			@RequestParam(required = false) Long zichan,
			@RequestParam(required = false) String keywords,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = Zichan_sizhou_tupianService.findZcTpList(keywords,
				zichan, pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 添加修改
	 * 
	 * @param Zichan_sizhou_tupianResp
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse update(
			@ModelAttribute Zichan_sizhou_tupian zichan_sizhou_tupian,
			HttpServletRequest req) {
		int result = Zichan_sizhou_tupianService
				.updateZcTp(zichan_sizhou_tupian);
		return AppResponse.okData(result);
	}

	/**
	 * 通过Id查询图片
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse getZcTpById(@RequestParam(required = false) Long id,
			HttpServletRequest req) {
		Zichan_sizhou_tupian result = Zichan_sizhou_tupianService
				.getZcTpById(id);
		return AppResponse.okData(result);
	}

	/**
	 * 
	 * @param zcid
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byzichan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse getZcTpByZichan(
			@RequestParam(required = false) Long zcid, HttpServletRequest req) {
		Zichan_sizhou_tupian result = Zichan_sizhou_tupianService
				.getZcTpByZichan(zcid);
		return AppResponse.okData(result);
	}
}