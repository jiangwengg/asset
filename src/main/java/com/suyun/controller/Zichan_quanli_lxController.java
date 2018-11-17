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
import com.suyun.entity.Zichan_quanli_lx;
import com.suyun.response.AppResponse;
import com.suyun.service.QuanLi_lxService;

@Controller
@RequestMapping("/leixing")
public class Zichan_quanli_lxController {

	@Autowired
	private QuanLi_lxService quanLi_lxService;
	
	
	/**
	 * 分页查询权利类型
	 * @param mc
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/page", method = RequestMethod.POST)
	public AppResponse findqllxPage(@RequestParam(required = false) String mc,@ModelAttribute("pageParam") PageParam pageParam, HttpServletRequest req){
		PageBean pb = quanLi_lxService.findqllxPage(mc,pageParam);
		return AppResponse.okList(pb);
	}
	
	/**
	 * 权利类型修改
	 * @param zichan_quanli_xz
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse qllxUpdate(@ModelAttribute Zichan_quanli_lx quanli_lx, HttpServletRequest req){
		int result = quanLi_lxService.update(quanli_lx);
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
	public AppResponse qllxbyid(@Param("id") Long id,HttpServletRequest req){
		Zichan_quanli_lx data = quanLi_lxService.qllxbyid(id);
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
	public AppResponse qllxdelete(@Param("id")Long id,HttpServletRequest req){
		int result = quanLi_lxService.qllxdelete(id);
		return AppResponse.okData(result);
	}
	
	
	/**
	 * 查询所有资产权利类型
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="list",method=RequestMethod.POST)
	public AppResponse quanlilxList(HttpServletRequest req){
		List<Zichan_quanli_lx> list = quanLi_lxService.findAll();
		return AppResponse.okList(list);
	}
}
