package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.net.Socket;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Documento;
	private String documentoaux = "";
	private int TurnoID;
	private JTextField textField_Muestrodoc;
	private JTextField textField_MuestroTurno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente frame = new VentanaCliente();
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
	public VentanaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton btnNewButton_11 = new JButton("Pedir Turno");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//ACA SE HACE EL SOCKET
				//TurnoID= control.CreadorTurno(documentoaux);
				textField_Muestrodoc.setText(documentoaux);
				textField_MuestroTurno.setText(""+TurnoID);
				textField_Documento.setText(null);
				documentoaux="";
				
			}
		});
		panel_4.add(btnNewButton_11);
		
		JButton btnNewButton = new JButton("RESET");
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux="";
				textField_Documento.setText(null);
				
				
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		textField_Documento = new JTextField();
		textField_Documento.setEditable(false);
		panel_6.add(textField_Documento);
		textField_Documento.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "1";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "2";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("3");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "3";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "4";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "5";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "6";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "7";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_7);
		
		JButton btnNewButton_9 = new JButton("8");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "8";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("9");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "9";
				textField_Documento.setText(documentoaux);
				
			}
		});
		panel_7.add(btnNewButton_10);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		
		JButton btnNewButton_0 = new JButton("0");
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				documentoaux += "0";
				textField_Documento.setText(documentoaux);
				
				
			}
		});
		panel_7.add(btnNewButton_0);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		Label documento = new Label("NRO DE DOCUMENTO");
		documento.setAlignment(Label.CENTER);
		panel_3.add(documento);
		
		textField_Muestrodoc = new JTextField();
		textField_Muestrodoc.setEditable(false);
		panel_3.add(textField_Muestrodoc);
		textField_Muestrodoc.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		Label turno = new Label("TURNO");
		turno.setAlignment(Label.CENTER);
		panel_2.add(turno);
		
		textField_MuestroTurno = new JTextField();
		textField_MuestroTurno.setEditable(false);
		panel_2.add(textField_MuestroTurno);
		textField_MuestroTurno.setColumns(10);
	}
	
}
