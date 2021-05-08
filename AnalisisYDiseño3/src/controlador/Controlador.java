package controlador;
import Modelo.*;
import Vista.*;

public class Controlador {
	
	public static void CreadorTurno(String DNI, int TurnoID) {
		Turno NuevoTurno;
		try {
			
			NuevoTurno = new Turno(DNI);
			TurnoID = NuevoTurno.getTurnoID();
		}
		catch(TurnoInvalidoException e) {
			//Ventana Error
		}
	}
}
