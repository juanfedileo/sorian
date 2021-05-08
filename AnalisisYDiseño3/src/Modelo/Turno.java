package Modelo;

public class Turno {
	
	static int TurnoContador = 0;
	int TurnoID;
	String DNI;
	
	public Turno(String DNI) throws TurnoInvalidoException {
		
		int longitud = DNI.length();
		
		if (longitud >0 && longitud < 9) {
			//DNI V�LIDO
			this.DNI = DNI;
			TurnoContador++;
			TurnoID = TurnoContador;
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

	@Override
	public String toString() {
		return "Turno [DNI=" + DNI + "]"+" Numero de Turno : "+ TurnoID + " ";
	}
	
	
	
}
