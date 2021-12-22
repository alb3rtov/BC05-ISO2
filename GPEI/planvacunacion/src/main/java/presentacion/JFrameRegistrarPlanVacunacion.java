package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dominio.GestorPlanPersona;

public class JFrameRegistrarPlanVacunacion extends JFrame {
	
	private JPanel contentPane;
	JComboBox<String> cbEnfermedades;
	private JTextPane textPane;
	ArrayList<String> enfermedades =  new ArrayList<String>();
	
	public JFrameRegistrarPlanVacunacion() {
		setTitle("Registrar plan de vacunacion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblRegistrarPlan = new JLabel("Registrar plan de vacunacion");
		lblRegistrarPlan.setFont(new Font(null, Font.PLAIN, 16));
		lblRegistrarPlan.setBounds(90, 20, 250, 30);
		contentPane.add(lblRegistrarPlan);
		
		JLabel lblEnfermedades= new JLabel("Enfermedades con vacunas disponibles: ");
		lblEnfermedades.setBounds(20, 60, 250, 30);
		contentPane.add(lblEnfermedades);
		
		try {
			enfermedades = GestorPlanPersona.buscasrEnfermedadesVacunas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cbEnfermedades =new JComboBox<String>();
		
		for (int i = 0; i < enfermedades.size(); i++) {
			cbEnfermedades.addItem(enfermedades.get(i));
		}
		
        cbEnfermedades.setBounds(20, 100, 134, 28);
        contentPane.add(cbEnfermedades);
       
		JButton btnlRegistrarPlan = new JButton("Registrar");
		btnlRegistrarPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean registrado = false;
				
				try {
					registrado = GestorPlanPersona.registrarPlan(String.valueOf(cbEnfermedades.getSelectedItem()));
				}catch (Exception e) {
					textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
				}
				
				if (registrado) {
					textPane.setText("Plan añadido");
				} else {
					textPane.setText("Ha ocurrido un error durante la inserción");
				}
				
			}
		});
		
		btnlRegistrarPlan.setBounds(230, 100, 120, 30);
		contentPane.add(btnlRegistrarPlan);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 150, 407, 30);
		contentPane.add(textPane);
		
	}
}