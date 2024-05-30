package epsum.curso.conexiondatos.configuracion;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.Empresa;

public class ComboBoxDatosPersonales extends JComboBox<DatoPersonal> {

	public ComboBoxDatosPersonales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComboBoxDatosPersonales(DatoPersonal[] items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxDatosPersonales(ComboBoxModel<DatoPersonal> aModel) {
		super(aModel);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxDatosPersonales(Vector<DatoPersonal> items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

}
