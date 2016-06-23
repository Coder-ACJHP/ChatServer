import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(4444);
			Socket socket = server.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String text = "", text1 = "";

			while (!text.equals("stop")) {
				text = in.readUTF();
				System.out.println("Client : " + text);
				text1 = br.readLine();
				out.writeUTF(text1);
				out.flush();

			}
			in.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			System.out.println("Server Error : "+e.getMessage());
		}

	}

}
