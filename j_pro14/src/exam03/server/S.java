package exam03.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class S {
	
	public static void dataReceive(DatagramSocket socket) throws IOException {
		int bufferSize = socket.getReceiveBufferSize();
		byte[] buffer = new byte[bufferSize];
		
		DatagramPacket packet = new DatagramPacket(buffer, bufferSize);
		while(true) {
			socket.receive(packet);
			System.out.println(packet.getData());
		}
	}

	public static void main(String[] args) {
		try {
			byte[] addr = new byte[] {(byte)192, (byte)168, 20, 11};
			InetAddress ipv4 = InetAddress.getByAddress(addr);
			int port = 50000;
			
			DatagramSocket udpSocket = new DatagramSocket(port, ipv4);
			
			dataReceive(udpSocket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
