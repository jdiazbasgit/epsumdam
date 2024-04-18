package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

	@Override
	public void run() {
		try(ServerSocket serverSocket= new ServerSocket(8000)) {
			while(true) {
				Socket socket= serverSocket.accept();
				//String mensaje=new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
				InputStreamReader inputStreamReader= new InputStreamReader(socket.getInputStream());
				BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
				String mensaje= bufferedReader.readLine();
				String ip=socket.getInetAddress().getHostAddress();
				System.out.println(ip+" dice: "+mensaje);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
