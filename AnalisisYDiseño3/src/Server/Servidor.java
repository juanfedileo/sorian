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
	int Port;
	GestorTurnos Gestor;
	
	public Servidor(int Port, GestorTurnos Gestor) {
		super();
		this.Gestor = Gestor;
		this.Port = Port;

	}
	
	public void StartServidorCliente(){
		 
			 
			 	try {
				 		ServerSocket serverSocketCliente  = new ServerSocket(5000);
				 		while(Port == 5000) {
				 		Socket socket = serverSocketCliente.accept();
				 		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				 		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
				 		String DNI = in.readLine();
						int turnoID = Gestor.CreadorTurno(DNI);
						out.println(turnoID);
							socket.close();
							serverSocketCliente.close();
						}
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				} 
			 

	}
	
	public void StartServidorMonitor(){
		 
		 
	 	try {
		 		ServerSocket serverSocket  = new ServerSocket(1234);
		 		while(Port == 1234) {
			 		Socket socket = serverSocket.accept();
			 		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			 		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
			 		
			 		//String DNI = in.readLine();
					//int turnoID = CreadorTurno(DNI);
					//out.println(turnoID);
					socket.close();
				}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
	 

}
	
	public void StartServidorVendedor() {
			
	 		Turno SiguienteTurno;
			 try {
				 ServerSocket serverSocketVendedor = new ServerSocket(4949);
				 while (Port == 4949) {
					 
					 Socket socket = serverSocketVendedor.accept();
					 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					 
					 SiguienteTurno = Gestor.getNextTurn();
					 
					 if (SiguienteTurno == null){
						 
						 String DNI = SiguienteTurno.getDNI();
						 out.println(DNI);
						 out.println(SiguienteTurno.getTurnoID());
					 }
					 socket.close();
					 serverSocketVendedor.close();
				 }
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		
	}
	
	
	
}
