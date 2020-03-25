package com.io.file;

import java.io.*;

/**
 * @author: cdf
 * @create: 2020-03-25 16:00
 **/
public class OutPut {
    public static void main(String[] args) throws IOException {
        File file =new File("chen.txt");

        OutputStream output=new FileOutputStream(file,true);

        String write="chen deng feng ";
        byte[] msg=write.getBytes();
        output.write(msg,0,msg.length);
        output.flush();
        output.close();
    }
}
