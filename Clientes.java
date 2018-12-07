/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arismendys Marte
 */
public class Clientes implements Runnable{
    Random Aleatorio =new Random();
    Random TiempoeAleatorio =new Random();
    private int Tiempo;
    private Nodo n;
    private double ValorAliatorio;
    private int valor;
    private Colas fila;
    public Clientes() {}
    public Clientes(Colas fila,int valor){ 
        this.fila = fila; 
        this.valor=valor;
    }
    public void run(){
        for (int i=0;i<valor;i++){
            Tiempo=(1+TiempoeAleatorio.nextInt(5))*1000;
            try{
                Thread.sleep(Tiempo);
                synchronized(fila){
                    ValorAliatorio=Aleatorio.nextDouble();
                    if((ValorAliatorio>=0)&&(ValorAliatorio<=0.6)){
                        n = new Nodo();
                        n.setData("Cliente A: Para Retiroo Cambio de Cheque");
                        fila.push(n);
                        System.out.println("\033[36m Se agrego un cliente a la fila.");
                        fila.notify();
                    }else if((ValorAliatorio>=0.61)&&(ValorAliatorio<=0.75)){
                        n = new Nodo();
                        n.setData("Cliente B: Para Deposito");
                        fila.push(n);
                        System.out.println("\033[36m Se agrego un cliente a la fila.");
                        fila.notify();
                    }else if(ValorAliatorio>0.75){
                        n = new Nodo();
                        n.setData("Cliente C: Para Pago de Servicios");
                        fila.push(n);
                        System.out.println("\033[36m Se agrego un cliente a la fila.");
                        fila.notify();
                    }
                }
            }catch(Exception ex){
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
}
