

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost",5555);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Hello it your first message :)");
			out.flush();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
