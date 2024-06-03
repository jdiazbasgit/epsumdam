package epsum.curso.conexiondatos.configuracion;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import epsum.curso.conexiondatos.entidades.Cargo;


public class ComboBoxCargos extends JComboBox<Cargo> {

	public ComboBoxCargos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComboBoxCargos(Cargo[] items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxCargos(ComboBoxModel<Cargo> aModel) {
		super(aModel);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxCargos(Vector<Cargo> items) {
		super(items);
		// TODO Auto-generated constructor stub
	}
	
	

}
