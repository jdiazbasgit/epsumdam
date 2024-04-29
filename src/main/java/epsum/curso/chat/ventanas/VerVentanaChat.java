package epsum.curso.chat.ventanas;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.servidores.ServidorChat;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroCliente;

public class VerVentanaChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaChat ventana= new VentanaChat();
		ventana.setVisible(true);
		ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente= 
				new  ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, ventana);
		servidorEscuchaRegistroCliente.start();
		ServidorEscuchaMensajeCliente servidorMensaje= new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ventana);
		servidorMensaje.start();
		
		ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente= 
				new  ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ventana);
		servidorEscuchaMensajeCliente.start();
		
		
	}

}
