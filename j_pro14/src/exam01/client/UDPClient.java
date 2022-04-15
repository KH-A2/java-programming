package exam01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// InetAddress iNet = InetAddress.getByName("localhost");  127.0.0.1
			
			// byte[] ipAddr = new byte[] {(byte)192, (byte)168, 20, 11};
			// InetAddress iNet = InetAddress.getByAddress(ipAddr);
			
			/*
			 * 1. 네트워크 통신을 위한 IP 주소 정보 설정
			 */
			InetAddress iNet = InetAddress.getLocalHost();
			InetAddress serverINet = iNet;
			
			/*
			 * 2. UDP 통신용 소켓 생성
			 */
			DatagramSocket dSock = new DatagramSocket(50100, iNet);
			
			while(true) {
				/*
				 * 3. 사용자가 입력한 메시지를 데이터그램 패킷으로 만들어서 전송.
				 */
				System.out.print("Client : ");
				
				String msg = sc.nextLine();
				DatagramPacket dPack = new DatagramPacket(msg.getBytes(), msg.getBytes().length, serverINet, 51100);
				dSock.send(dPack);
				
				/*
				 * 4. 서버로부터 데이터 수신확인 응답을 받기 위한 부분
				 */
				byte[] buff = new byte[1024];
				DatagramPacket resPack = new DatagramPacket(buff, buff.length);
				dSock.receive(resPack);
				
				InetAddress clientIP = dPack.getAddress();	// 송신측 IP
				int clientPort = dPack.getPort();	// 송신측 Port
				
				String rev = new String(resPack.getData(), 0, resPack.getData().length);
				System.out.println("Server Message -> " + rev);
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
