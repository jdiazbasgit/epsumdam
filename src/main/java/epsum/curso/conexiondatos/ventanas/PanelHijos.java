package epsum.curso.conexiondatos.ventanas;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;

import javax.swing.JOptionPane;

import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.servicios.HijoService;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode(callSuper=false)
public class PanelHijos extends PanelComponente {
	
	@Autowired
	private HijoService hijoService;
	
	private String[] cabeceras;
	
	private Object[][] datos;
	
	private String titulo;

	private int i;
	
	/*
	@Override
	public void setBotonBorrarToolTip(String text) {
		// TODO Auto-generated method stub
		super.setBotonBorrarToolTip("Para borrar un registro seleccione la fila que desea eliminar y después pulse el botón BORRAR");
	}
	*/

	public PanelHijos(String[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
		// TODO Auto-generated constructor stub
	}

	 @Override
	    public void alta() {
		 
		 int confirmation = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
		 
		 if (confirmation == JOptionPane.YES_OPTION) {
			try {
				JOptionPane.showMessageDialog(null, "Introduzca el número de hijos/hijas del registro. Después pulse el botón gabar", "Información", JOptionPane.INFORMATION_MESSAGE);
				
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				 Object[] datos = {"0", ""};
				 defaultTableModel.addRow(datos);
				
				 //JOptionPane.showMessageDialog(null, "Registro agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				 
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	 }
	 
	@Override
	public void baja() {
		
		try {
			int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
			//confirmacion de borrado
			JOptionPane jOptionPane=new JOptionPane("Estas seguro?");
			jOptionPane.setSize(300,300);
			jOptionPane.setLocation(100, 100);
			int confirmation = JOptionPane.showConfirmDialog(null, "¿De verdad quieres borrar?", "Confirmación", JOptionPane.YES_NO_OPTION);
			
			if (confirmation == JOptionPane.YES_OPTION) {
				try {
					getHijoService().deleteByID(id);
					JOptionPane.showMessageDialog(null, "Registro borrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					 DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				     defaultTableModel.removeRow(getTabla().getSelectedRow());
				} catch (Exception e) {	
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Registro no se ha podido borrar", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Seleccione primero el registro que desea borrar", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void modificar() {
		for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
			Hijo hijo = new  Hijo();
			hijo.setId(Integer.parseInt((String)getTabla().getModel().getValueAt(i, 0)));
			hijo.setChicos(Integer.parseInt((String)getTabla().getModel().getValueAt(i, 1)));
			hijo.setChicas(Integer.parseInt((String)getTabla().getModel().getValueAt(i, 2)));
			getHijoService().save(hijo);	
		}
		JOptionPane.showMessageDialog(null, "Registro agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}

}
