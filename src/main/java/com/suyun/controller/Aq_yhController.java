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

import com.suyun.base.exception.BaseException;
import com.suyun.base.tool.MD5;
import com.suyun.common.MediaType;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Aq_yh;
import com.suyun.response.AppResponse;
import com.suyun.service.Aq_yhService;

@Controller
@RequestMapping("/aqyh")
public class Aq_yhController {
	@Autowired
	private Aq_yhService aq_yhService;

	/**
	 * 用户列表
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findZclList(HttpServletRequest req) {
		List<Aq_yh> yh = aq_yhService.findYhList();
		return AppResponse.okList(yh);
	}

	/**
	 * 用户分页
	 * 
	 * @param keywords
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.POST)
	public AppResponse findPageList(
			@RequestParam(required = false) String keywords,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = aq_yhService.findPageList(keywords, pageParam);
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
		Aq_yh data = aq_yhService.findYhById(id);
		return AppResponse.okData(data);
	}

	/**
	 * 添加修改
	 * 
	 * @param aq_yh
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse update(@ModelAttribute Aq_yh aq_yh,
			HttpServletRequest req) {
		int result = aq_yhService.update(aq_yh);
		return AppResponse.okData(result);
	}

	/**
	 * 改状态
	 * 
	 * @param id
	 * @param zt
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse change(@RequestParam(required = true) Long id,
			@RequestParam(required = true) Long zt, HttpServletRequest req) {
		int result = aq_yhService.changeZt(id, zt);
		return AppResponse.okData(result);
	}

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse login(@RequestParam(required = true) String username,
			@RequestParam(required = true) String password,
			HttpServletRequest req) {
		Aq_yh aqyh = aq_yhService.findYhByYhm(username);
		if (aqyh == null) {
			throw new BaseException(1001, "用户名不存在");
		}
		if (aqyh.getMm().equalsIgnoreCase(MD5.getMD5Str(password))) {
			aqyh.setMm(null);
			req.getSession().setAttribute("user", aqyh);
		} else {
			throw new BaseException(1002, "密码错误");
		}
		return AppResponse.okData(aqyh);
	}

	/**
	 * 退出登录
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse logout(HttpServletRequest req) {
		req.getSession().removeAttribute("user");
		return AppResponse.okData();
	}
}