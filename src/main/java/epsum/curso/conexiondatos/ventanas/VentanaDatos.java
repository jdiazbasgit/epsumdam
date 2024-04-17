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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;
import lombok.Data;

@Component
//@Data
public class VentanaDatos extends JFrame implements WindowListener, ActionListener {

	@Autowired
	private CargoService cargoService;
	private boolean primeraVez;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem empresas;
	private JMenuItem hijos;
	private JMenuItem estadosCiviles;
	private JMenuItem cargos;
	private JMenuItem datosLaborales;
	private JMenuItem datosPersonales;
	private JMenuItem empleados;
	private JMenuItem salir;
	private JButton modificar,borrar;

	public VentanaDatos() {
		// setSize(1000, 1000);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setResizable(false);
		this.addWindowListener(this);
		// (new FlowLayout());
		menuBar = new JMenuBar();
		menu = new JMenu("opciones");
		empresas = new JMenuItem("empresas");
		hijos = new JMenuItem("hijos");
		estadosCiviles = new JMenuItem("estados civiles");
		cargos = new JMenuItem("cargos");
		cargos.addActionListener(this);
		datosLaborales = new JMenuItem("datos laborales");
		datosPersonales = new JMenuItem("datos personales");
		empleados = new JMenuItem("empleados");
		salir = new JMenuItem("salir");
		setJMenuBar(menuBar);
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
			Object[] cabeceras = { "ID", "DESCRIPCION" };
			List<Cargo> cargos = (List<Cargo>) cargoService.findAll();
			Object[][] datos = new Object[(int) cargoService.count()][3];
			int i = 0;
			for(Cargo cargo:cargos)
			 {
				datos[i][0]=String.valueOf(cargo.getId());
				datos[i][1]=cargo.getDescripcion();
				
				i++;
				
			};
			getContentPane().add(new PanelCargos(cabeceras, datos, "CARGOS"));
			this.show();
		}

	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public boolean isPrimeraVez() {
		return primeraVez;
	}

	public void setPrimeraVez(boolean primeraVez) {
		this.primeraVez = primeraVez;
	}


	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public JMenuItem getEmpresas() {
		return empresas;
	}

	public void setEmpresas(JMenuItem empresas) {
		this.empresas = empresas;
	}

	public JMenuItem getHijos() {
		return hijos;
	}

	public void setHijos(JMenuItem hijos) {
		this.hijos = hijos;
	}

	public JMenuItem getEstadosCiviles() {
		return estadosCiviles;
	}

	public void setEstadosCiviles(JMenuItem estadosCiviles) {
		this.estadosCiviles = estadosCiviles;
	}

	public JMenuItem getCargos() {
		return cargos;
	}

	public void setCargos(JMenuItem cargos) {
		this.cargos = cargos;
	}

	public JMenuItem getDatosLaborales() {
		return datosLaborales;
	}

	public void setDatosLaborales(JMenuItem datosLaborales) {
		this.datosLaborales = datosLaborales;
	}

	public JMenuItem getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(JMenuItem datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public JMenuItem getEmpleados() {
		return empleados;
	}

	public void setEmpleados(JMenuItem empleados) {
		this.empleados = empleados;
	}

	public JMenuItem getSalir() {
		return salir;
	}

	public void setSalir(JMenuItem salir) {
		this.salir = salir;
	}

	public JButton getModificar() {
		return modificar;
	}

	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}
}
