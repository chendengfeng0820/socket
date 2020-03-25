package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author: cdf
 * @create: 2020-03-25 23:16
 **/
public class UdpClient2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9999);

        byte[] buffer=new byte[1024];

        DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));
    }
}
