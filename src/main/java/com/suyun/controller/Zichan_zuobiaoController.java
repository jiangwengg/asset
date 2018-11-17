package com.suyun.controller;

import java.util.List;

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
import com.suyun.entity.Zichan_zuobiao;
import com.suyun.response.AppResponse;
import com.suyun.response.Zichan_zuobiaoResp;
import com.suyun.service.Zichan_zuobiaoService;

@Controller
@RequestMapping("/zczb")
public class Zichan_zuobiaoController {
	@Autowired
	private Zichan_zuobiaoService zichan_zuobiaoService;

	/**
	 * 查询资产图纸列表
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
		PageBean pb = zichan_zuobiaoService.findZcZuoBiaoList(keywords, zichan,
				pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 获取坐标列表
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse getZcZuoBiaoList(HttpServletRequest req) {
		List<Zichan_zuobiaoResp> result = zichan_zuobiaoService.getZcZuoBiaoList();
		return AppResponse.okList(result);
	}

	/**
	 * 添加修改
	 * 
	 * @param zuoBiao
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse update(@ModelAttribute Zichan_zuobiao zuoBiao,
			HttpServletRequest req) {
		int result = zichan_zuobiaoService.updateZcZuoBiao(zuoBiao);
		return AppResponse.okData(result);
	}

	/**
	 * 通过Id查询图纸
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse getZcTzById(@RequestParam(required = false) Long id,
			HttpServletRequest req) {
		Zichan_zuobiaoResp result = zichan_zuobiaoService.getZcZbById(id);
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
	public AppResponse getZcTzByZichan(
			@RequestParam(required = false) Long zcId, HttpServletRequest req) {
		Zichan_zuobiao result = zichan_zuobiaoService.getZcZbByZichan(zcId);
		return AppResponse.okData(result);
	}

}