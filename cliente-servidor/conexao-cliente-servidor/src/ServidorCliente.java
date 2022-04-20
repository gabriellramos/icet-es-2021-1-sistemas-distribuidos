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

    public ServidorCliente (ServerSocket servidor, Socket cliente) {
        this.servidor = servidor;
        this.cliente = cliente;       
    }

    @Override
    public void run() {
        try (
            Scanner leitor = new Scanner(this.cliente.getInputStream());
        ) {
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        try {
            this.cliente.close();            
        }
        catch (IOException e) { }
    }
}