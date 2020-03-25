package com.socket.socket.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: cdf
 * @create: 2020-03-25 11:18
 **/
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(9999);
            Socket client=server.accept();

            BufferedReader input=new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            String line=input.readLine();
            System.out.println("客户端说："+line);

            PrintWriter printWriter=new PrintWriter(client.getOutputStream());
            System.out.println("返回消息给客户端");
            printWriter.flush();
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
