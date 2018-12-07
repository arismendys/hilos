
import java.util.Scanner;
/*
Leemos un valor tipo entero el cual determinara el tamaño de la fila de clientes
que se creara.

Crearemos tres hilos de procesos de tipo Cajero y un de tipo cliente, le mandaremos
a cada proceso de cajero el nombre del cajero y luego ejecutaremos los cuatro procesos a la vez.

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
