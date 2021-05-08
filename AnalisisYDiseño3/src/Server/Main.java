package Server;
import Cliente.VentanaCliente;
import Cliente.VentanaMonitor;
import Cliente.VentanaVendedor;
import Cliente.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaCliente ClienteVista;
		VentanaMonitor MonitorVista;
		VentanaVendedor VendedorVista;
		Controlador control;
		control = new Controlador();
		ClienteVista = new VentanaCliente();
		MonitorVista = new VentanaMonitor();
		VendedorVista = new VentanaVendedor();
		ClienteVista.setControl(control);
		MonitorVista.setControl(control);
		VendedorVista.setControl(control);
		ClienteVista.setVisible(true);
		MonitorVista.setVisible(true);
		VendedorVista.setVisible(true);
	}

}
