package epsum.curso.chat.ventanas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ElQueSabeLoQueHayQueHacerConLaVentana extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
