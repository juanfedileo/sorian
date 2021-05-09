package Server;

import java.util.ArrayList;
import java.util.Observable;

import Cliente.VentanaMonitor;

public class GestorTurnos extends Observable {

	ArrayList<Turno> listaTurnos;
	private static GestorTurnos instance = null;
	
	private GestorTurnos() {
		listaTurnos = new ArrayList<Turno>();
	}
	
	public static GestorTurnos getInstance(VentanaMonitor o) {
		if (instance == null) {
			instance = new GestorTurnos();
			instance.addObserver(o);
		}
		return instance;
	}
	
	public int CreadorTurno(String DNI) {
		Turno NuevoTurno;
		try {
			NuevoTurno = new Turno(DNI);
			listaTurnos.add(NuevoTurno);
			return NuevoTurno.getTurnoID();
		}
		catch(TurnoInvalidoException e) {
			//Ventana Error
			return 0;
		}
	}

	public Turno getNextTurn() {
		
		if (listaTurnos.isEmpty() == false){
			Turno siguiente = listaTurnos.get(0);
			listaTurnos.remove(0);
			return siguiente;
		}
		else {
			System.out.println("nop");
			return null;
		}
		
	}

	public ArrayList<Turno> getListaTurnos() {
		return listaTurnos;
	}

	
	
	
}
