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
import com.suyun.entity.Zichan;
import com.suyun.response.AppResponse;
import com.suyun.service.ZiChanService;
import com.suyun.vo.ZiChanVO;

@Controller
@RequestMapping("/zichan")
public class ZiChanController {

	@Autowired
	private ZiChanService ziChanService;

	/**
	 * 分页查询
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
			@RequestParam(required = false) String zc_mc,
			@RequestParam(required = false) String zc_zhengjian_zt,
			@RequestParam(required = false) Long zc_quanli_lx,
			@RequestParam(required = false) Long zc_quanli_xingzhi,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = ziChanService.findPageList(keywords,zc_mc,zc_zhengjian_zt,zc_quanli_lx,zc_quanli_xingzhi,pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 查询资产列表不分页
	 * 
	 * @param keywords
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findZcList(
			@RequestParam(required = false) String keywords,
			HttpServletRequest req) {
		List<Zichan> zc = ziChanService.findZcList();
		return AppResponse.okList(zc);
	}
	
	/**
	 * 根据Id查询数据
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/byid",method = RequestMethod.POST)
	public AppResponse findById(@Param("id") Long id,HttpServletRequest req){
		Zichan data = ziChanService.findById(id);
		return AppResponse.okData(data);
	}
	
	/**
	 * 修改/添加数据
	 * @param zichan
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	public AppResponse updateZichan(@ModelAttribute Zichan zichan, HttpServletRequest req) {
		int result = ziChanService.updateZichan(zichan);
		return AppResponse.okData(result);
	}
	
	/**
	 * 根据Id查询数据
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/details",method = RequestMethod.POST)
	public AppResponse details(@Param("id") Long id,HttpServletRequest req){
		ZiChanVO data = ziChanService.details(id);
		return AppResponse.okData(data);
	}
}
