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
import com.suyun.entity.Zichan_louceng;
import com.suyun.response.AppResponse;
import com.suyun.service.Zichan_loucengService;

@Controller
@RequestMapping("/zl")
public class Zichan_loucengController {
	@Autowired
	private Zichan_loucengService zichan_loucengService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findZclList(@RequestParam(required = false) Long zichan,
			HttpServletRequest req) {
		List<Zichan_louceng> zl = zichan_loucengService.findZclList(zichan);
		return AppResponse.okList(zl);
	}

	/**
	 * 分页查询
	 * 
	 * @param zichan
	 * @param bh
	 * @param mc
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.POST)
	public AppResponse findPageList(@RequestParam(required = false) Long bh,
			@RequestParam(required = false) String mc,
			@RequestParam(required = false) Long zichanId,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = zichan_loucengService.findPageList(zichanId, bh, mc,
				pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 根据Id查询数据
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byid", method = RequestMethod.POST)
	public AppResponse findById(@Param("id") Long id, HttpServletRequest req) {
		Zichan_louceng data = zichan_loucengService.findById(id);
		return AppResponse.okData(data);
	}

	/**
	 * 添加修改
	 * 
	 * @param zichan_louceng
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse update(@ModelAttribute Zichan_louceng zichan_louceng,
			HttpServletRequest req) {
		int result = zichan_loucengService.update(zichan_louceng);
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
	public AppResponse change(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String zt, HttpServletRequest req) {
		int result = zichan_loucengService.changeZt(id, zt);
		return AppResponse.okData(result);
	}

}