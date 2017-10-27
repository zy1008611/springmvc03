package com.zhidi.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUpLoadController {

	@RequestMapping("/toupload")
	public String toupload(){
		return "upload";
	}
	@RequestMapping("/upload")
	public String upload(MultipartFile tupian,HttpServletRequest req) throws IllegalStateException, IOException{
		if(tupian!=null){
			
			//获取需要存的文件的真实名称
			String realname = tupian.getOriginalFilename();
			//获取文件内容类型
			String contentType = tupian.getContentType();
			//获取项目下的部署路径
			String path = req.getServletContext().getRealPath("/upload");
			//System.out.println(req.getServletContext().toString());
			System.out.println(path);
			File savePath = new File(path);
			//判断存文件的文件夹是否存在
			if(!savePath.exists()){
				savePath.mkdirs();
			}
			//存文件 savePath:文件路径  realname：真实名称
			tupian.transferTo(new File(savePath,realname));
			//设置文件上传路径
			//图片路径：req.getContextPath()+"/upload/"+realname
			req.setAttribute("path", req.getContextPath()+"/upload/"+realname);
		}
		
		return "upload/success_upload";
		
	}
	
	@RequestMapping("/upload2")
	public String upload2(MultipartFile tupian,HttpServletRequest req) throws IllegalStateException, IOException{
		if(tupian!=null){
			//获取需要存的文件的真实名称
			String realname = tupian.getOriginalFilename();
			//获取文件内容类型
			String contentType = tupian.getContentType();
			File file = new File("D://upload");
			if(!file.exists()){
				file.mkdirs();
			}
			//将上传的文件保存到D:/upload
			tupian.transferTo(new File(file,realname));
			//由于浏览器无法访问本地路径，因此本方式无法上传图片至jsp
			req.setAttribute("path", file.getAbsolutePath()+"/"+realname);
		}
		return "upload/success_upload";
	}
}
