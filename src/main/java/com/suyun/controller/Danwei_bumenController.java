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
import com.suyun.entity.Danwei;
import com.suyun.entity.Danwei_bumen;
import com.suyun.response.AppResponse;
import com.suyun.service.Danwei_bumenService;

@Controller
@RequestMapping("/bumen")
public class Danwei_bumenController {

	@Autowired 
	private Danwei_bumenService danwei_bumenService;
	
	/**
	 * 分页查询
	 * @param mc
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/page", method = RequestMethod.POST)
	public AppResponse finddanweiPage(@RequestParam(required = false) String mc,@ModelAttribute("pageParam") PageParam pageParam, HttpServletRequest req){
		PageBean pb = danwei_bumenService.findBumenPage(mc,pageParam);
		return AppResponse.okList(pb);
	}
	
	/**
	 * 修改数据
	 * @param bumen
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse danweiUpdate(@ModelAttribute Danwei_bumen bumen, HttpServletRequest req){
		int result = danwei_bumenService.update(bumen);
		return AppResponse.okData(result);
		
	}
	
	/**
	 * 根据Id查询数据
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="byid",method = RequestMethod.POST)
	public AppResponse byid(@Param("id") Long id,HttpServletRequest req){
		Danwei_bumen data = danwei_bumenService.danweibyid(id);
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
	public AppResponse delete(@Param("id")Long id,HttpServletRequest req){
		int result = danwei_bumenService.delete(id);
		return AppResponse.okData(result);
	}
	
	
	/**
	 * 查询状态为1的部门
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="list",method=RequestMethod.POST)
	public AppResponse gongyonglist(HttpServletRequest request){
		List<Danwei_bumen> list = danwei_bumenService.findBumenMc();
		return AppResponse.okList(list);
	}
}
