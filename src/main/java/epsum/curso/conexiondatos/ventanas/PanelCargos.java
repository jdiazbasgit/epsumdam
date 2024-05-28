package epsum.curso.conexiondatos.ventanas;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.repositorios.CargoCrudRepository;
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

	        try {
				getCargoService().deleteById(id);
				JOptionPane.showMessageDialog(null, "Registro borrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				 DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			     defaultTableModel.removeRow(getTabla().getSelectedRow());
			} catch (Exception e) {	
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Registro no se ha podido borrar", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} 

	       
	    }
	}
	
	
	@Override
	public void modificar() {
	    try {
	        for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
	            Cargo cargo = new Cargo();
	            cargo.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
	            cargo.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));
	            
	         //Aqui intenta guardarlo:
	            getCargoService().save(cargo);
	            DefaultTableModel defaultTableModel= (DefaultTableModel) getTabla().getModel();
	            defaultTableModel.setValueAt(String.valueOf(cargo.getId()), i, 0);
	        }
	        JOptionPane.showMessageDialog(null, "Las modificaciones fueron exitosas", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    
	    } catch (DuplicateKeyException e) {
	        JOptionPane.showMessageDialog(null, "Error: Clave duplicada. No se puede guardar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	        
	    } catch (DataIntegrityViolationException e) {
	        JOptionPane.showMessageDialog(null, "Error: Violación de integridad. Verifique los datos.", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	        
	    }catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Hubo un problema al modificar los datos", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	    }
	}
}
