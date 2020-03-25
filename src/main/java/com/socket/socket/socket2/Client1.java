package com.socket.socket.socket2;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: cdf
 * @create: 2020-03-25 14:15
 **/
public class Client1 {
    public static void main(String[] args) {
        try{
            Socket client1=new Socket("127.0.0.1",9999);
            PrintWriter output=new PrintWriter(client1.getOutputStream(),true);
            String word;
            Scanner sc=new Scanner(System.in);
            while (sc.hasNext()){
                word=sc.nextLine();
                output.println(word);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
