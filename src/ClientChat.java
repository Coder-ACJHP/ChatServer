import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientChat {

	private static Socket socket;

	public static void main(String[] args) {

		try {
			socket = new Socket("127.0.0.1", 8899);
			System.out.println("Connected! now listening...");
			
			InputStream in = socket.getInputStream();
			ObjectInputStream oin = new ObjectInputStream(in);
			OutputStream out = socket.getOutputStream();
			ObjectOutputStream sout = new ObjectOutputStream(out);
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			String r_msg,s_msg;
			
			while(true) {
				//server
				s_msg = bf.readLine();
				sout.writeObject(s_msg);
				//client
				if((r_msg = (String)oin.readObject()) != null){
					System.out.println("Server : "+r_msg);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
