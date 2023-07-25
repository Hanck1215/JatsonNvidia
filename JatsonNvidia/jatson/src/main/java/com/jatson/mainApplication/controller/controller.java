package com.jatson.mainApplication.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jatson.mainApplication.Vision;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/upload")
public class controller {
	@RequestMapping("")
	public String returnUploadPage(Model model) {
		model.addAttribute("uploaded", false) ;
		return "upload" ;
	}
	
	@RequestMapping("/upload_sumit")
	public String savaImg(HttpServletRequest request, Model model) {
		//得到所有檔案的列表
		List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file") ;
		
		String current_dir = System.getProperty("user.dir");
		String uploadPath = current_dir+"\\src\\main\\resources\\static\\upload\\ImgUpload" ;
		File dir = new File(uploadPath) ;
		
		//如果上傳檔案的目錄不存在，則建立他
		if(!dir.exists()) { dir.mkdirs() ; }
		
		for(MultipartFile fil : files) {
			if(fil.isEmpty()) { continue ; }
			
			File target = new File(uploadPath + File.separator + "TestImage.png") ; //fil.getOriginalFilename()
			
			try {
				fil.transferTo(target) ;
				model.addAttribute("uploaded", true) ;
			} catch(IllegalStateException | IOException e) {
				e.printStackTrace() ;
				model.addAttribute("uploaded", false) ;
			}
		}
		return "upload" ;
	}
	
	@RequestMapping("/detect")
	public String handleDetect(Model mdl) throws IOException {
		String current_dir = System.getProperty("user.dir");
		Vision vsn = new Vision(current_dir+"\\src\\main\\resources\\static\\upload\\ImgUpload\\TestImage.png", current_dir+"\\src\\main\\resources\\static\\upload\\DetectedImg", 512, "detectedImg") ;
		vsn.loadPipeline() ;
		File fi = new File(current_dir+"\\src\\main\\resources\\static\\upload\\DetectedImg\\detectedImg.png");
		byte[] bytes = Files.readAllBytes(fi.toPath());
		String base64Img = "data:image/png;base64, " + Base64.getEncoder().encodeToString(bytes) ;
		mdl.addAttribute("bs64img", base64Img) ;
		return "detectedImg" ;
	}
}
