package epsum.curso.conexiondatos.ventanas;

import java.awt.Choice;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;
import lombok.Data;

@Component
@Data
public class VentanaDatos extends JFrame implements WindowListener, ActionListener {

	@Autowired
	private CargoService cargoService;
	private boolean primeraVez;
	private MenuBar menuBar;
	private Menu menu;
	private MenuItem empresas;
	private MenuItem hijos;
	private MenuItem estadosCiviles;
	private MenuItem cargos;
	private MenuItem datosLaborales;
	private MenuItem datosPersonales;
	private MenuItem empleados;
	private MenuItem salir;
	private JButton modificar,borrar;

	public VentanaDatos() {
		// setSize(1000, 1000);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setResizable(false);
		this.addWindowListener(this);
		// (new FlowLayout());
		menuBar = new MenuBar();
		menu = new Menu("opciones");
		empresas = new MenuItem("empresas");
		hijos = new MenuItem("hijos");
		estadosCiviles = new MenuItem("estados civiles");
		cargos = new MenuItem("cargos");
		cargos.addActionListener(this);
		datosLaborales = new MenuItem("datos laborales");
		datosPersonales = new MenuItem("datos personales");
		empleados = new MenuItem("empleados");
		salir = new MenuItem("salir");
		setMenuBar(menuBar);
		menu.add(empresas);
		menu.add(cargos);
		menu.add(estadosCiviles);
		menu.add(datosLaborales);
		menu.add(datosPersonales);
		menu.add(empleados);
		menu.add(hijos);
		menu.addSeparator();
		menu.add(salir);
		menuBar.add(menu);
		modificar= new JButton("MODIFICAR");
		borrar= new JButton("BORRAR");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cargos)) {
			getContentPane().removeAll();
			String[] cabeceras = { "ID", "DESCRIPCION", "ACCIONES" };
			List<Cargo> cargos = (List<Cargo>) getCargoService().findAll();
			Object[][] datos = new Object[2][(int) getCargoService().count()];
			int i = 0;
			cargos.stream().forEach(c -> {
				datos[i][0]=String.valueOf(c.getId());
				datos[i][1]=c.getDescripcion();
				JPanel panel= new JPanel();
				datos[i][3]=panel;
				panel.add(modificar);
				panel.add(borrar);
				
			});
			getContentPane().add(new PanelCargos(cabeceras, datos, "CARGOS"));
			this.show();
		}

	}
}
