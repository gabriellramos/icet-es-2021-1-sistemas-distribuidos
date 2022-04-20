import java.awt.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(12345);

        while (true) {
            Socket cliente = servidor.accept();

            System.out.println("# Nova conexao");

            ServidorCliente sc = new ServidorCliente(servidor, cliente);

            new Thread(sc).start();
        }       
    }
}