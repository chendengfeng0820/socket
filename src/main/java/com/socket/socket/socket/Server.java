package com.socket.socket.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);

        System.out.println("服务器已准备就绪");
        System.out.println("服务器,IP:" + serverSocket.getLocalSocketAddress() + ",port:" + serverSocket.getLocalPort());

        //等待客户端连接
        for(;;){
            Socket client = serverSocket.accept();      //等待客户端连接
            ClientHandler clientHandler = new ClientHandler(client);
            clientHandler.start();
        }

    }

    private static class ClientHandler extends Thread{
        private Socket socket;
        private boolean flag = true;

        ClientHandler(Socket s){
            this.socket = s;
        }

        @Override
        public void run(){
            System.out.println("新客户端连接，IP:" + socket.getInetAddress() + ",port:" + socket.getPort());
            try {
                //获取服务端打印流，用来给客户端返回消息
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                //获取服务端的输入流
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                do{
                    String input = socketInput.readLine();      //获取客户端发送给服务端的消息
                    if("bye".equals(input)){
                        flag = false;
                        printStream.println("bye");             //回复客户端   也就是给客户端的输入流输入消息
                    }else{
                        System.out.println(input);
                        printStream.println("您输入的消息长度是：" + input.length());     //回复客户端   也就是给客户端的输入流输入消息
                    }
                }while (flag);

                socketInput.close();
                printStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("客户端已退出，IP:" + socket.getInetAddress() + ",port:" + socket.getPort());
        }
    }

}