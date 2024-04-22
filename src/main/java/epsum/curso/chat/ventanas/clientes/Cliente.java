package epsum.curso.chat.ventanas.clientes;

import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		try (Socket socket= new Socket("192.168.0.125",8000)) {
			PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
			printWriter.println("eres el mas guapo");
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
