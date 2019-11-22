package com.jh.s4.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//서비스에서 호출
//객체생성
@Component
public class FileSaver {
	
	
	//file Delete
	public boolean fileDelete(String realPath, String filename)throws Exception{
		File file = new File(realPath, filename);
		boolean check = false;
		if(file.exists()) {
			check = file.delete();
		}
		return check;
	}
	
	
	//3. Io Stream 사용 
	public String save3(String realPath, MultipartFile multipartFile)throws Exception{	
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}	
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		file = new File(realPath, fileName);
		
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		
		return fileName;
	}
	
	
	//2. MultipartFile transferTo 메서드 사용 
	public String save2(String realPath, MultipartFile multipartFile)throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}		
		//저장할 파일명 
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		//System.out.println(fileName);
		
		file = new File(realPath, fileName);
		
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	
	//1. Spring에서 제공하는 FileCopyutils 클래스의 copy메서드 사용 
	public String save(String realPath, MultipartFile multipartFile) throws Exception{
		System.out.println(realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		Calendar ca = Calendar.getInstance();//static
		long name = ca.getTimeInMillis(); 
			
		int idx = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileName = name+multipartFile.getOriginalFilename().substring(idx);
			
		file = new File(realPath, fileName); //저장경로, 저장할파일명 형변환 class사용    String.valueOf(name)
		
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}

}
