import java.awt.List;
import java.awt.Taskbar.State;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static Armazenamento armaz = new Armazenamento(1024);

	public static void main(String[] args) throws Exception {

		ServerSocket servidor = new ServerSocket(12345);
		while (true) {
			Socket cliente = servidor.accept();

			System.out.println("# Nova conexao");

			ServidorCliente sc = new ServidorCliente(servidor, cliente, armaz);
			
			new Thread(sc).start();

		}
	}

	public void status_memoria() {
		System.out.println("\nMemoria MAXIMA: " + armaz.getMemoria_max());
		System.out.println("Memoria Alocada: " + armaz.getMemoria_alocada());
		System.out.println("Memoria Disponivel: " + armaz.getMemoria_disponivel() + "\n\n");

	}
}