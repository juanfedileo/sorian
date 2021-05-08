package Server;

import java.util.ArrayList;

public class GestorTurnos {

	ArrayList<Turno> ListaTurnos;
	
	public GestorTurnos() {
		// TODO Auto-generated constructor stub
		ListaTurnos = new ArrayList<Turno>();
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

	public Turno getNextTurn() {
		
		if (ListaTurnos.isEmpty() == false){
			Turno siguiente = ListaTurnos.get(0);
			return siguiente;
		}
		else {
			System.out.println("nop");
			return null;
		}
		
	}
	
}
