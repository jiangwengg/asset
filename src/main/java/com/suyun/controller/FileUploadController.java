package com.suyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.suyun.common.MediaType;
import com.suyun.response.AppResponse;
import com.suyun.service.FileUploadService;

@Controller
@RequestMapping("/file")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * 上传文件
	 * 
	 * @param path
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA)
	public AppResponse fileUpload(@RequestParam("path") String path,
			@RequestParam(value = "file", required = false) MultipartFile[] file) {
		return fileUploadService.fileUpload(path, file);
	}

	/**
	 * 文件转换
	 * 
	 * @param path
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA)
	public AppResponse fileChange(@RequestParam("path") String path,
			@RequestParam(value = "file", required = false) MultipartFile[] file) {
		return fileUploadService.fileChange(path, file);
	}

}
