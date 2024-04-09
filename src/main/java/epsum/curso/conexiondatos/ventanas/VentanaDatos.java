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

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;

@Component

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
	private Panel panelCargos;
	private Choice choice;

	public VentanaDatos() {
		//setSize(1000, 1000);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setResizable(false);
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
		choice = new Choice();
		panelCargos = new Panel();
		panelCargos.add(choice);

	}

	@Override
	public void paint(Graphics g) {
		if (!primeraVez) {

			Iterable<Cargo> cargos = cargoService.findAll();
			for (Cargo cargo : cargos) {
				choice.add(cargo.getDescripcion());
			}

			primeraVez = true;
		}
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
			getContentPane().add(panelCargos);
			this.show();
		}

	}
}
