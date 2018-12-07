/*
Esta clase se ejecutara cada 5 segundos utilizando el metodo Ramdon()
Utilizando el metodo synchronized sincronizaremos la fila de clientes la cual sera de tipo cola,
esta clase resivira una cola vacia para ser llenada y el tamaño de clientes que se crearan.

Utilizaremos el metodo Ramdon() para crear un valor aleatorio tipo double que sera equivalente aleatorio
tiempo en que esta clase creara uno de los tres tipos de clientes.

Estos clientes sera:

* De 0 a 0.6 segundos un Cliente A
* De 0.61 a 0.75 un Cliente B
* Mayor a 0.75 un Cliente C

Cada vez que cree un cliente este se almacenara en la cola y notificara mediante el metodo notify()
a todos los procesos que estan en espera que se ha añadido un nuevo cliente para que vayan a atenderlo.
 */
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
