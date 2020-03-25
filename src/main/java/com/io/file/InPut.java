package com.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: cdf
 * @create: 2020-03-25 15:30
 **/
public class InPut {
    public static void main(String[] args) throws IOException {

        String path="chen.txt";
        File file=new File(path);
        InputStream input = null;
        try {
            input=new FileInputStream(file);
            int temp;
            while ((temp=input.read())!=-1){
                System.out.print((char) temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            input.close();
        }
        }
}
