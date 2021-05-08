package controlador;
import Modelo.*;
import Vista.*;

public class Controlador {
	
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
