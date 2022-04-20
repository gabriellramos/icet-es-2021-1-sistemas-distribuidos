/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteServidorSwap2;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Jean
 */
public class Cliente {
    public static void main(String[] args) throws Exception {

        try (
            Socket servidor = new Socket("127.0.0.1", 12345);

            Scanner origem = new Scanner(System.in);
            PrintStream destino = new PrintStream(servidor.getOutputStream());
        ) {
            while (origem.hasNextLine()) {
                String request = origem.nextLine().replaceAll("[\\D]","");
                destino.println(request);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
