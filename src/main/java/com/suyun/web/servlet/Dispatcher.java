package com.suyun.web.servlet;

import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.suyun.base.exception.BaseException;


public class Dispatcher extends DispatcherServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Dispatcher.class);

	@Override
	protected void noHandlerFound(HttpServletRequest request,
			HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		writeResp(request, response, HttpServletResponse.SC_NOT_FOUND, "error");
	}

	@Override
	protected void doDispatch(HttpServletRequest request,
			HttpServletResponse response) {
		try {
//			long l1 = System.currentTimeMillis();
//			Object url = request.getRequestURL();
			super.doDispatch(request, response);
//			long l2 = System.currentTimeMillis();
//			System.out.println((l2 - l1) + "ms for " + url);
		} catch (Throwable e) {
			e.printStackTrace();
			writeResp(request, response, e);
		}
	}

	protected ModelAndView processHandlerException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		writeResp(request, response, ex);
		return null;
	}

	private void writeResp(HttpServletRequest request, HttpServletResponse response, Integer code, String message) {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Credentials", "true"); //解决跨域访问报错 
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin")); //解决跨域访问报错 
		try (OutputStream ops = response.getOutputStream()) {
			HashMap<String, Object> r = new HashMap<String, Object>();
			r.put("code", code);
			r.put("message", message);
			ops.write(JSON.toJSONString(r).getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
	}

	private void writeResp(HttpServletRequest request, HttpServletResponse response, Throwable et) {
		if (et instanceof BaseException) {
			BaseException be = (BaseException) et;
			writeResp(request, response, be.getCode(), be.getMsg());
		} else {
			logger.error(et);
			int code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			if (et instanceof Exception) {
				code = StatusResolver.handException((Exception) et);
			}
			response.setStatus(code);
			writeResp(request, response, code, "error");
		}
	}
}
