package br.com.cliente.ClienteTCP.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cliente.ClienteTCP.dto.TextMessage;
import br.com.cliente.ClienteTCP.dto.User;
import br.com.cliente.ClienteTCP.socket.util.CrcGenerate;
import br.com.cliente.ClienteTCP.socketConetion.SocketConection;

@Service
public class MessageService {
	
	public byte[] saveTextMessage(TextMessage text) {
		byte[] mainData = setMainDataMessage(text.getMessage());
		int crc = new CrcGenerate(text.getPolynomial()).getCRC(mainData);

		try {
			return new SocketConection().sendMessage(text.getIp(), text.getPort(), requestData(crc , mainData));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public byte[] saveUser(User user) {
		byte [] mainData = setMainDataUser(user);
		int crc = new CrcGenerate(user.getPolynomial()).getCRC(mainData);
		try {
			return new SocketConection().sendMessage(user.getIp(), user.getPort(), requestData(crc , mainData));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Date getTime(TextMessage text) {
		byte[] mainData = setMainDataTime(text.getMessage());
		int crc = new CrcGenerate(text.getPolynomial()).getCRC(mainData);

		try {
			byte[] responce =  new SocketConection().sendMessage(text.getIp(), text.getPort(), requestData(crc , mainData));
			int frame = responce[2];
			int length = responce[1];
			if(frame == -96 && length == 11) {
				int day = responce[3];
				int month = responce[4];
				int year = ((int)responce[5])+100;
				int hour = responce[6];
				int min = responce[7];
				int sec = responce[8];
				return new Date(year, month-1, day, hour, min, sec);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Byte> getData(String mesage, int type){
		List<Byte> data = new ArrayList<>();
		data.add((byte) (mesage.length()+5));
		data.add((byte) type);
		for(byte b : mesage.getBytes()) {
			data.add(b);
		}
		return data;
	}
	
	private byte[] setMainDataUser(User user) {
		byte[] nome = user.getName().getBytes();
		
		byte[] byteData = new byte[nome.length + 6];
		
		byteData[0] = (byte) (nome.length + 9);
		byteData[1] = (byte) -94;
		
		byteData[2] = (byte) user.getAge().intValue();
		byteData[3] = (byte) user.getWeight().intValue();
		int size = (int) (100 * user.getSize().floatValue());
		byteData[4] = (byte) size;
		byteData[5] = (byte) nome.length;
		
		int count = 6;
		for(byte b : nome) {
			byteData[count] = b;
			count++;
		}
		
		return byteData;
	}
	
	private byte[] setMainDataMessage(String mesage) {
		List<Byte> list = getData(mesage, -95);
		
		byte[] byteData = new byte[list.size()];
		
		int count = 0;
		for(byte b : list) {
			byteData[count] = b;
			count++;
		}
		
		return byteData;
	}
	
	private byte[] setMainDataTime(String mesage) {
		List<Byte> list = getData(mesage, -93);
		
		byte[] byteData = new byte[list.size()];
		
		int count = 0;
		for(byte b : list) {
			byteData[count] = b;
			count++;
		}
		
		return byteData;
	}
	
	private byte[] requestData(int crc, byte[] data) {
		byte[] reqData = new byte[data.length +3];
		reqData[0] = (byte) 10;
		int count = 1;
		for(byte b : data) {
			reqData[count] = b;
			count++;
		}
		reqData[count] = (byte) crc;
		count++;
		reqData[count] = (byte) 13;
		return reqData;
 	}
}
