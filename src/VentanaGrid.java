import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

public class VentanaGrid extends Frame {

	public VentanaGrid() {
		setSize(500, 500);
		Button b1 = new Button("uno");
		Button b2 = new Button("dos");
		Button b3 = new Button("tres");
		Button b4 = new Button("cuatro");
		Button b5 = new Button("cinco");
		setLayout(new GridLayout(2,3,50,50));
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
	}
}
