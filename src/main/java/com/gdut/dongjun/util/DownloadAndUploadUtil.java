package com.gdut.dongjun.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class DownloadAndUploadUtil {

	/**
	 * @throws IOException 
	 * 
	 * @Title: fileUpload
	 * @Description: 文件，图片上传工具 安卓端使用 HttpClient MultipartEntity
	 * @param @param file
	 * @param @param path
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static String[] fileUpload(MultipartFile[] files, String path) {

		String[] fileNames = null;
		if (files.length <= 0) {

			return null;
		} else {
			
			fileNames = new String[files.length];
			for (int i = 0; i < files.length; i++) {

				fileNames[i] = files[i].getOriginalFilename();
				
				//fileNames[i] = "xx";
				
				if (fileNames[i] == null || fileNames[i].equals("")) {

					continue;
				}
				
				//保证路径存在
				File directory = new File(path);
				if (!directory.exists()) {

					directory.mkdirs();
				}
				
				File uploadPath = new File(path, fileNames[i]);
				
				try {

					uploadPath.createNewFile();
					files[i].transferTo(uploadPath);
				} catch (IllegalStateException e) {
					e.printStackTrace();
					return null;
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return fileNames;
	}

	public static String ajaxdownLoad(HttpServletResponse response,
			String fileName, InputStream fileInputStream) {
		try {
			
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			response.setDateHeader("Expires", 0);
			// 得到响应的输出流 即向客户端输出信息的输出流。
			ServletOutputStream servletOutputStream = response
					.getOutputStream();
			byte[] b = new byte[1024];
			int len;

			while ((len = fileInputStream.read(b)) > 0) {
				servletOutputStream.write(b, 0, len);
			}
			response.setStatus(HttpServletResponse.SC_OK);
			response.flushBuffer();
			servletOutputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
		}
		return null;
	}

	/**
	 * 
	 * @Title: download
	 * @Description: 下载
	 * @param @param request
	 * @param @param file
	 * @param @param fileName
	 * @param @return
	 * @param @throws IOException
	 * @return ResponseEntity<byte[]>
	 * @throws
	 */
	public static ResponseEntity<byte[]> download(HttpServletRequest request,
			File file, String fileName) throws IOException {

		HttpHeaders headers = new HttpHeaders();
		String fileName2 = new String((fileName + ".xls").getBytes("UTF-8"),
				"iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName2);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}
}
