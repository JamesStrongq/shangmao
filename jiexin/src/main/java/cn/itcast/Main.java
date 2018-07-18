package cn.itcast;

import cn.itcast.util.file.FileUtil;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
        public static void main(String[] args){
            String fileName = "D:\\ssh项目\\第02项目：SSH杰信商贸版(推荐学习项目）\\01\\day01";
            File[] fileList = new File(fileName).listFiles();
            for(int i = 0;i < fileList.length;i++){
                if(fileList[i].isDirectory()) {
                    System.out.println(fileList[i]);
                }

            }
        }

}
