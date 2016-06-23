import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSide {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 4444);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String text = "", text1 = "";
			
			while (!text.equals("stop")) {
				text = br.readLine();
				out.writeUTF(text);
				out.flush();
				text1 = in.readUTF();
				System.out.println("Server : " + text1);
			}
			out.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Server Error : " + e.getMessage());
		}
	}

}
