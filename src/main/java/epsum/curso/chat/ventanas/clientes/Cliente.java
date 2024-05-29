package epsum.curso.chat.ventanas.clientes;

import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
@Data
public class Cliente {

	public static void main(String[] args) {

		try (Socket socket= new Socket("192.168.0.195",8000)) {
			PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
			printWriter.println("hola hola");
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
