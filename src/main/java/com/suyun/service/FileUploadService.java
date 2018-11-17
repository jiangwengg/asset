package com.suyun.service;

import org.springframework.web.multipart.MultipartFile;

import com.suyun.response.AppResponse;

public interface FileUploadService {

	AppResponse fileUpload(String path, MultipartFile[] file);

	AppResponse fileChange(String path, MultipartFile[] file);
}
