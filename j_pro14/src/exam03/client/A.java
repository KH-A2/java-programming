package exam03.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			InetAddress ipv4 = InetAddress.getLocalHost();
			int port = 51000;
			
			DatagramSocket udpSocket = new DatagramSocket(port, ipv4);
			
			System.out.print("server ip : ");
			String input = sc.nextLine();
			byte[] serverAddr = parserIPv4(input);
			InetAddress serverIp = InetAddress.getByAddress(serverAddr);
			int serverPort = 50000;
			
			int len = 1024;
			DatagramPacket packet;
			while(true) {
				System.out.print("경로 : ");
				String path = sc.nextLine();
				
				File f = new File(path);
				
				if(f.exists()) {
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
					long total = f.length();
					long current = 0;
					System.out.printf("%d / %d", current, total);
					while(bis.available() > 0) {
						byte[] data = bis.readNBytes(len > bis.available() ? len : bis.available());
						System.out.println("\n" + data.length + "\n" + len + "\n" + bis.available() + "\n");
						packet = new DatagramPacket(data, data.length, serverIp, serverPort);
						udpSocket.send(packet);
						current += data.length;
						System.out.printf("%d / %d\r", current, total);
					}
					System.out.println("\n");
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static byte[] parserIPv4(String ipv4) {
		String[] ipv4Arr = ipv4.split("\\.");
		byte[] addr = new byte[4];
		for(int i = 0; i < 4; i++) {
			addr[i] = (byte)Integer.parseInt(ipv4Arr[i]);
		}
		return addr;
	}
}
