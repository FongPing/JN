package com.yuntai.protobuf.test;

import java.io.IOException;
import java.net.Socket;

import com.alibaba.fastjson.JSON;
import com.yuntai.protobuf.DoctorJson;
import com.yuntai.protobuf.DoctorProto;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",3030);
        /*Mobile.MobilePhone.Builder builder = Mobile.MobilePhone.newBuilder();
        Mobile.Hardware.Builder hardware = Mobile.Hardware.newBuilder();
        hardware.setRam(2).setRom(16).setSize(5);
        builder.setHardware(hardware)
               .setBrand("Apple")
               .addSoftware("camera")
               .addSoftware("tecent")
               .addSoftware("browser")
               .addSoftware("player");*/
        DoctorProto.Doctor.Builder builder = DoctorProto.Doctor.newBuilder();
        builder.setId("123124123").setName("张一八").setHosName("浙二医院");
        
        
        
        byte[] messageBody = builder.build().toByteArray();
    
        int headerLen = 1;
        byte[] message = new byte[headerLen+messageBody.length];
        message[0] = (byte)messageBody.length;
        System.arraycopy(messageBody, 0,  message, 1, messageBody.length);
        System.out.println("msg len:"+message.length);
        socket.getOutputStream().write(message);
        
        //作为比较的json对象
        DoctorJson docJson = new DoctorJson();
        docJson.setId(builder.getId());
        docJson.setName(builder.getName());
        docJson.setHosName(builder.getHosName());
        
        
        byte[] messageBodyJson = JSON.toJSONString(docJson).getBytes();
        System.out.println("json 的长度：" + messageBodyJson.length);
	}

}
