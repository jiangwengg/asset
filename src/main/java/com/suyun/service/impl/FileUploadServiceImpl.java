package com.suyun.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suyun.base.exception.BaseException;
import com.suyun.base.tool.FileUtils;
import com.suyun.base.tool.ImageUtils;
import com.suyun.common.DxfHelp;
import com.suyun.entity.File;
import com.suyun.response.AppResponse;
import com.suyun.service.FileUploadService;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

	public AppResponse fileUpload(String path, MultipartFile[] file) {
		return fileUpload1(path, file);
	}

	public AppResponse fileUpload1(String subpath, MultipartFile[] file) {
		try {
			ArrayList<Object> list = new ArrayList<Object>(file.length);
			if (file != null && file.length > 0) {
				for (MultipartFile multipartFile : file) {
					File f = writeUploadFile(multipartFile, subpath);
					String oName = multipartFile.getOriginalFilename();
					Map<String, Object> fileResp = new HashMap<>();
					fileResp.put("oldName", oName);
					fileResp.put("path", f.getPath());
					list.add(fileResp);
				}
			}
			return AppResponse.okData(list);
		} catch (Exception e) {
			throw new BaseException("上传文件出错");
		}
	}

	
	private static String path="E:/photo/";
	private static String path1="/home/www/photo/";

	
	public File writeUploadFile(MultipartFile mf, String subpath)
			throws IOException {
		byte[] filedata = mf.getBytes();
		File file = null;
		file = new File();
		file.setSourceName(mf.getOriginalFilename()); // 原始文件名
		String originPath = path + subpath + "/";
		String filename = FileUtils.writeFile(originPath, filedata);
		System.out.println("原文件名：" + filename);
		int pos;
		String zippedName = (pos = filename.lastIndexOf(".")) >= 0 ? filename
				.substring(0, pos) + "_z." + filename.substring(1 + pos)
				: filename + "_z.";
		System.out.println("文件名：" + zippedName);
		ImageUtils.zoomImageScale(new java.io.File(originPath + filename),
				originPath + zippedName, 0);
		file.setPath(subpath + "/" + filename); // 文件路径
		return file;
	}

	/**
	 * CAD 文件转换
	 * 
	 * @param subpath
	 * @param file
	 * @return
	 */
	public AppResponse fileChange(String subpath, MultipartFile[] file) {
		try {
			ArrayList<Object> list = new ArrayList<Object>(file.length);
			if (file != null && file.length > 0) {
				for (MultipartFile multipartFile : file) {
					File f = writeUploadFile(multipartFile, subpath);
					String oName = multipartFile.getOriginalFilename();
					Map<String, Object> fileResp = new HashMap<>();
					fileResp.put("oldName", oName);
					fileResp.put("path", f.getPath());
					list.add(fileResp);
					DxfHelp.parseFile(path+f.getPath());
				}
			}
			return AppResponse.okData(list);
		} catch (Exception e) {
			throw new BaseException("上传文件出错");
		}
	}
}
