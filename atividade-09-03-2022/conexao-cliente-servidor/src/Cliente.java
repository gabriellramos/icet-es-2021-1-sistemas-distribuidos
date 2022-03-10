import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {

        try (
            Socket servidor = new Socket("127.0.0.1", 12345);

            Scanner origem = new Scanner(System.in);
            PrintStream destino = new PrintStream(servidor.getOutputStream());
        ) {
            while (origem.hasNextLine()) {
                destino.println(origem.nextLine());
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}