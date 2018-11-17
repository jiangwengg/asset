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
import com.suyun.entity.Zichan_louceng_fangjian_xingzhi;
import com.suyun.response.AppResponse;
import com.suyun.service.Zichan_louceng_fangjian_xingzhiService;

@Controller
@RequestMapping("/zlfx")
public class Zichan_louceng_fangjian_xingzhiController {
	@Autowired
	private Zichan_louceng_fangjian_xingzhiService xingzhiService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findZclList(@RequestParam(required = false) Long zichan,
			HttpServletRequest req) {
		List<Zichan_louceng_fangjian_xingzhi> xz = xingzhiService
				.findZlfxzList();
		return AppResponse.okList(xz);
	}
	
	/**
	 * 分页查询楼层房间性质
	 * @param mc
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/page", method = RequestMethod.POST)
	public AppResponse findxingzhiPage(@RequestParam(required = false) String mc,@ModelAttribute("pageParam") PageParam pageParam, HttpServletRequest req){
		PageBean pb = xingzhiService.findxingzhiPage(mc,pageParam);
		return AppResponse.okList(pb);
	}
	
	/**
	 * 楼层房间性质修改
	 * @param zichan_quanli_xz
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse xingzhiUpdate(@ModelAttribute Zichan_louceng_fangjian_xingzhi xingzhi, HttpServletRequest req){
		int result = xingzhiService.update(xingzhi);
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
	public AppResponse xingzhibyid(@Param("id") Long id,HttpServletRequest req){
		Zichan_louceng_fangjian_xingzhi data = xingzhiService.xingzhibyid(id);
		return AppResponse.okData(data);
				
	}
	
	/**
	 * 删除楼层房间性质
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="delete",method = RequestMethod.POST)
	public AppResponse xingzhidelete(@Param("id")Long id,HttpServletRequest req){
		int result = xingzhiService.xingzhidelete(id);
		return AppResponse.okData(result);
	}

}