package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelEmpresas extends PanelComponente {

	public PanelEmpresas(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}
	
	private JDialog dialogoAlta;
	private JPanel pArriba, pCentro;
	private JLabel lNombre, lCif, lTitulo;
	private JTextField tfNombre, tfCif;
	private JButton bAlta;
	
	@Override
	public void alta() {
		dialogoAlta = new JDialog();
		dialogoAlta.setSize(500, 300);
		dialogoAlta.setLocationRelativeTo(null);
		
		dialogoAlta.setLayout(new BorderLayout());
		
		//Panel para título
		pArriba = new JPanel();
		lTitulo = new JLabel("Datos necesarios");
		pArriba.add(lTitulo);
		dialogoAlta.add(pArriba, BorderLayout.NORTH);
		
		//Panel para los datos
		pCentro = new JPanel();
		pCentro.setLayout(new FlowLayout());
		lNombre = new JLabel("Nombre de la empresa:");
		tfNombre = new JTextField();
		tfNombre.setColumns(25);
		lCif = new JLabel("CIF de la empresa:");
		tfCif = new JTextField();
		tfCif.setColumns(10);
		bAlta = new JButton("Dar de alta");
		bAlta.setSize(200, 200);
		pCentro.add(lNombre);
		pCentro.add(tfNombre);
		pCentro.add(lCif);
		pCentro.add(tfCif);
		pCentro.add(bAlta);
		dialogoAlta.add(pCentro, BorderLayout.CENTER);
		
		//hacerlo visible
		dialogoAlta.setVisible(true);
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
