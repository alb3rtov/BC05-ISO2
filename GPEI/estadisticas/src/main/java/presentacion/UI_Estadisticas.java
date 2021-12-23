package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Estadisticas;
import presentacion.JFrameEstados;

public class UI_Estadisticas extends JFrame {
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	JComboBox<String> cbEstadistica;
	
	/* Main function */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Estadisticas frame = new UI_Estadisticas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UI_Estadisticas() {
		setTitle("Estadísticas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Menu estadísticas");
		lblTitulo.setFont(new Font(null, Font.PLAIN, 16));
		lblTitulo.setBounds(150, 37, 150, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblEstadistica = new JLabel("Estadística: ");
		lblEstadistica.setBounds(110, 85, 250, 30);
		contentPane.add(lblEstadistica);
		
		cbEstadistica =new JComboBox<String>();
		cbEstadistica.addItem("1. Nº Enfermedades y personas por estado");
		cbEstadistica.addItem("2. Nº de enfermedades catalogadas");
		cbEstadistica.addItem("3. Nº de campañas informativas/enfrmedad");
		cbEstadistica.setBounds(110, 110, 400, 28);
        contentPane.add(cbEstadistica);
        
        final JButton btnBuscarEstados = new JButton("Listar estadísticas");
        
        btnBuscarEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selection = String.valueOf(cbEstadistica.getSelectedItem());
				
				if(selection.equals("1. Nº Enfermedades y personas por estado")) {
					JFrameEstados frameEstados = new JFrameEstados();
					frameEstados.setVisible(true);
				} else if(selection.equals("2. Nº de enfermedades catalogadas")) {
					JFrameEnfCatalogadas frameEnfCatalogadas = new JFrameEnfCatalogadas();
					frameEnfCatalogadas.setVisible(true);
				} else if(selection.equals("3. Nº de campañas informativas/enfrmedad")) {
					JFrameCampaniasEnf frameCampanias = new JFrameCampaniasEnf();
					frameCampanias.setVisible(true);
				}
				
		        /*switch (selection) {
				case "1. Nº Enfermedades y personas por estado":
					JFrameEstados frameEstados = new JFrameEstados();
					frameEstados.setVisible(true);
					break;
				case "2. Nº de enfermedades catalogadas":
					JFrameEnfCatalogadas frameEnfCatalogadas = new JFrameEnfCatalogadas();
					frameEnfCatalogadas.setVisible(true);
					break;
				case "3. Nº de campañas informativas/enfrmedad":
					JFrameCampaniasEnf frameCampanias = new JFrameCampaniasEnf();
					frameCampanias.setVisible(true);
					break;
				default:
					break;
				}*/
			}
		});
		
		btnBuscarEstados.setBounds(110, 140, 400, 40);
		contentPane.add(btnBuscarEstados);
	}
}
