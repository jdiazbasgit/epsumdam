package epsum.curso.conexiondatos.ventanas;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;
import lombok.Data;

@Data
public class PanelCargos extends PanelComponente {
	@Autowired
	private CargoService cargoService;

	private Object[] cabeceras;

	private Object[][] datos;

	private String titulo;

	public PanelCargos(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}

	
	@Override
	public void alta() {
		//Aqui es para el dialog:
	    int confirmation = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
	    if (confirmation == JOptionPane.YES_OPTION) {
	    	//funcion del profe:
	        DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
	        Object[] datos = { "0", "" };
	        defaultTableModel.addRow(datos);
	    }
	}
	
	
	@Override
	public void baja() {

	    int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
	    int confirmation = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Confirmación", JOptionPane.YES_NO_OPTION);
	    if (confirmation == JOptionPane.YES_OPTION) {
	        getCargoService().deleteById(id); 
	        DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
	        defaultTableModel.removeRow(getTabla().getSelectedRow());
	    }
	}
	
	
	@Override
	public void modificar() {
	    try {
	        for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
	            Cargo cargo = new Cargo();
	            cargo.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
	            cargo.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));
	            
	            // Intenta guardar el cargo
	            getCargoService().save(cargo);
	            DefaultTableModel defaultTableModel= (DefaultTableModel) getTabla().getModel();
	            defaultTableModel.setValueAt(String.valueOf(cargo.getId()), i, 0);
	        }
	        
	        // Si llega aquí, todas las modificaciones fueron exitosas
	        JOptionPane.showMessageDialog(null, "Las modificaciones fueron exitosas", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception e) {
	        // Si ocurre un error, muestra un mensaje de error
	        JOptionPane.showMessageDialog(null, "Hubo un problema al modificar los datos", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); // Opcional: imprime el error en la consola
	    }
	}
	
//	@Override
//	public void modificar() {
//	    boolean modificacionesRealizadas = false;
//	    try {
//	        for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
//	            Cargo cargo = new Cargo();
//	            cargo.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
//	            cargo.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));
//	            
//	            // Intenta guardar el cargo
//	            if (getCargoService().save(cargo)) {
//	                modificacionesRealizadas = true;
//	            }
//	        }
//	        
//	        if (modificacionesRealizadas) {
//	            JOptionPane.showMessageDialog(null, "Las modificaciones fueron exitosas", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//	        } else {
//	            JOptionPane.showMessageDialog(null, "No se realizaron modificaciones", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//	        }
//	    } catch (Exception e) {
//	        // Si ocurre un error, muestra un mensaje de error
//	        JOptionPane.showMessageDialog(null, "Hubo un problema al modificar los datos", "Error", JOptionPane.ERROR_MESSAGE);
//	        e.printStackTrace(); // Opcional: imprime el error en la consola
//	    }
//	}



}
