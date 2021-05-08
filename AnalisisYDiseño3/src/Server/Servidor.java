package Server;
import java.util.ArrayList;
import Cliente.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	ArrayList<Turno> ListaTurnos;
	int Port;
	
	public Servidor(int Port) {
		super();
		ListaTurnos = new ArrayList<Turno>();
		this.Port = Port;

	}
	
	public void StartServidorCliente(){
		 
			 
			 	try {
				 		ServerSocket serverSocket  = new ServerSocket(5000);
				 		while(Port == 5000) {
				 		Socket socket = serverSocket.accept();
				 		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				 		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
				 		String DNI = in.readLine();
						int turnoID = CreadorTurno(DNI);
						out.println(turnoID);
							socket.close();
						}
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				} 
			 

	}
	
	public void StartServidorVendedor() {
			
	 	
			 try {
				 ServerSocket serverSocket = new ServerSocket();
				 while (Port == 4400) {
					 Socket socket = serverSocket.accept();
					 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					 System.out.println(ListaTurnos.isEmpty());
					 if (ListaTurnos.isEmpty() == false){
						 Turno siguienteTurno = ListaTurnos.get(0);
						 String DNI = siguienteTurno.getDNI();
						 out.println(DNI);
						 out.println(siguienteTurno.getTurnoID());
						 
						 ListaTurnos.remove(0);
					 }
					 socket.close();
				 }
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		
	}
	
	public int CreadorTurno(String DNI) {
		Turno NuevoTurno;
		try {
			NuevoTurno = new Turno(DNI);
			ListaTurnos.add(NuevoTurno);
			return NuevoTurno.getTurnoID();
		}
		catch(TurnoInvalidoException e) {
			//Ventana Error
			return 0;
		}
	}
	
	
}
