package epsum.curso.conexiondatos.ventanas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curso.conexiondatos.servicios.CargoService;
import lombok.Data;

@Data
public class PanelCargos extends PanelComponente {

	private CargoService cargoService;
	
	private Object[] cabeceras;
	
	private Object[][] datos;
	
	private String titulo;
	
	public PanelCargos(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}

	@Override
	public void alta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		
		System.err.println(id);
		
		

	}

	@Override
	public void modificar() {
		System.out.println("entro");
	}

}
