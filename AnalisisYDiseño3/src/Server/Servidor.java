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
	int PortMonitor = 1234;
	int PortVendedor = 4400;
	
	public Servidor() {
		super();
		ListaTurnos = new ArrayList<Turno>();
			
	}
	
	public void StartServidorVentanaCliente(){
		
		 try {
			 ServerSocket serverSocket = new ServerSocket(5000);
			 while (true) {
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
