package epsum.curso.chat.ventanas.clientes;

import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import lombok.Data;

@Data
public abstract class ClienteChat extends Thread {

	private final static int PUERTO_EXCUCHA_CLIENTE_MENSAJE = 8001;
	private final static int PUERTO_EXCUCHA_CLIENTE_REGISTRO = 8003;
	private final static int PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA = 8005;
	private final static int PUERTO_EXCUCHA_CLIENTE_FICHERO_AVANZADILLA = 8009;
	private final static int PUERTO_EXCUCHA_CLIENTE_FICHERO_DATOS = 8011;

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

	public abstract void hacerAlgo();
	
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
