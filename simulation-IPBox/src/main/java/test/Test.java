package test;

import util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args)  {
        String directory = "F:\\实习\\test";
        String filename = "test.txt";

        File file = new File(directory);
        if(!file.isDirectory()){
            file.mkdirs();
        }
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        try{
            FileOutputStream fos = new FileOutputStream(directory+"\\"+filename);
            for(int i=0;i<10000;i++){
                String str = StringUtils.getRandomChar(10);
                String name = StringUtils.getRandomChar(4);
                String code = StringUtils.getRandomChar(9);
                String res = str+","+name+","+code+"\n";
                byte[] bytes = res.getBytes();
                fos.write(bytes);
            }
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
