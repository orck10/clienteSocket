package br.com.cliente.ClienteTCP.socketConetion;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketConection {
	
	public byte[] sendMessage(String ip, int port, byte[] message) {
		try {
			Socket s = new Socket(ip,port);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			DataInputStream din = new DataInputStream(s.getInputStream());
			
			byte[] responce = null;
			
			dout.write(message);
			
			try {
				boolean isEnd = false;
				List<Byte> inData = new  ArrayList<Byte>();
				while(! isEnd) {
					byte b = din.readByte();
					inData.add(b);
					if(13 == (int) b) {
						int currentLentgh = inData.size();
						int lentgh = inData.size() >= 2 ? (int) inData.get(1) : 0;
						isEnd = currentLentgh >= lentgh ? true : false;
					}
				}
				responce = new byte[inData.size()];
				int cout = 0;
				for(Byte b : inData) {
					responce[cout] = b;
					cout++;
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			dout.close();
			din.close();
			s.close();
			
			return responce;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
