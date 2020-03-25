package com.io.file;

import java.io.File;

/**
 * @author: cdf
 * @create: 2020-03-25 14:52
 **/
public class FileDemo {
    public static void main(String[] args) {
        String path="/home/cdf/桌面/redis命令";
        File file=new File(path);
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.length());

    }
}
