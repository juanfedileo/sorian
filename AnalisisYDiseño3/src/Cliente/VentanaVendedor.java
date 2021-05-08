package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.net.Socket;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class VentanaVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField TextField_Doc;
	private JTextField TextField_Turno;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVendedor frame = new VentanaVendedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaVendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Tiempo de espera");
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Turno Actual");
		panel_3.add(lblNewLabel_2);
		
		TextField_Turno = new JTextField();
		TextField_Turno.setEditable(false);
		TextField_Turno.setColumns(10);
		panel_3.add(TextField_Turno);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de documento :");
		panel_3.add(lblNewLabel_1);
		
		TextField_Doc = new JTextField();
		TextField_Doc.setEditable(false);
		panel_3.add(TextField_Doc);
		TextField_Doc.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Socket socket = new Socket("localhost",4400);
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					String documento = in.readLine();
					String turnoActual = in.readLine();
					//String fecha = in.readLine();
					
					String TurnoID = in.readLine();
					
					TextField_Doc.setText(documento);
					TextField_Doc.setText(turnoActual);
					socket.close();
					out.close();
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel_1.add(btnNewButton);
	}
	
}
