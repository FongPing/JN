package com.yuntai.protobuf.test;

import java.net.ServerSocket;
import java.net.Socket;

import com.yuntai.protobuf.DoctorProto;
import com.yuntai.protobuf.DoctorProto.Doctor;


public class Server {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        ServerSocket serverSock = new ServerSocket(3030);
        while(true){
	        Socket sock = serverSock.accept();
	        byte[] msg = new byte[256];
	        sock.getInputStream().read(msg);
	        int msgBodyLen = msg[0];
	        System.out.println("msg body len:"+msgBodyLen);
	        byte[] msgbody = new byte[msgBodyLen];
	        System.arraycopy(msg, 1, msgbody, 0, msgBodyLen);
	        Doctor doctor = DoctorProto.Doctor.parseFrom(msgbody);
	        System.out.println("Receive:");
	        System.out.println(doctor.toString());
	        System.out.println(doctor.getHosName() + ":" + doctor.getName());
	        Thread.sleep(5000);
        }
    }

}
