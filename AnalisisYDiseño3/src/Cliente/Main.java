package Cliente;
import Server.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaCliente ClienteVista;
		VentanaMonitor MonitorVista;
		VentanaVendedor VendedorVista;
		GestorTurnos TurnosDelDia;
		int puerto = 5000;
		Servidor Server;
		
		ClienteVista = new VentanaCliente();
		MonitorVista = new VentanaMonitor();
		VendedorVista = new VentanaVendedor();
		
		
		ClienteVista.setVisible(true);
		MonitorVista.setVisible(true);
		VendedorVista.setVisible(true);	

		TurnosDelDia = GestorTurnos.getInstance(MonitorVista);
		Server = new Servidor(puerto,TurnosDelDia);
		Server.StartServidor();
		
	}

}
