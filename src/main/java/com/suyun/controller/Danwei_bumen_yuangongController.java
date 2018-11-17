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
import com.suyun.entity.Danwei_bumen_yuangong;
import com.suyun.response.AppResponse;
import com.suyun.service.Danwei_bumen_yuangongService;

@Controller
@RequestMapping("/yuangong")
public class Danwei_bumen_yuangongController {

	@Autowired
	private Danwei_bumen_yuangongService yuangongService;

	/**
	 * 分页查询
	 * 
	 * @param mc
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public AppResponse finddanweiPage(
			@RequestParam(required = false) String mc,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = yuangongService.findYuangoongPage(mc, pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 修改数据
	 * 
	 * @param bumen
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse danweiUpdate(
			@ModelAttribute Danwei_bumen_yuangong yuangong,
			HttpServletRequest req) {
		int result = yuangongService.update(yuangong);
		return AppResponse.okData(result);

	}

	/**
	 * 根据Id查询数据
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "byid", method = RequestMethod.POST)
	public AppResponse byid(@Param("id") Long id, HttpServletRequest req) {
		Danwei_bumen_yuangong data = yuangongService.danweibyid(id);
		return AppResponse.okData(data);

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public AppResponse delete(@Param("id") Long id, HttpServletRequest req) {
		int result = yuangongService.delete(id);
		return AppResponse.okData(result);
	}

	/**
	 * 查询列表
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public AppResponse delete(HttpServletRequest req) {
		List<Danwei_bumen_yuangong> result = yuangongService.findYuangongList();
		return AppResponse.okList(result);
	}

}
