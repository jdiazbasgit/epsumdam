package epsum.curso.conexiondatos.configuracion;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.Empresa;

public class ComboBoxEmpresas extends JComboBox<Empresa> {

	public ComboBoxEmpresas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComboBoxEmpresas(Empresa[] items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxEmpresas(ComboBoxModel<Empresa> aModel) {
		super(aModel);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxEmpresas(Vector<Empresa> items) {
		super(items);
		// TODO Auto-generated constructor stub
	}
	
}
