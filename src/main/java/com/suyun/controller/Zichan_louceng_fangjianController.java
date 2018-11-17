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

import com.suyun.base.tool.StringUtil;
import com.suyun.common.PageBean;
import com.suyun.common.PageParam;
import com.suyun.entity.Zichan_louceng_fangjian;
import com.suyun.response.AppResponse;
import com.suyun.response.Zichan_louceng_fangjianResp;
import com.suyun.response.Zichan_louceng_fangjian_renyuanResp;
import com.suyun.service.Zichan_louceng_fangjianService;
import com.suyun.service.Zichan_louceng_fangjian_renyuanService;

@Controller
@RequestMapping("/zlf")
public class Zichan_louceng_fangjianController {
	@Autowired
	private Zichan_louceng_fangjianService zichan_louceng_fangjianService;
	@Autowired
	private Zichan_louceng_fangjian_renyuanService zichan_louceng_fangjian_renyuanService;

	@ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.POST)
	public AppResponse findZlfangList(
			@RequestParam(required = false) String keywords,
			@RequestParam(required = false) Long zichan,
			@RequestParam(required = false) Long louceng,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = zichan_louceng_fangjianService.findZlfangList(keywords,
				zichan, louceng, pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 通过id查询资产楼层信息
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byid", method = RequestMethod.POST)
	public AppResponse findZlfangById(@RequestParam(required = false) Long id,
			HttpServletRequest req) {
		Zichan_louceng_fangjianResp zcl = zichan_louceng_fangjianService
				.findZlfangById(id);
		if (zcl != null) {
			List<Zichan_louceng_fangjian_renyuanResp> renyuanList = zichan_louceng_fangjian_renyuanService
					.findZlfryList(zcl.getZichan(), zcl.getLou_ceng(),
							zcl.getId());
			String name = null;
			String ids = null;
			if (renyuanList != null) {
				for (Zichan_louceng_fangjian_renyuanResp renyuan : renyuanList) {
					if (StringUtil.isNotBlank(name)) {
						name = name + "," + renyuan.getRenyuanMc();
						ids = ids + "," + renyuan.getRenyuan();
					} else {
						name = renyuan.getRenyuanMc();
						ids = renyuan.getRenyuan().toString();
					}
				}
			}
			zcl.setRenyuanMc(name);
			zcl.setRenyuanIds(ids);
		}

		return AppResponse.okData(zcl);
	}

	/**
	 * 新增或者修改资产楼层房间
	 * 
	 * @param zlfj
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AppResponse updateZlfj(
			@ModelAttribute("Zichan_louceng_fangjian") Zichan_louceng_fangjian zlfj,
			@RequestParam(required = false) String renyuans,
			HttpServletRequest req) {
		int zcl = zichan_louceng_fangjianService.updateZlfj(zlfj, renyuans);
		return AppResponse.okData(zcl);
	}

	/**
	 * 通过楼层Id查询房间列表分页
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AppResponse findZlfjList(
			@RequestParam(required = false) Long zichanId,
			@RequestParam(required = false) Long lcid, HttpServletRequest req) {
		List<Zichan_louceng_fangjian> zcl = zichan_louceng_fangjianService
				.findZlfjList(zichanId, lcid);
		return AppResponse.okList(zcl);
	}

	/**
	 * 更新状态
	 * 
	 * @param id
	 * @param zt
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public AppResponse changeZt(@RequestParam(required = true) Long id,
			@RequestParam(required = false) String zt, HttpServletRequest req) {
		int zcl = zichan_louceng_fangjianService.changeZt(id, zt);
		return AppResponse.okData(zcl);
	}
}