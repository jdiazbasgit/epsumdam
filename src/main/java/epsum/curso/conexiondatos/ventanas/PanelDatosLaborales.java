package epsum.curso.conexiondatos.ventanas;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PanelDatosLaborales extends PanelComponente {
	
	@Autowired
	private DatoLaboralService datolaboralService;
	
	private Object[] cabeceras;
	
	private Object[][] datos;
	
	private String titulo;

	private int i;

	public PanelDatosLaborales(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
		// TODO Auto-generated constructor stub
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
		getDatolaboralService().deleteById(id);
		 DefaultTableModel defaultTableModel=(DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());
	}

	@Override
	public void modificar() {
		for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
			DatoLaboral datolaboral = new  DatoLaboral();
			datolaboral.setId(Integer.parseInt((String)getTabla().getModel().getValueAt(i, 0)));
			datolaboral.setSalario(Integer.parseInt((String)getTabla().getModel().getValueAt(i, 1)));
			datolaboral.setCargo(getTabla().getModel().getValueAt(i, 2));
			getDatolaboralService().save(datolaboral);
		}
	}

}
