package com.suyun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian_buju;
import com.suyun.response.AppResponse;
import com.suyun.response.Zichan_louceng_fangjian_bujuResp;
import com.suyun.service.Zichan_louceng_fangjian_bujuService;

@Controller
@RequestMapping("/zlfb")
public class Zichan_louceng_fangjian_bujuController {
	@Autowired
	private Zichan_louceng_fangjian_bujuService zichan_louceng_fangjian_bujuService;

	/**
	 * 查询布局列表
	 * 
	 * @param keywords
	 * @param zichan
	 * @param louceng
	 * @param fangjian
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findZlfangList(
			@RequestParam(required = false) String keywords,
			@RequestParam(required = false) Long zichan,
			@RequestParam(required = false) Long louceng,
			@RequestParam(required = false) Long fangjian,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = zichan_louceng_fangjian_bujuService.findZlfbjList(
				keywords, zichan, louceng, fangjian, pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 新增或者修改布局信息
	 * 
	 * @param zlfjbj
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AppResponse updateZlfj(
			@ModelAttribute("Zichan_louceng_fangjian_buju") Zichan_louceng_fangjian_buju zlfjbj,
			HttpServletRequest req) {
		int zcl = zichan_louceng_fangjian_bujuService.updateZlfbj(zlfjbj);
		return AppResponse.okData(zcl);
	}

	/**
	 * 通过Id查询布局信息
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byid", method = RequestMethod.POST)
	public AppResponse getZlfbjById(@RequestParam(required = false) Long id,
			HttpServletRequest req) {
		Zichan_louceng_fangjian_bujuResp zclb = zichan_louceng_fangjian_bujuService
				.getZlfbjById(id);
		return AppResponse.okData(zclb);
	}
}