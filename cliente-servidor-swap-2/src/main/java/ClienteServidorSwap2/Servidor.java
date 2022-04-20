/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteServidorSwap2;

import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

/**
 *
 * @author Jean
 */
public class Servidor{
    
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(12345);

        while (true) {
            Socket cliente = servidor.accept();

            System.out.println("# Nova conexao");
            

            ServidorCliente sc = new ServidorCliente(servidor, cliente);

            new Thread(() -> sc.run()).start();
        }       
    }
}
