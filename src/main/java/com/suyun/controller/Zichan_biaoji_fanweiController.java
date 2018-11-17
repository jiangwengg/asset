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
import com.suyun.response.AppResponse;
import com.suyun.service.Zichan_biaoji_fanweiService;

@Controller
@RequestMapping("/fanwei")
public class Zichan_biaoji_fanweiController {

	@Autowired
	private Zichan_biaoji_fanweiService zichan_biaoji_fanweiService;
	
	/**
	 * 分页查询
	 * @param zichan
	 * @param louceng
	 * @param fangjian
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/pagelist", method = RequestMethod.POST)
	public AppResponse findPageList(@RequestParam(required = false) String zichan,
			@RequestParam(required = false) String louceng,
			@RequestParam(required = false) String fangjian,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req){
		PageBean pb = zichan_biaoji_fanweiService.findPageList(zichan,louceng,fangjian,pageParam);
		return AppResponse.okData(pb);
	}
}
