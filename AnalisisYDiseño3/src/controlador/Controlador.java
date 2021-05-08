package controlador;
import java.util.ArrayList;

import Modelo.*;
import Vista.*;


public class Controlador {
	ArrayList<Turno> ListaTurnos;
	
	public Controlador() {
		super();
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
	
	
}
