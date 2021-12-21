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

import dominio.GestorPlanPersona;
import dominio.PlanVacunacion;

public class JFrameListarPlanVacunacion extends JFrame {
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	
	ArrayList<PlanVacunacion> planesEncontrados =  new ArrayList<PlanVacunacion>();
	
	public JFrameListarPlanVacunacion() {
		setTitle("Listar personas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanes = new JLabel("Listar planes de vacunacion");
		lblPlanes.setFont(new Font(null, Font.PLAIN, 16));
		lblPlanes.setBounds(140, 10, 250, 30);
		contentPane.add(lblPlanes);
		
		try {
			planesEncontrados = GestorPlanPersona.buscarPlanesVacunacion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<String> enfermedades = new ArrayList<String>();
	
		String [] columnas = {"ID","Enfemerdad"};
		String [][] datos = new String[planesEncontrados.size()][2];
		
		for (int i = 0; i < planesEncontrados.size(); i++) {
			ids.add(planesEncontrados.get(i).getID()+"");
			enfermedades.add(planesEncontrados.get(i).getEnfermedad());
		}
		
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = ids.get(i);
			datos[i][1] = enfermedades.get(i);
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 480, 80);
		getContentPane().add(scrollPane);
		table = new JTable(datos, columnas);
		model = new DefaultTableModel(datos, columnas);
		scrollPane.setViewportView(table);
		table.setRowSelectionInterval(0, 0);
	}
}