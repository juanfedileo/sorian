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

	public void StartServidorCliente() {

		Thread t2 = new Thread() {

			@Override
			public void run() {
				try {
					ServerSocket serverSocketCliente = new ServerSocket(5000);
					while (!serverSocketCliente.isClosed()) {
						Socket socket = serverSocketCliente.accept();
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String DNI = in.readLine();
						int turnoID = Gestor.CreadorTurno(DNI);
						out.println(turnoID);
						socket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		t2.start();
	}

	public void StartServidorMonitor() {

		Thread t1 = new Thread() {

			@Override
			public void run() {
				Turno SiguienteTurno;
				try {
					ServerSocket serverSocket = new ServerSocket(5000);
					while (!serverSocket.isClosed()) {
						Socket socket = serverSocket.accept();
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String accion = in.readLine();
						switch (accion) {
						case ("crear"):
							String DNI = in.readLine();
							int turnoID = Gestor.CreadorTurno(DNI);
							out.println(turnoID);
							break;
						case ("get"):
							break;

						}
						System.out.println(in.readLine());
						// String DNI = in.readLine();
						// SiguienteTurno = Gestor.getNextTurn();
						// int turnoID = SiguienteTurno.TurnoID;//CreadorTurno(DNI);
						// out.println(turnoID);
						socket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};
		t1.start();

	}

	public void StartServidorVendedor() {

		Thread t = new Thread() {

			@Override
			public void run() {
				Turno SiguienteTurno;
				try {
					ServerSocket serverSocketVendedor = new ServerSocket(4949);
					while (!serverSocketVendedor.isClosed()) {

						Socket socket = serverSocketVendedor.accept();
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

						SiguienteTurno = Gestor.getNextTurn();

						if (SiguienteTurno != null) {

							String DNI = SiguienteTurno.getDNI();
							String TurnoID = "" + SiguienteTurno.getTurnoID();

							System.out.println(DNI + " " + TurnoID);

							out.println(DNI);
							out.println(TurnoID);
						}
						System.out.println(SiguienteTurno.toString());
						socket.close();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};
		t.start();

	}

}
