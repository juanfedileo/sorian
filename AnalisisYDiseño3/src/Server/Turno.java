package Server;

import java.util.Calendar;

public class Turno {
	
	int TurnoID;
	String DNI;
	Calendar TurnoFecha;
	static int TurnoContador = 0;
	
	public Turno(String DNI) throws TurnoInvalidoException {
		
		int longitud = DNI.length();
		
		if (longitud >0 && longitud < 9) {
			//DNI V�LIDO
			this.DNI = DNI;
			TurnoContador++;
			TurnoID = TurnoContador;
			TurnoFecha = Calendar.getInstance();
		}
		else {
			//DNI INV�LIDO
			throw new TurnoInvalidoException();
		}
		

	}
	
	public int getTurnoID() {
		return TurnoID;
	}

	public String getDNI() {
		return DNI;
	}
	
	public Calendar getTurnoFecha() {
		return TurnoFecha;	
	}

	@Override
	public String toString() {
		return "Turno [DNI=" + DNI + "]"+" Numero de Turno : "+ TurnoID + " ";
	}
	
	
	
}
