package epsum.curso.clientes;

import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket("192.168.0.125", 8000)){
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println("Indios y culés!");
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
