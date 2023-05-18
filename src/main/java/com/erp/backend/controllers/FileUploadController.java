package com.erp.backend.controllers;


import com.erp.backend.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileUploadController {
	@Autowired
	UploadFileService storageService;
//	@GetMapping("/background/{url:.+}")
//	@ResponseBody
//	public ResponseEntity<Resource> getFileByUrlBackGround(@PathVariable String url) {
//		Resource file = storageService.loadByUrl(url);
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//	}
	@GetMapping("/avatar/{url:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFileByUrl(@PathVariable String url) {
		Resource file = storageService.loadByUrl(url,"avatar");
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}



	@GetMapping("/upload/{directory}/{url:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFileByUrl(@PathVariable String url,
												 @PathVariable String directory
	) {
		Resource file = storageService.loadByUrl(directory+'/'+url,"upload");
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}


}
