package epsum.curso.chat.ventanas.clientes;

import java.io.IOException;
import java.io.PrintWriter;
import lombok.Data;

@Data
public class ClienteEnvioMensajeServidor extends ClienteChat {
		
	private String mensajeSalida;
	
	public ClienteEnvioMensajeServidor(String ip, int puerto, String mensajeSalida) {
		super(ip, puerto);
		this.mensajeSalida=mensajeSalida;
	}
	@Override
	public void hacerAlgo() throws IOException {
		PrintWriter printWriter= new PrintWriter(getSocket().getOutputStream());
		printWriter.println(getMensajeSalida());
		printWriter.flush();

	}

}
