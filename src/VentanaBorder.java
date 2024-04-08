import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;

public class VentanaBorder extends Frame {

	public VentanaBorder() {
		setSize(500, 500);
		Button b1 = new Button("uno");
		Button b2 = new Button("dos");
		Button b3 = new Button("tres");
		Button b4 = new Button("cuatro");
		Button b5 = new Button("cinco");
		setLayout(new BorderLayout(50,50));
		TextArea textArea= new TextArea(20,10);
		add(textArea,BorderLayout.NORTH);
		add(b2,BorderLayout.SOUTH);
		add(b3,BorderLayout.EAST);
		add(b4,BorderLayout.WEST);
		add(b5,BorderLayout.CENTER);
	}
}
