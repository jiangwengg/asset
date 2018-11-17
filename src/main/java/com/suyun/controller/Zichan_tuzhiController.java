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
import com.suyun.entity.Zichan_tuzhi;
import com.suyun.response.AppResponse;
import com.suyun.service.Zichan_tuzhiService;

@Controller
@RequestMapping("/zctz")
public class Zichan_tuzhiController {
	@Autowired
	private Zichan_tuzhiService zichan_tuzhiService;

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
		PageBean pb = zichan_tuzhiService.findZcTzList(keywords, zichan,
				pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 添加修改
	 * 
	 * @param Zichan_tuzhiResp
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse update(@ModelAttribute Zichan_tuzhi zichan_tuzhi,
			HttpServletRequest req) {
		int result = zichan_tuzhiService.updateZcTz(zichan_tuzhi);
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
		Zichan_tuzhi result = zichan_tuzhiService.getZcTzById(id);
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
			@RequestParam(required = false) Long zcid, HttpServletRequest req) {
		Zichan_tuzhi result = zichan_tuzhiService.getZcTzByZichan(zcid);
		return AppResponse.okData(result);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param zt
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse updateZt(@RequestParam(required = true) Long id,
			@RequestParam(required = true) String zt, HttpServletRequest req) {
		int result = zichan_tuzhiService.updateZt(id, zt);
		return AppResponse.okData(result);
	}

}