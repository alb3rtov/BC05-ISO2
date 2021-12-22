package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UI_PlanVacunacion extends JFrame {
	private JPanel contentPane;
	
	/* Main function */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_PlanVacunacion frame = new UI_PlanVacunacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UI_PlanVacunacion() {
		setTitle("Plan vacunacion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Menu planes de vacunaciones");
		lblTitulo.setFont(new Font(null, Font.PLAIN, 16));
		lblTitulo.setBounds(100, 37, 250, 30);
		contentPane.add(lblTitulo);
		
		JButton btnBuscarPersonas = new JButton("Listar planes de vacunaciones");
		btnBuscarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameListarPlanVacunacion frame = new JFrameListarPlanVacunacion();
				frame.setVisible(true);
			}
		});
		
		JButton btnRegistrarPersona= new JButton("Registrar plan de vacunacion");
		btnRegistrarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameRegistrarPlanVacunacion frame = new JFrameRegistrarPlanVacunacion();
				frame.setVisible(true);
			}
		});
		
		btnBuscarPersonas.setBounds(100, 90, 220, 40);
		contentPane.add(btnBuscarPersonas);
		
		btnRegistrarPersona.setBounds(100, 140, 220, 40);
		contentPane.add(btnRegistrarPersona);
	}
}
