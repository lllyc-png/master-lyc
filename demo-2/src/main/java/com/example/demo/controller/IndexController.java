package com.example.demo.controller;

import com.example.demo.pojo.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Value("${my-config.file-path}")
    private String myFilePath;




    @ResponseBody
    @RequestMapping("upload")
    public Message upload(@RequestParam("file") MultipartFile[] file, Model model, HttpSession session) throws IOException{
        Message message = new Message();
        /*try {
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            String destFileName=myFilePath+"uploaded"+ File.separator+fileName;

            File destFile = new File(destFileName);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            file.transferTo(destFile);
            model.addAttribute("filename","uploaded/"+fileName);
            session.setAttribute("filename",fileName);
            message.setMessage(true);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        List<String> list = new ArrayList<>();
        String newfilename="";
        for(int i=0;i<file.length;i++){
            String prefix = file[i].getOriginalFilename().split("\\.")[0];
            String suffix = file[i].getOriginalFilename().split("\\.")[1];
            newfilename = prefix+System.currentTimeMillis()+"."+suffix;
            File newFile = new File(myFilePath+"uploaded"+File.separator+newfilename);
            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            file[i].transferTo(newFile);
            list.add(newfilename);
        }
        message.setMessage(true);
        session.setAttribute("fileList",list);
        return message;
    }

    @ResponseBody
    @RequestMapping("/removeFile")
    public Message removeFile(HttpSession session, Model model) {
        Message message = new Message();
        List<String> fileNameList = (List<String>)session.getAttribute("fileList");
        for(int i=0;i<fileNameList.size();i++){
            File file = new File(myFilePath+"uploaded"+ File.separator+fileNameList.get(i));
            if (file != null) {
                //文件不为空，执行删除
                file.delete();
                message.setMessage(true);
            } else {
                message.setMessage(false);
            }
        }
        //跳转页面
        return message;
    }

}
