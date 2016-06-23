import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerChat {

	private static ServerSocket server;

	public static void main(String[] args) {

		try {
			server = new ServerSocket(8899);
			System.out.println("Connected! now listening...");
			Socket socket = server.accept();
			
			OutputStream out = socket.getOutputStream();
			ObjectOutputStream sout = new ObjectOutputStream(out);
			InputStream in = socket.getInputStream();
			ObjectInputStream oin = new ObjectInputStream(in);
			
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			String r_msg,s_msg;
			while(true){
				//client
				if((r_msg = (String) oin.readObject()) != null){
					System.out.println("Client : "+r_msg);
				}
				//server
				s_msg = bf.readLine();
				sout.writeObject(s_msg);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
