/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.Scanner;

/**
 *
 * @author Arismendys Marte
 */
public class CorrerHilos {
    public static void main(String[] args){
        int valor;
        Scanner sc=new Scanner(System.in);
        System.out.println("Digite el tamaño de la fila:");valor=sc.nextInt();
        Colas fila =new Colas();
        Clientes Cliente =new Clientes(fila,valor);
        Cajeros cajero = new Cajeros(fila,valor);
        
        Thread c1 = new Thread(cajero);
        Thread c2 = new Thread(cajero);
        Thread c3 = new Thread(cajero);
        Thread cliente = new Thread(Cliente);
        
        c1.setName("Cajero 1:");
        c2.setName("Cajero 2:");
        c3.setName("Cajero 3:");
        
        cliente.start();
        c1.start();
        c2.start();
        c3.start();
        
        
    }
}
