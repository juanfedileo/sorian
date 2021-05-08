package Modelo;

public class TurnoInvalidoException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No se pudo generar el turno";
	}
	
	
}
