/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteServidorSwap2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jean
 */
public class ServidorCliente {
    private ServerSocket servidor;
    private Socket cliente;
    private int armazenamento[];
    private int armIndice;
    private int swapIndice;
    private int swap[];
    public static int TAM = 3;
 
    public ServidorCliente (ServerSocket servidor, Socket cliente) {
        this.servidor = servidor;
        this.cliente = cliente;
        armazenamento = new int[TAM];
        armIndice = 0;
        swapIndice = 0;
        swap = new int[TAM];
    }

    public void run(){
        try (
            Scanner leitor = new Scanner(this.cliente.getInputStream());
        ) {
            while (leitor.hasNextLine()) {
                Integer valor = Integer.parseInt(leitor.nextLine());
                System.out.println("O cliente solicitou armazenar "+valor+" no espaco de memoria.");
                
                if(armIndice == TAM && swapIndice == TAM){
                    System.out.println("Armazenamento principal e swap totalmente consumidos.");
                }else if(armIndice == TAM){
                    System.out.println("Armazenamento principal cheio.");
                    System.out.println("Realocando para a swap.");

                    realocarMemoria(armazenamento);
                    armazenamento[armIndice] = valor;
                    armIndice++;
                    
                    System.out.println("Armazenamento na swap efetuado com sucesso. Voce tem mais "+(TAM-swapIndice)+" memorias livres.");
                    
                    System.out.println("Armazenamento principal: ");
                    imprimirMemoria(armazenamento, armIndice);
                    System.out.println("Swap: ");
                    imprimirMemoria(swap, swapIndice);
                } else{
                    armazenamento[armIndice] = valor;
                    armIndice++;
                    System.out.println("Armazenamento efetuado com sucesso. Voce tem mais "+(TAM-armIndice)+" memorias livres.");
                    imprimirMemoria(armazenamento, armIndice);
                }
                System.out.println("");
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
    
    public void imprimirMemoria(int memoria[], int indice){
        int i;
        
        System.out.print("[");
        for(i=0; i<indice; i++){
            System.out.print(memoria[i]);
            if(i < indice-1){
                System.out.print("|");
            }
        }
        System.out.print("]\n");
    }
    
    public void realocarMemoria(int memoria[]){
        int i;
        
        swap[swapIndice] = armazenamento[0];
        swapIndice++;
        
        for(i=0; i<TAM-1; i++){
            armazenamento[i] = armazenamento[i+1];
        }
         
        armIndice--;
    }
}
