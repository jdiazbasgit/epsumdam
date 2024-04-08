import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class VentanaGridBag extends Frame {

	public VentanaGridBag() {
		setSize(500, 500);
		Button b1 = new Button("uno");
		Button b2 = new Button("dos");
		
		setLayout(new GridBagLayout());
		GridBagConstraints restrincciones1= new GridBagConstraints();
		restrincciones1.gridx=0;
		restrincciones1.gridy=0;
		restrincciones1.gridwidth=1;
		restrincciones1.gridheight=1;
		//restrincciones1.fill=GridBagConstraints.BOTH;
		restrincciones1.anchor=GridBagConstraints.NORTHWEST;
		restrincciones1.weightx=1;
		restrincciones1.weighty=1;
		restrincciones1.ipadx=50;
		restrincciones1.ipady=50;
		//Insets insets= new Insets(0, 100, 0, 0);
		restrincciones1.insets=new Insets(0, 100, 0, 0);
		
		GridBagConstraints restricciones2= new GridBagConstraints();
		
		restricciones2.gridx=1;
		restricciones2.gridy=1;
		//restricciones2.fill=GridBagConstraints.BOTH;
		//restricciones2.gridheight=1;
		//restricciones2.gridwidth=1;
		
		add(b1,restrincciones1);
		add(b2,restricciones2);
		
	}
}
