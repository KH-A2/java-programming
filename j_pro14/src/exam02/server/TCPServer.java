package exam02.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			/*
			 * 1. 서버용 소켓 생성 
			 */
			ServerSocket sSock = new ServerSocket();
			
			/*
			 * 2. 생성한 소켓에 서버IP 주소, 서버 Port 번호 바인딩(연결)
			 */
			byte[] addr = new byte[] {(byte)192, (byte)168, 20, 11};
			InetAddress serverIP = InetAddress.getByAddress(addr);
			int serverPort = 50000;
			
			InetSocketAddress serverIpPort = new InetSocketAddress(serverIP, serverPort);
			sSock.bind(serverIpPort);
			
			Socket cSock = sSock.accept();
			
			InetAddress clientIP = cSock.getInetAddress();
			int clientPort = cSock.getPort();
			int connectionPort = cSock.getLocalPort();
			
			System.out.printf("%s:%d <----> %s:%d", serverIP.getHostAddress(), connectionPort,
					clientIP.getHostAddress(), clientPort);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
