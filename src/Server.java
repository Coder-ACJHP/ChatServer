

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {

		try {
			ServerSocket servers = new ServerSocket(5555);
			Socket socket = servers.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String text = (String)in.readUTF();
			System.out.println("Recieved Message : "+text);
			
			servers.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
