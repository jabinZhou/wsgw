package com.zzb.shop.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzb.shop.util.FileUtils;
import com.zzb.shop.util.ImgEditorUtils;


/**
 * 文件工具处理层
 * @author zhouzb
 *
 */
@Controller
@RequestMapping({"/file" })
public class FileController {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static Logger logger = Logger.getLogger(FileController.class);
	
	
	/**
	 * 协议下载
	 * @author kj
	 * @return
	 */
	@RequestMapping(value={"/download"}, method=RequestMethod.GET)
	 public void download(HttpServletRequest request,HttpServletResponse response,String fileName) {
		try {
			//文件位置 物理位置
		     String FILE_PATH = request.getSession().getServletContext().getRealPath("/") + "downloadFile\\"+fileName; 
			FileUtils.download(request,response,FILE_PATH);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(fileName+"*************下载异常*************");
		}
	  }
	
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 @RequestMapping(value={"/upload"}, method=RequestMethod.POST)
	 public void upload(String fileType,String dirName,Integer width,Integer height, MultipartFile file, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		response.setContentType("text/html; charset=UTF-8");
	    if (file==null || !FileUtils.fileTypeVaild(fileType, file.getOriginalFilename()) || !FileUtils.fileSizeVaild(file)){
	    	objectMapper.writeValue(response.getWriter(), "上传文件格式或大小不正确！");
	    }else{
	      String str = null;	
	      if("image".equals(fileType)&&(width!=null || height!=null) ){
	    	  str = FileUtils.imgScale(dirName, file, height, width, false);
	      }else{
	    	  str = FileUtils.upload(fileType, dirName, file);
	      }	
	      if (str == null) {
	    	objectMapper.writeValue(response.getWriter(), "上传失败！");
	      }
	      HashMap localHashMap = new HashMap();
	      localHashMap.put("url", str);
	      localHashMap.put("message", "上传成功");
	      objectMapper.writeValue(response.getWriter(), localHashMap);
	    }
	  }
	 
	 /**
	 * 插件截图上传
	 * @author kj
	 * @return
	 */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 @RequestMapping(value={"/uploadJcrop"}, method=RequestMethod.POST)
	 public void uploadJcrop(String fileType,String dirName,Integer width,Integer height, 
			 MultipartFile file, HttpServletRequest request,HttpSession session, HttpServletResponse response)
					 throws JsonGenerationException, JsonMappingException, IOException{
		
		 response.setContentType("text/html; charset=UTF-8");
		 if (file==null || !FileUtils.fileTypeVaild(fileType, file.getOriginalFilename()) || !FileUtils.fileSizeVaild(file)){
			 objectMapper.writeValue(response.getWriter(), "上传文件格式或大小不正确！");
		 }else{
			 String str = null;	
			 ImgEditorUtils imgEditor = new ImgEditorUtils();
			 //保存位置
		     String FILE_PATH = session.getServletContext().getRealPath("/") + dirName; 
		     //物理地址
		     String Path=null;
			 if("image".equals(fileType)&&(width!=null || height!=null) ){
				 str = imgEditor.uploadFile(file,dirName,FILE_PATH, request, session);
				 Path=FILE_PATH+"\\"+str;
				//将图片压缩成指定大小  
				 imgEditor.zoomImage(Path,Path,width,height);  
			 }else{
				 str = imgEditor.uploadFile(file,dirName,FILE_PATH, request,session);  
				 Path=FILE_PATH+"\\"+str;
				 //将图片压缩成指定大小  
				 imgEditor.zoomImage(Path,Path,350,350); 
			 }	
			 if (str == null) {
				 objectMapper.writeValue(response.getWriter(), "上传失败！");
			 }
			 
			//展示地址
		     String showUrl = request.getContextPath() +"/"+ dirName+"/"+str;
			 HashMap localHashMap = new HashMap();
			 localHashMap.put("url", showUrl);
			 localHashMap.put("message", "上传成功");
			 objectMapper.writeValue(response.getWriter(), localHashMap);
		 }
	 }
}
