package com.suyun.controller;

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
import com.suyun.entity.Zichan_biaoji_feiyong;
import com.suyun.response.AppResponse;
import com.suyun.service.Zichan_biaoji_feiyongService;

@Controller
@RequestMapping("/zcbjfy")
public class Zichan_biaoji_feiyongController {

	@Autowired
	private Zichan_biaoji_feiyongService zichan_biaoji_feiyongService;

	/**
	 * 表计费用
	 * 
	 * @param biaoji
	 * @param bjlx
	 * @param keywords
	 * @param pageParam
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.POST)
	public AppResponse findPageList(
			@RequestParam(required = false) Long biaojiName,
			@RequestParam(required = false) String bjlx,
			@RequestParam(required = false) String keywords,
			@ModelAttribute("pageParam") PageParam pageParam,
			HttpServletRequest req) {
		PageBean pb = zichan_biaoji_feiyongService.findPageList(biaojiName, bjlx,
				keywords, pageParam);
		return AppResponse.okList(pb);
	}

	/**
	 * 查询资产表计费用信息
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/byid", method = RequestMethod.POST)
	public AppResponse findZcbjById(@RequestParam(required = false) Long id,
			HttpServletRequest req) {
		Zichan_biaoji_feiyong result = zichan_biaoji_feiyongService
				.getBiaoJiFeiYongByid(id);
		return AppResponse.okData(result);
	}

	/**
	 * 更新资产表计费用
	 * 
	 * @param zcbj
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AppResponse updateZcbj(
			@ModelAttribute("Zichan_biaoji_feiyong") Zichan_biaoji_feiyong zcbjfy,
			HttpServletRequest req) {
		int bj = zichan_biaoji_feiyongService.updateZcbjfy(zcbjfy);
		return AppResponse.okData(bj);
	}
}
