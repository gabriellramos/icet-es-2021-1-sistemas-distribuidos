import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ServidorCliente
 */
public class ServidorCliente implements Runnable {
	private ServerSocket servidor;
	private Socket cliente;
	private Armazenamento a;

	public ServidorCliente(ServerSocket servidor, Socket cliente, Armazenamento a) {
		this.servidor = servidor;
		this.cliente = cliente;
		this.a = a;
		
	}
	
	@Override
	public void run() {
		try (Scanner leitor = new Scanner(this.cliente.getInputStream());) {
			while (leitor.hasNextLine()) {
				/*
				 * tratar essa string para somente numeros servidor.alocar(leitor.nextLine()
				 */
				System.out.println(leitor.nextLine().replaceAll("[^0-9]", ""));
				a.status_memoria();
				a.alocar(Integer.parseInt(leitor.nextLine().replaceAll("[^0-9]", "")));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		try {
			this.cliente.close();
		} catch (IOException e) {
		}
	}

}