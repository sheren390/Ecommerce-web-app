package gov.iti.jets.ecommiti.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gov.iti.jets.ecommiti.repositories.ImagesRepository;
import gov.iti.jets.ecommiti.services.ImagesService;

public class ImagesController {
    @RestController
    @RequestMapping("/api/test/image")
public class ProductImageController {
	
	@Autowired
	private ImagesService imagesService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("productImage")MultipartFile file) throws IOException{
		imagesService.uploadImage(file);
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
		byte[] image = imagesService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
	}
}
}
