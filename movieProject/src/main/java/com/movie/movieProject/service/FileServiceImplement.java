package com.movie.movieProject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImplement implements FileService{
    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        //to get file name
        String fileName = file.getOriginalFilename();

        //to get file path
        String filePath = path + File.separator + fileName;

        //create file object
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //copy the file or uploaded file to the path
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    @Override
    public InputStream getResourseFile(String path, String fileName) throws FileNotFoundException {
        //to get file path
        String filePath = path + File.separator + fileName;

        return new FileInputStream(filePath);
    }
}
