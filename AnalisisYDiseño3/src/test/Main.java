package test;
import Vista.*;
import controlador.*;
import Modelo.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaCliente ClienteVista;
		VentanaMonitor MonitorVista;
		VentanaVendedor VendedorVista;
		ClienteVista = new VentanaCliente();
		MonitorVista = new VentanaMonitor();
		VendedorVista = new VentanaVendedor();
		ClienteVista.setVisible(true);
		MonitorVista.setVisible(true);
		VendedorVista.setVisible(true);
	}

}
