package com.suyun.controller;

import java.util.List;

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
import com.suyun.entity.Zichan_biaoji;
import com.suyun.response.AppResponse;
import com.suyun.response.Zichan_biaojiResp;
import com.suyun.service.Zichan_biaojiService;

@Controller
@RequestMapping("/zcbj")
public class Zichan_biaojiController {

	@Autowired
	private Zichan_biaojiService zichan_biaojiService;

	/**
	 * 分页查询
	 * 
	 * @param zichan
	 * @param louceng
	 * @param fangjian
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.POST)
	public AppResponse findPageList(
			@RequestParam(required = false) Long zichan,
			@RequestParam(required = false) String lx,
			@RequestParam(required = false) String keywords,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = zichan_biaojiService.findPageList(zichan, lx, keywords,
				pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 查询资产表计范围信息
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byid", method = RequestMethod.POST)
	public AppResponse findZcbjById(@RequestParam(required = false) Long id,
			HttpServletRequest req) {
		Zichan_biaojiResp zcbj = zichan_biaojiService.getBiaoJiByid(id);
		return AppResponse.okData(zcbj);
	}

	/**
	 * 更新资产表计
	 * 
	 * @param zcbj
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AppResponse updateZcbj(
			@ModelAttribute("Zichan_biaojiResp") Zichan_biaojiResp zcbj,
			HttpServletRequest req) {
		int bj = zichan_biaojiService.updateZcbj(zcbj);
		return AppResponse.okData(bj);
	}

	/**
	 * 资产表计的列表
	 * 
	 * @param lx
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findZcbjById(@RequestParam(required = false) String lx,
			HttpServletRequest req) {
		List<Zichan_biaoji> zcbj = zichan_biaojiService.findBiaoJiList(lx);
		return AppResponse.okList(zcbj);
	}
}
