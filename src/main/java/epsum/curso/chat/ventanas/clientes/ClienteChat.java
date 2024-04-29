package epsum.curso.chat.ventanas.clientes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import lombok.Data;

@Data
public abstract class ClienteChat extends Thread {

	public final static int PUERTO_EXCUCHA_CLIENTE_REGISTRO = 8001;
	public final static int PUERTO_EXCUCHA_CLIENTE_MENSAJE = 8003;
	public final static int PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA = 8005;
	public final static int PUERTO_EXCUCHA_CLIENTE_FICHERO_AVANZADILLA = 8009;
	public final static int PUERTO_EXCUCHA_CLIENTE_FICHERO_DATOS = 8011;
	//public final static String SERVIDOR="192.168.0.125";
	public final static String SERVIDOR="localhost";
	

	private String ip;
	private int puerto;
	private Socket socket;
	

	public ClienteChat(String ip, int puerto) {
		this.ip = ip;
		this.puerto = puerto;
	}

	@Override
	public void run() {
		try (Socket socket = new Socket(getIp(), getPuerto())) {
			setSocket(socket);
			hacerAlgo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void hacerAlgo() throws IOException;
	
	public void enviarTexto(String texto) {
		
		try(PrintWriter printWriter= new PrintWriter(getSocket().getOutputStream())) {
			printWriter.println(texto);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public void enviarObjeto(Object objeto) {
		try(ObjectOutputStream objectOutputStream= new ObjectOutputStream(getSocket().getOutputStream())) {
			objectOutputStream.writeObject(objeto);
			objectOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
