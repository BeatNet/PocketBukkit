package net.pocketbukkit.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import net.pocketbukkit.utility.ServerLogger;

public class UDPSocket {
	private static DatagramSocket serverSocket;
	private static ServerLogger logger;

	public static void open() throws Exception{ 
		try{ 
			serverSocket = new DatagramSocket(19132); 
			byte[] receiveData = new byte[1024]; 
			byte[] sendData  = new byte[1024]; 
			while(true){ 
				receiveData = new byte[1024]; 
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
				logger.info("Waiting for datagram packet...");
				serverSocket.receive(receivePacket); 
				String sentence = new String(receivePacket.getData()); 
				InetAddress IPAddress = receivePacket.getAddress(); 
				int port = receivePacket.getPort(); 
				logger.info("From: " + IPAddress + ":" + port);
				logger.info("Message: " + sentence);
				String capitalizedSentence = sentence.toUpperCase(); 
				sendData = capitalizedSentence.getBytes(); 
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); 
				serverSocket.send(sendPacket); 
			} 
		}catch(SocketException ex){
			System.exit(1);
		}
	}
	
	public static void close(){
		serverSocket.close();
	}
}
