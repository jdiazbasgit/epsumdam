package epsum.curso.conexiondatos.ventanas;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.servicios.HijoService;
import lombok.Data;

@Data
public class PanelHijos extends PanelComponente {
	
	@Autowired
	private HijoService hijoService;
	
	private Object[] cabeceras;
	
	private Object[][] datos;
	
	private String titulo;

	public PanelHijos(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void baja() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub

	}

}
