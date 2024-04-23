package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public abstract class ServidorChat extends Thread {

	public final static int PUERTO_ESCUCHA_SERVIDOR_REGISTRO=8000;
	public final static int PUERTO_ESCUCHA_SERVIDOR_MENSAJE=8002;
	public final static int PUERTO_ESCUCHA_SERVIDOR_BAJA=8004;
	private int puerto;
	private Socket socket;
	
	public static Map<String, String> usuarios= new HashMap<>();
	
	public static ArrayList<String> mensajes;
	
	ServidorChat(int puerto){
		this.puerto=puerto;
	}
	

	@Override
	public void run() {
		try(ServerSocket serverSocket= new ServerSocket(getPuerto())) {
			while(true) {
				setSocket(serverSocket.accept());
				hacerAlgo();
				getSocket().close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public abstract void hacerAlgo() throws IOException ;
	
	public String recibirTexto() throws IOException {
		String salida=""; 
			try(BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(getSocket().getInputStream()))) {
				salida=bufferedReader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		return salida;
	}
	
	public Object recibirObjeto() {
		Object salida=null;
		try(ObjectInputStream objectInputStream= new ObjectInputStream(getSocket().getInputStream())) {
			salida=objectInputStream.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return salida;
	}
	
	
}
