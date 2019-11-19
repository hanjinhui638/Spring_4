package com.jh.s4.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public String save(String realPath, MultipartFile multipartFile)throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdir();
		}
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		file = new File(realPath, fileName);
		
		multipartFile.transferTo(file);
		return fileName;
	}
	
	
	public String save2(String realPath, MultipartFile multipartFile)throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		Calendar ca = Calendar.getInstance();
		long name = ca.getTimeInMillis();
		int idx = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileName = name+multipartFile.getOriginalFilename().substring(idx);
		
		file = new File(realPath, fileName);
		
		FileCopyUtils.copy(multipartFile.getBytes(),file);
		
		return fileName;
	}
	

}
