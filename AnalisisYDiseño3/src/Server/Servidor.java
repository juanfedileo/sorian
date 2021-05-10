package Server;

import java.util.ArrayList;
import Cliente.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	int Port;
	GestorTurnos Gestor;

	public Servidor(int Port, GestorTurnos Gestor) {
		super();
		this.Gestor = Gestor;
		this.Port = Port;

	}

	public void StartServidor() {

		Thread t1 = new Thread() {

			@Override
			public void run() {
				Turno SiguienteTurno;
				String DNI;
				int TurnoID;
				try {
					ServerSocket serverSocket = new ServerSocket(5000);
					while (!serverSocket.isClosed()) {
						Socket socket = serverSocket.accept();
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String accion = in.readLine();
						switch (accion) {
						case ("crear"):
							DNI = in.readLine();
							TurnoID = Gestor.CreadorTurno(DNI);
							out.println(TurnoID);
							break;
						case ("get"):
							SiguienteTurno = Gestor.getNextTurn();
							if (SiguienteTurno == null){
								out.println("No hay siguiente.");
								out.println("No hay siguiente.");
							}
							else {
								DNI = SiguienteTurno.getDNI();
								TurnoID = SiguienteTurno.getTurnoID();
								out.println(DNI);
								out.println(TurnoID);
							}
							break;

						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};
		t1.start();

	}

}
