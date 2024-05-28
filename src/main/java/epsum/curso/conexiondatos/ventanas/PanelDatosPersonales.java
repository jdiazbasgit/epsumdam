package epsum.curso.conexiondatos.ventanas;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;
import epsum.curso.conexiondatos.servicios.HijoService;
import lombok.Data;

@Data
public class PanelDatosPersonales extends PanelComponente {
	@Autowired
	private DatosPersonalesService datosPersonalesService;
	
	private Object[] cabeceras;

	private Object[][] datos;

	private String titulo;
	
	@Autowired
	private EstadoCivilService estadoCivilService;
	@Autowired
	private HijoService hijoService;
	
	private JComboBox<EstadoCivil> jComboBoxEstadoCivil;
	
	private JComboBox<Hijo> jComboBoxHijo;

	public PanelDatosPersonales(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}

	@Override
	public void alta() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		jComboBoxEstadoCivil = new JComboBox<EstadoCivil>();
		jComboBoxHijo = new JComboBox<Hijo>();
		List<EstadoCivil> estadosCiviles = (List<EstadoCivil>) getEstadoCivilService().findAll();
		List<Hijo> hijos = (List<Hijo>) getHijoService().findAll();
		for (EstadoCivil estadoCivil : estadosCiviles ) {
			jComboBoxEstadoCivil.addItem(estadoCivil);

	}
		for (Hijo hijo : hijos) {
			jComboBoxHijo.addItem(hijo);
		}
		Object[] datos = { "0", jComboBoxEstadoCivil, jComboBoxHijo };
	}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		getDatosPersonalesService().deleteById(id);
		 DefaultTableModel defaultTableModel=(DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());

	}

	@Override
	public void modificar() {
		for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
			DatoPersonal datoPersonal = new DatoPersonal();
			datoPersonal.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
			datoPersonal.setEstadoCivil((EstadoCivil) getTabla().getModel().getValueAt(i, 2));
			datoPersonal.setHijo((Hijo) getTabla().getModel().getValueAt(i, 2));
			getDatosPersonalesService().save(datoPersonal);
			DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			defaultTableModel.setValueAt(String.valueOf(datoPersonal.getId()), i, 0);
		}
			
	}

}

