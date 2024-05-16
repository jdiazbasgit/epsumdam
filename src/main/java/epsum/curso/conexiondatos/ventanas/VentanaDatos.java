package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;
import lombok.Data;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.servicios.EmpleadoService;

import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.servicios.HijoService;
import lombok.Data;

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.entidades.DatoPersonal;

@Component
//@Data
public class VentanaDatos extends JFrame implements WindowListener, ActionListener {

	@Autowired
	private CargoService cargoService;
	@Autowired
	private EstadoCivilService estadoCivilService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private HijoService hijoService;
	@Autowired
	private DatoLaboralService datoLaboralService;
	@Autowired
	private DatosPersonalesService datosPersonalesService;
	@Autowired
	private PanelCargos panelCargos;
	@Autowired
<<<<<<< HEAD
	private PanelEmpleado panelEmpleado;
	
=======
	private PanelEmpresas panelEmpresas;
  @Autowired
>>>>>>> origin/springjpa
	private PanelHijos panelHijos;
	@Autowired
	private PanelDatosLaborales panelDatosLaborales;
  @Autowired
	private PanelEstadosCiviles panelEstadosCiviles;

	
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
	private JButton modificar, borrar;
	public DatosPersonalesService getDatosPersonalesService() {
		return datosPersonalesService;
	}

	public void setDatosPersonalesService(DatosPersonalesService datosPersonalesService) {
		this.datosPersonalesService = datosPersonalesService;
	}

	

	public VentanaDatos() {
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(this);
		menuBar = new JMenuBar();
		menu = new JMenu("opciones");
		empresas = new JMenuItem("empresas");
		hijos = new JMenuItem("hijos");
		estadosCiviles = new JMenuItem("estados civiles");
		cargos = new JMenuItem("cargos");
		salir = new JMenuItem("salir");
		cargos.addActionListener(this);
		estadosCiviles.addActionListener(this);
		empresas.addActionListener(this);
		hijos.addActionListener(this);
		datosPersonales = new JMenuItem("datos personales");
		datosPersonales.addActionListener(this);
		datosLaborales = new JMenuItem("datos laborales");
		datosLaborales.addActionListener(this);
		salir.addActionListener(this);
		empleados = new JMenuItem("empleados");
		empleados.addActionListener(this);
		
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
		modificar = new JButton("MODIFICAR");
		borrar = new JButton("BORRAR");
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
		if (e.getSource().equals(datosPersonales)) {
			getContentPane().removeAll();
			Object[] cabeceras = { "ID", "ESTADOCIVIL", "NUMEROHIJOS", };
			List<DatoPersonal> datosPersonales = (List<DatoPersonal>) datosPersonalesService.findAll();
			Object[][] datos = new Object[(int) datosPersonalesService.count()][3];
			int i = 0;
			for (DatoPersonal datoPersonal : datosPersonales) {
				datos[i][0] = String.valueOf(datoPersonal.getId());
				datos[i][1] = datoPersonal.getEstadoCivil().getDescripcion();
				datos[i][2] = datoPersonal.getHijo().getChicos() + " - " + datoPersonal.getHijo().getChicas();
				i++;

			}
			getContentPane().add(new PanelDatosPersonales(cabeceras, datos, "DATOS PERSONALES"));
			this.show();
		}
		if (e.getSource().equals(estadosCiviles)) {
			getContentPane().removeAll();
			Object[] cabeceras = { "ID", "DESCRIPCION" };
			List<EstadoCivil> estadosCiviles = (List<EstadoCivil>) getEstadoCivilService().findAll();
			Object[][] datos = new Object[(int) getEstadoCivilService().count()][2];
			int i = 0;
			for (EstadoCivil estadoCivil : estadosCiviles) {
				datos[i][0] = String.valueOf(estadoCivil.getId());
				datos[i][1] = estadoCivil.getDescripcion();

				i++;

			}
			
			getContentPane().add(getPanelEstadosCiviles());
			this.show();
		}

		if (e.getSource().equals(empleados)) {
			getContentPane().removeAll();
			getContentPane().add(panelEmpleado);
			this.show();

		}

		if (e.getSource().equals(hijos)) {
			getContentPane().removeAll();
			
			getContentPane().add(panelHijos);
			
			this.show();
		}
		if (e.getSource().equals(datosLaborales)) {
			getContentPane().removeAll();
			
			getContentPane().add(panelDatosLaborales);
			
			this.show();
		}

		if (e.getSource().equals(empresas)) {
			getContentPane().removeAll();
			Object[] cabeceras = { "ID", "NOMBRE", "CIF" };
			List<Empresa> empresas = (List<Empresa>) getEmpresaService().findAll();
			Object[][] datos = new Object[(int) getEmpresaService().count()][3];
			int i = 0;
			for (Empresa empresa : empresas) {
				datos[i][0] = String.valueOf(empresa.getId());
				datos[i][1] = empresa.getNombre();
				datos[i][2] = empresa.getCif();
				i++;

			}
			;
			getContentPane().add(panelEmpresas);
			this.show();
		}
		if(e.getSource().equals(salir)) {
			JDialog dialog= new JDialog();
			dialog.setSize(500,500);
			dialog.setLocation(200,200);
			dialog.setVisible(true);
			dialog.add(new Label("soy un texto en el dialog"),BorderLayout.NORTH);
			JButton boton= new JButton("cerrar");
			dialog.add(boton);
			boton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.setVisible(false);
					//System.exit(0);
					
				}
			});
		}
	}

	public EstadoCivilService getEstadoCivilService() {
		return estadoCivilService;
	}

	public void setEstadoCivilService(EstadoCivilService estadoCivilService) {
		this.estadoCivilService = estadoCivilService;
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

	public EmpresaService getEmpresaService() {
		return empresaService;
	}

	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	public HijoService getHijoService() {
		return hijoService;
	}

	public void setHijoService(HijoService hijoService) {
		this.hijoService = hijoService;
	}

	public PanelEstadosCiviles getPanelEstadosCiviles() {
		return panelEstadosCiviles;
	}

	public void setPanelEstadosCiviles(PanelEstadosCiviles panelEstadosCiviles) {
		this.panelEstadosCiviles = panelEstadosCiviles;
	}
}
