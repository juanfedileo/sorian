package Cliente;
import Server.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaCliente ClienteVista;
		VentanaMonitor MonitorVista;
		VentanaVendedor VendedorVista;
		int puertoCliente = 5000;
		int puertoVendedor = 4400;
		int puertoMonitor = 1234;
		Servidor ServerCliente;
		Servidor ServerMonitor;
		Servidor ServerVendedor;
	
		ClienteVista = new VentanaCliente();
		MonitorVista = new VentanaMonitor();
		VendedorVista = new VentanaVendedor();

		ClienteVista.setVisible(true);
		MonitorVista.setVisible(true);
		VendedorVista.setVisible(true);	


		ServerCliente = new Servidor(puertoCliente);
		ServerMonitor = new Servidor(puertoMonitor);
		ServerVendedor = new Servidor(puertoVendedor);
		
		ServerCliente.StartServidorCliente();
		ServerMonitor.StartServidorMonitor();
		ServerVendedor.StartServidorVendedor();
		
	}

}
