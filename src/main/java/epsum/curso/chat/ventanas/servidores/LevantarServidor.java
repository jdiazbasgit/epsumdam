package epsum.curso.chat.ventanas.servidores;

public class LevantarServidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Servidor servidor= new Servidor();
		ServidorEscuchaRegistroServidor servidor= new ServidorEscuchaRegistroServidor(ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO);
		servidor.start();
		ServicorEscuchaBajaServidor servidorBaja= new ServicorEscuchaBajaServidor(ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
		servidorBaja.start();

		ServidorEscuchaMensajeServidor escuchaMensajeServidor= new ServidorEscuchaMensajeServidor(ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE);
		escuchaMensajeServidor.start();

	}

}
