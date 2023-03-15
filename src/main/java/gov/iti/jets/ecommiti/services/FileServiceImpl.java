package gov.iti.jets.ecommiti.services;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        String fileName =  file.getOriginalFilename();
        Files.copy(file.getInputStream(),Paths.get(path+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String filePath = path + File.separator + fileName;

        InputStream inputStream = new FileInputStream(filePath);

        return inputStream;
    }

    public byte[] downloadImage(String imagePath)throws IOException{

        return Files.readAllBytes(new File(imagePath).toPath());

    }

}
