package com.socket.socket.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: cdf
 * @create: 2020-03-25 11:01
 **/
public class TcpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9091);//serversocket 端口号
        try {
            Socket client = server.accept();//等待客户端 连接9091端口
            try {
                //InputStreamReader  将字节流转化为字符流
                //getInputStream  getInputStream方法得到的是一个输入流，服务端的Socket对象上的getInputStream方法
                // 得到的输入流其实就是从客户端发送给服务器端的数据流。
                BufferedReader input =
                        new BufferedReader(new InputStreamReader(client.getInputStream()));
                boolean flag = true;

//                Scanner scanner=new Scanner(System.in);


                while (flag) {

                    String line = input.readLine();
                    System.out.println("客户端说： "+ line);

                    if (line.equals("exit")) {
                        flag = false;
                        System.out.println("客户端不想玩了！");
                    } else {
                        System.out.println("客户端说：  "+ line);
                    }

                }
            } finally {
                client.close();
            }

        } finally {
            server.close();
        }
    }
}
