package Server;
import java.util.ArrayList;
import Cliente.*;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {
	ArrayList<Turno> ListaTurnos;
	ServerSocket serverCliente;
	ServerSocket serverMonitor;
	ServerSocket serverVendedor;
	int PortCliente = 5000;
	int PortMonitor = 1234;
	int PortVendedor = 4400;
	
	public Servidor() {
		super();
		try {
			ListaTurnos = new ArrayList<Turno>();
			serverCliente = new ServerSocket(PortCliente);
			serverMonitor = new ServerSocket(PortMonitor);
			serverVendedor = new ServerSocket(PortVendedor);
			
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
