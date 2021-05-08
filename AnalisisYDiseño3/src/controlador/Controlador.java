package controlador;
import java.util.ArrayList;

import Modelo.*;
import Vista.*;


public class Controlador {
	ArrayList<Turno> ListaTurnos= new ArrayList<Turno>();
	
	public Controlador() {
		super();
	}

	public static int CreadorTurno(String DNI) {
		Turno NuevoTurno;
		try {
			
			NuevoTurno = new Turno(DNI);
			
			return NuevoTurno.getTurnoID();
		}
		catch(TurnoInvalidoException e) {
			//Ventana Error
			return 0;
		}
	}
}
