package com.suyun.controller;

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
import com.suyun.entity.Zichan_gongyou;
import com.suyun.response.AppResponse;
import com.suyun.service.ZiChanGYService;

@Controller
@RequestMapping("/gongyou")
public class Zichan_gongyouController {

	@Autowired
	private ZiChanGYService ziChanGYService;
	

	/**
	 * 分页查询共有情况
	 * @param mc
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/page", method = RequestMethod.POST)
	public AppResponse findgypage(@RequestParam(required = false) String mc,@ModelAttribute("pageParam") PageParam pageParam, HttpServletRequest req){
		PageBean pb = ziChanGYService.findgypage(mc,pageParam);
		return AppResponse.okList(pb);
	}
	
	/**
	 * 共有情况修改
	 * @param zichan_quanli_xz
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse gyUpdate(@ModelAttribute Zichan_gongyou gongyou, HttpServletRequest req){
		int result = ziChanGYService.update(gongyou);
		return AppResponse.okData(result);
		
	}
	
	/**
	 * 根据Id查找数据
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="byid",method = RequestMethod.POST)
	public AppResponse gybyid(@Param("id") Long id,HttpServletRequest req){
		Zichan_gongyou data = ziChanGYService.gybyid(id);
		return AppResponse.okData(data);
				
	}
	
	/**
	 * 删除共有情况
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="delete",method = RequestMethod.POST)
	public AppResponse gydelete(@Param("id")Long id,HttpServletRequest req){
		int result = ziChanGYService.gydelete(id);
		return AppResponse.okData(result);
	}
	
}
