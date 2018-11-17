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
import com.suyun.entity.Zichan_gongyou;
import com.suyun.response.AppResponse;
import com.suyun.service.DanweiService;

@Controller
@RequestMapping("/danwei")
public class DanweiController {
	@Autowired
	private DanweiService danweiService;
	

	/**
	 * 分页查询单位
	 * @param mc
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/page", method = RequestMethod.POST)
	public AppResponse finddanweiPage(@RequestParam(required = false) String mc,@ModelAttribute("pageParam") PageParam pageParam, HttpServletRequest req){
		PageBean pb = danweiService.finddanweiPage(mc,pageParam);
		return AppResponse.okList(pb);
	}
	
	/**
	 * 单位修改
	 * @param zichan_quanli_xz
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse danweiUpdate(@ModelAttribute Danwei danwei, HttpServletRequest req){
		int result = danweiService.update(danwei);
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
	public AppResponse danweibyid(@Param("id") Long id,HttpServletRequest req){
		Danwei data = danweiService.danweibyid(id);
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
	public AppResponse danweidelete(@Param("id")Long id,HttpServletRequest req){
		int result = danweiService.danweidelete(id);
		return AppResponse.okData(result);
	}
	
	@ResponseBody
	@RequestMapping(value="list",method=RequestMethod.POST)
	public AppResponse gongyonglist(HttpServletRequest request){
		List<Danwei> list = danweiService.findDanweiMc();
		return AppResponse.okList(list);
	}
}
