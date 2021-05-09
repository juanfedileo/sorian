package Cliente;
import Server.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaCliente ClienteVista;
		VentanaMonitor MonitorVista;
		VentanaVendedor VendedorVista;
		GestorTurnos TurnosDelDia;
		int puertoCliente = 5000;
		int puertoVendedor = 4949;
		int puertoMonitor = 1234;
		Servidor ServerMonitor;
		

		
		ClienteVista = new VentanaCliente();
		MonitorVista = new VentanaMonitor();
		VendedorVista = new VentanaVendedor();

		ClienteVista.setVisible(true);
		MonitorVista.setVisible(true);
		VendedorVista.setVisible(true);	

		TurnosDelDia = GestorTurnos.getInstance();
		ServerMonitor = new Servidor(puertoMonitor,TurnosDelDia);
		
		ServerMonitor.StartServidorMonitor();
		
	}

}
