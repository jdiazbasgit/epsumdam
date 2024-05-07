package epsum.curso.conexiondatos.ventanas;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import lombok.Data;

@Data
public class PanelDatosPersonales extends PanelComponente {
	@Autowired
	private DatosPersonalesService datosPersonalesService;
	
	private Object[] cabeceras;

	private Object[][] datos;

	private String titulo;

	public PanelDatosPersonales(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}

	@Override
	public void alta() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		Object[] datos = {"0", ""};
		defaultTableModel.addRow(datos);

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
		for (int i=0; i<getTabla().getModel().getRowCount();i++) {
			DatoPersonal datoPersonal = new DatoPersonal();
			datoPersonal.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i,0)));
			datoPersonal.getEstadoCivil().setDescripcion((String) getTabla().getModel().getValueAt(i,0));
			
	}

}
}
