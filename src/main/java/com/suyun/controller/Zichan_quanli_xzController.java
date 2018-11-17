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
import com.suyun.entity.Zichan_quanli_xz;
import com.suyun.response.AppResponse;
import com.suyun.service.ZichanquanlixzService;

@Controller
@RequestMapping("/qlxz")
public class Zichan_quanli_xzController {
	@Autowired
	private ZichanquanlixzService zichanquanlixzService;
	
	/**
	 * 分页查询权利性质
	 * @param mc
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/page", method = RequestMethod.POST)
	public AppResponse findqlxzPage(@RequestParam(required = false) String mc,@ModelAttribute("pageParam") PageParam pageParam, HttpServletRequest req){
		PageBean pb = zichanquanlixzService.findqlxzPage(mc,pageParam);
		return AppResponse.okList(pb);
	}
	
	/**
	 * 权利性质修改
	 * @param zichan_quanli_xz
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse qlxzUpdate(@ModelAttribute Zichan_quanli_xz zichan_quanli_xz, HttpServletRequest req){
		int result = zichanquanlixzService.update(zichan_quanli_xz);
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
	public AppResponse qlxzbyid(@Param("id") Long id,HttpServletRequest req){
		Zichan_quanli_xz data = zichanquanlixzService.qlxzbyid(id);
		return AppResponse.okData(data);
				
	}
	
	/**
	 * 删除
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="delete",method = RequestMethod.POST)
	public AppResponse qlxzdelete(@Param("id")Long id,HttpServletRequest req){
		int result = zichanquanlixzService.qlxzdelete(id);
		return AppResponse.okData(result);
	}
	
	/**
	 * 查询所有资产权利性质
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="list",method=RequestMethod.POST)
	public AppResponse quanlixzList(HttpServletRequest req){
		List<Zichan_quanli_xz> list = zichanquanlixzService.findAll();
		return AppResponse.okList(list);
	}
	
}
