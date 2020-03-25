package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author: cdf
 * @create: 2020-03-25 23:07
 **/
public class UdpClient {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket();

            InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
            String msg="你好，我叫陈登峰";
            DatagramPacket datagramPacket=new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,inetAddress,9999);

            datagramSocket.send(datagramPacket);

            datagramSocket.receive(datagramPacket);

            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
