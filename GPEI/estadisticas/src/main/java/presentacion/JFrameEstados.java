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

public class JFrameEstados extends JFrame {
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	
	ArrayList<String> nEnfermedadesEstado =  new ArrayList<String>();
	ArrayList<String> nPersonasEstado =  new ArrayList<String>();
	
	public JFrameEstados() {
		setTitle("Personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Mostrar número de personas en cada estado
		JLabel lblTituloPersonas = new JLabel("Personas en cada estado");
		lblTituloPersonas.setFont(new Font(null, Font.PLAIN, 16));
		lblTituloPersonas.setBounds(150, 37, 350, 30);
		contentPane.add(lblTituloPersonas);

		String [] columnasPersonas = {"Estado", "Nº Personas"};
		String [][] datosPersonas = new String[4][2];
		
		ArrayList<String> estadisticaPersonas = Estadisticas.estadoPersona();
		int j = 0;
		
		for (int i = 0; i < datosPersonas.length; i++) {
			datosPersonas[i][0] = estadisticaPersonas.get(j++);
			datosPersonas[i][1] = estadisticaPersonas.get(j++);
		}
		
		JScrollPane scrollPanePersonas = new JScrollPane();
		scrollPanePersonas.setBounds(10, 70, 480, 86);
		getContentPane().add(scrollPanePersonas);
		table = new JTable(datosPersonas, columnasPersonas);
		model = new DefaultTableModel(datosPersonas, columnasPersonas);
		scrollPanePersonas.setViewportView(table);
		table.setRowSelectionInterval(0, 0);
		
		//Mostrar número de enfermedades por estado
		JLabel lblTituloEnfermedades = new JLabel("Enfermedades en cada estado");
		lblTituloEnfermedades.setFont(new Font(null, Font.PLAIN, 16));
		lblTituloEnfermedades.setBounds(150, 200, 350, 30);
		contentPane.add(lblTituloEnfermedades);
		
		String [] columnasEnfermedades = {"Estado", "Nº Enfermedades"};
		String [][] datosEnfermedades = new String[3][2];
		
		ArrayList<String> estadisticaEnfermedades = Estadisticas.estadoEnfermedad();
		j = 0;
		
		for (int i = 0; i < datosEnfermedades.length; i++) {
			datosEnfermedades[i][0] = estadisticaEnfermedades.get(j++);
			datosEnfermedades[i][1] = estadisticaEnfermedades.get(j++);
		}
		
		JScrollPane scrollPaneEnfermedades = new JScrollPane();
		scrollPaneEnfermedades.setBounds(10, 230, 480, 70);
		getContentPane().add(scrollPaneEnfermedades);
		table = new JTable(datosEnfermedades, columnasEnfermedades);
		model = new DefaultTableModel(datosEnfermedades, columnasEnfermedades);
		scrollPaneEnfermedades.setViewportView(table);
		table.setRowSelectionInterval(0, 0);
	}
}
