package gov.iti.jets.ecommiti.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gov.iti.jets.ecommiti.models.Images;
import gov.iti.jets.ecommiti.repositories.ImagesRepository;
import gov.iti.jets.ecommiti.util.ImageUtil;

@Service
public class ImagesService {

    @Autowired
	private ImagesRepository imagesRepository;

   
	public Images uploadImage(MultipartFile file) throws IOException {
		Images pImage = new Images();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
		return imagesRepository.save(pImage);
	}
	
	public byte[] downloadImage(String fileName){
        Optional<Images> imageData = imagesRepository.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
}
