package epsum.curso.conexiondatos.configuracion;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.Empresa;

public class ComboBoxDatosLaborales extends JComboBox<DatoLaboral> {

	public ComboBoxDatosLaborales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComboBoxDatosLaborales(DatoLaboral[] items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxDatosLaborales(ComboBoxModel<DatoLaboral> aModel) {
		super(aModel);
		// TODO Auto-generated constructor stub
	}

	public ComboBoxDatosLaborales(Vector<DatoLaboral> items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

}
