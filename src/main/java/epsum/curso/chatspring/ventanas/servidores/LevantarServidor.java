package epsum.curso.chatspring.ventanas.servidores;

public class LevantarServidor {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		//Servidor servidor= new Servidor();
		ServidorEscuchaRegistroServidor servidor= new ServidorEscuchaRegistroServidor(ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO);
		servidor.start();
		ServidorEscuchaBajaServidor servidorBaja= new ServidorEscuchaBajaServidor(ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
		servidorBaja.start();

		ServidorEscuchaMensajeServidor escuchaMensajeServidor= new ServidorEscuchaMensajeServidor(ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE);
		escuchaMensajeServidor.start();

	}

}
