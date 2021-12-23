package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Estadisticas;

public class JFrameEnfCatalogadas extends JFrame {
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	
	ArrayList<String> nEnfermedadesEstado =  new ArrayList<String>();
	ArrayList<String> nPersonasEstado =  new ArrayList<String>();
	
	public JFrameEnfCatalogadas() {
		setTitle("Personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Mostrar número de enfermedades catalogadas
		
		int nEnfermedades = Estadisticas.nEnfCatalogadas();
		
		JLabel lblTituloPersonas = new JLabel("Número de enfermedades catalogadas: "+nEnfermedades);
		lblTituloPersonas.setFont(new Font(null, Font.PLAIN, 16));
		lblTituloPersonas.setBounds(150, 37, 350, 30);
		contentPane.add(lblTituloPersonas);
	}
}
