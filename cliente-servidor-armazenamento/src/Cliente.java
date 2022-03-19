import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
    	int req;
    	
        try (
            Socket servidor = new Socket("127.0.0.1", 12345);

            Scanner origem = new Scanner(System.in);
            PrintStream destino = new PrintStream(servidor.getOutputStream());
        ) {
            while (origem.hasNextLine()) {
            	req = Integer.parseInt(
            			origem.nextLine().replaceAll("[^0-9]", "")
            			);
            	
                destino.println("Solicitando alocacao de tamanho "+req);
                
               
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}