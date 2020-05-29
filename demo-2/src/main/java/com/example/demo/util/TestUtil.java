package com.example.demo.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class TestUtil {
    public static String vedio(File source){
        Encoder encoder = new Encoder();
        String s = "";
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            long second = ls/1000;
            s = second +"";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String formatSecond(String second){
        String  html="0秒";
        if(second!=null){
            Double s=Double.parseDouble(second);
            String format;
            Object[] array;
            Integer hours =(int) (s/(60*60));
            Integer minutes = (int) (s/60-hours*60);
            Integer seconds = (int) (s-minutes*60-hours*60*60);
            if(hours>0){
                format="%02d:%02d:%02d";
                array=new Object[]{hours,minutes,seconds};
            }else if(minutes>0){
                format="%02d:%02d";
                array=new Object[]{minutes,seconds};
            }else{
                format="00:%02d";
                array=new Object[]{seconds};
            }
            html= String.format(format, array);
        }

        return html;
    }
}
