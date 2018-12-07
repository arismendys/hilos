/*
Utilizando el metodo Ramdon cada proceso de cajero se ejecutara de forma aleatorio cada 5 segundos, pero
estos procesos utilizan el metodo wait() para ponerce en reposo por 4 segundos para no volver a ejecutar
o a la espera de que el proceso de clientes use el metodo notify para informarles que ya existe clientes
en la fila.

De no existir clientes lo hiran notificando y tras terminar el proceso de clientes esperaran 4 segundos
y no se volveran a ejecutar. 

Al finalizar la sincronzacion del metodo synchronized con los clientes el programa nos mostrara una lista 
de los clientes que atendio cada proceso de cajeros y el total de clientes que se atendieron.
 */

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cajeros implements Runnable{
    Random TiempoeAleatorio =new Random();
    private boolean verificar=false;
    private int Tiempo,Agregados=0,valor,SumarListas=0;
    private Colas fila;
    public Cajeros() {}
    public Cajeros (Colas fila,int valor){  
        this.fila = fila;
        this.valor=valor;
    }
    
    public void run(){
        int sumar=1+fila.conteo();
        ListaDoble lista = new ListaDoble();
        Nodo n;
        while(Agregados!=valor){
            Tiempo=(1+TiempoeAleatorio.nextInt(5))*1000;
            try{
                Thread.sleep(Tiempo);
                synchronized(fila){
                    if(Agregados!=valor){
                        if(fila.size()==0){
                            System.out.println("\033[31m No hay clientes en la fila!!! \n\033[35mA la espera de la llegada de algun cliente.");
                            fila.wait(6000);
                        }else{
                            if(fila.peek()!=null){
                                n = new Nodo();
                                n.setData(fila.pop().getData().toString());
                                lista.Agregar(n);
                                Agregados++;
                                System.out.println("\033[30m"+Thread.currentThread().getName().concat("\033[32m atendido al siguiente cliente en la fila."));
                            }
                        }
                    }
                }
            }catch(Exception ex){
                Logger.getLogger(Cajeros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            System.out.println("\n\033[30m"+Thread.currentThread().getName().concat("\033[32m  atendio \033[34m ")+lista.size()+"\033[32m  clientes:");
            SumarListas+=lista.size();
            for(int i=0;i<lista.size();i++){
                System.out.println("\033[35m ".concat(lista.get(i).getData().toString()));
            }
        } catch (Exception ex) {
            Logger.getLogger(Cajeros.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(SumarListas==valor){
                if(verificar==false){
                    System.out.println("\033[30m Se atendieron \033[34m ".concat(Agregados+"\033[30m  clientes de la fila"));
                    verificar=true;
                }
            }
        }
            

}
}
