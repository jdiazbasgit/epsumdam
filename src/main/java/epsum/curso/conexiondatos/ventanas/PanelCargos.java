package epsum.curso.conexiondatos.ventanas;

import java.awt.event.ActionEvent;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

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
	    
	    int confirmation = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
	    if (confirmation == JOptionPane.YES_OPTION) {
	        try {
	            
	            String descripcion = JOptionPane.showInputDialog(null, "Introduce la descripción del nuevo cargo:", "Nueva Descripción", JOptionPane.PLAIN_MESSAGE);

	            if (descripcion == null || descripcion.trim().isEmpty()) {
	                throw new IllegalArgumentException("La descripción no puede estar vacía");
	            }
	            
	            DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		        Object[] datos = { "0", descripcion.trim() };
		        defaultTableModel.addRow(datos);

	            JOptionPane.showMessageDialog(null, "Registro agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

	        } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        } 
	    }
	}



	@Override
	public void baja() {

	    int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
	    int confirmation = JOptionPane.showConfirmDialog(null, "¿Estás seguro de borrar el cargo "+getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 1)+"?", "Confirmación", JOptionPane.YES_NO_OPTION);
	    if (confirmation == JOptionPane.YES_OPTION) {

	        try {
				getCargoService().deleteById(id);
				JOptionPane.showMessageDialog(null, "Registro borrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				 DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			     defaultTableModel.removeRow(getTabla().getSelectedRow());
			} catch (DataIntegrityViolationException e) {	
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Registro no se ha podido borrar porque esta en uso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} catch(EmptyResultDataAccessException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "El registro no existe, se va a eliminar", "Error", JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			    defaultTableModel.removeRow(getTabla().getSelectedRow());
			}

	       
	    }
	}
	
	
	@Override
	public void modificar() {
	    int i =0;
	    	try {
	        for ( i = 0; i < getTabla().getModel().getRowCount(); i++) {
	            Cargo cargo = new Cargo();
	            cargo.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
	            cargo.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));
	            

	            getCargoService().save(cargo);
	            DefaultTableModel defaultTableModel= (DefaultTableModel) getTabla().getModel();
	            defaultTableModel.setValueAt(String.valueOf(cargo.getId()), i, 0);
	        }
	        JOptionPane.showMessageDialog(null, "Las modificaciones se realizaron correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    
	        
	        //Quitar la fila donde hay error
	    } catch (DataIntegrityViolationException e) {
	        JOptionPane.showMessageDialog(null, "Error: El cargo ya existe, se va a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	        DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		    defaultTableModel.removeRow(i);
	        
	    }catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Hubo un problema al modificar los datos", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	    }
	}
<<<<<<< HEAD
}
=======
	
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
>>>>>>> springjpa-empleados
