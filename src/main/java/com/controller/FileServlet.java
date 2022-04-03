package com.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileServlet {
    @PostMapping("/upload")
    public String getFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty() ||!"image/jpeg".equals(file.getContentType())){
            return "檔案類型錯誤！,只接收Jpg圖檔";
        }else{
            Files.write(Paths.get("/Users/linyukai/Desktop/"+file.getName()+".jpg"),file.getBytes());
            return "收到檔案了";
        }
    }

    @GetMapping("/download")
    public byte[] getFile() throws IOException {
      return Files.readAllBytes(Paths.get("/Users/linyukai/Desktop/qqq.jpg"));
    }
}
