package com.example.demo.controller;

import com.example.demo.pojo.Message;
import com.example.demo.util.TestUtil;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.PutObjectOptions;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploader {

    @ResponseBody
    @PostMapping("/fileupload")
    public Message fileupload(MultipartFile[] file) throws Exception{
        Message message = new Message();
        List<String> pathList = new ArrayList<>();
        for(int i=0;i<file.length;i++){
            String prefix = file[i].getOriginalFilename().split("\\.")[0];
            String suffix = file[i].getOriginalFilename().split("\\.")[1];
            String newfilename = "";
            if(suffix.equals("mp4")){
                newfilename = "video/"+prefix+UUID.randomUUID().toString().replaceAll("-","")+"."+suffix;
                try{
                    // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
                    MinioClient minioClient=new MinioClient("http://172.29.14.51:25100","parent","parent321a?");

                    // 检查存储桶是否已经存在
                    boolean isExist=minioClient.bucketExists("picturebucket");
                    if(isExist){
                        System.out.println("Bucket already exists.");
                    }else {
                        // 创建一个名为picturebucket的存储桶，用于存储图片文件。
                        minioClient.makeBucket("picturebucket");
                    }
                    PutObjectOptions options = new PutObjectOptions(file[i].getSize(), -1);
                    // 使用putObject上传一个文件到存储桶中。
                    minioClient.putObject("picturebucket",newfilename, file[i].getInputStream(),options);
                    System.out.println(newfilename+" is successfully uploaded to `picturebucket` bucket.");
                }catch(Exception e){
                    System.out.println("Error occurred: "+e);
                }
                pathList.add(newfilename);
                message.setMessage(true);
            }else{
                newfilename = "img/"+prefix+UUID.randomUUID().toString().replaceAll("-","")+"."+suffix;
                try{
                    // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
                    MinioClient minioClient=new MinioClient("http://172.29.14.51:25100","parent","parent321a?");

                    // 检查存储桶是否已经存在
                    boolean isExist=minioClient.bucketExists("picturebucket");
                    if(isExist){
                        System.out.println("Bucket already exists.");
                    }else {
                        // 创建一个名为picturebucket的存储桶，用于存储图片文件。
                        minioClient.makeBucket("picturebucket");
                    }
                    PutObjectOptions options = new PutObjectOptions(file[i].getSize(), -1);
                    // 使用putObject上传一个文件到存储桶中。
                    minioClient.putObject("picturebucket",newfilename, file[i].getInputStream(),options);
                    System.out.println(newfilename+" is successfully uploaded to `picturebucket` bucket.");
                }catch(Exception e){
                    System.out.println("Error occurred: "+e);
                }
                pathList.add(newfilename);
                message.setMessage(true);
            }
            message.setPath(pathList);
        }
         return message;
     }



}
