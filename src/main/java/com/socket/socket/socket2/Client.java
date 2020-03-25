package com.socket.socket.socket2;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: cdf
 * @create: 2020-03-25 11:29
 **/
public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 9999);

            BufferedWriter output=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            Scanner scanner=new Scanner(System.in);
            String word;

            while (scanner.hasNext()){
                word=scanner.nextLine();
                output.write(word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
