/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

/**
 *
 * @author Arismendys Marte
 */
public class ListaDoble {
    private Nodo head;
    private int cant = 0;
    private boolean circular = false;
    
    ListaDoble (Nodo n){ head = n; }
    ListaDoble (){}
    
    public Nodo getHead() {return head;}
    public void Agregar (Nodo n){
        Nodo l = null, z = null;
        cant++;
        
        if (head == null) head = n;
        else
        {
            for (l = head; l.getNext()!= null; l=l.getNext(), z=l.getBefore());
            l.setNext(n);
            l.setBefore(l);
        }
    }
    public void AgregarPrimero (Nodo n){
        cant++;
        if (head == null) head = n;
        else
        {
            n.setNext(head);
            head = n;
        }
    }
    public int size(){ return cant; }
    public Nodo get(int pos){
        int i;
        Nodo l;
        if (cant >= pos && pos >= 0)
        {
            if(pos == 0) return head;
            for (i = 0, l = head ; i < pos ; i++, l = l.getNext());
                return (l);
        }
        return null;
    }
    public void BuscarPalabra (String Palabra, ListaDoble l){
        int k = 0;
        Nodo n;
        
        for (k = 0, n = head ; k < l.size() ; k++, n = n.getNext())
        {
            if (Palabra.equals((String) n.getData())){
                System.out.print("Esta palabra está en el nodo: " + k + "\n");
            }
        }  
    }
//    public void Insertar (Nodo n){
//        Nodo l, k;
//        l = k = null;
//        
//        cant++;
//        int obj = 0, h = 0, Nl = 0;
//        
//        obj = ((Estudiante)n.getData()).getMatricula();
//        h = ((Estudiante)head.getData()).getMatricula();
//
//        if(obj <= h)
//        {
//            n.setNext(head); head.setBefore(n); head=n;
//        }
//        else
//        {
//            l = head;
//            Nl = ((Estudiante)l.getData()).getMatricula();
//            for( l = head; Nl <= obj && l.getNext()!= null; l = l.getNext()){
//                Nl = ((Estudiante)l.getData()).getMatricula(); 
//            }
//                Nl = ((Estudiante)l.getData()).getMatricula(); 
//                if(Nl <= obj && l.getNext() == null) { l.setNext(n); n.setBefore(l); }
//                else
//                {
//                    for(k = head ; k.getNext() != l ; k = k.getNext());
//                        k.setNext(n);
//                        n.setNext(l);
//                        n.setBefore(l.getBefore());
//                }
//        }
//    }
    public void Eliminar (Nodo d){
        Nodo l;
        cant--;
        if(d == head)
        {
            head = head.getNext();
        }
        else
        {
            for(l=head; l.getNext()!= d ; l=l.getNext());
            d.getBefore().setNext(d.getNext());
            d.getNext().setBefore(d.getBefore());
        }
    }
    public void Circular (){
        Nodo l;

        if (!circular){
            circular = true;

            for (l = head ; l.getNext() != null ; l = l.getNext());
		l.setNext(head);
		head.setBefore(l);

                System.out.println("");
                System.out.println("La lista se ha convertido en Lista Circular.");
        }
        else { System.out.println("La lista fué convertido en Lista Circular anteriormente."); }
    }
//    public void Vueltas (int num, ListaDoble m){
//        Nodo l;
//        int i, cont = 1;
//        
//        if (circular == true){
//            while (cont <= num)
//            {
//                for (i = 0, l = head ; i <= m.size() ; l = l.getNext(), i++);
//                    System.out.println("\033[31m"+"\nLa lista ha dado la vuelta número: " + cont+"\n");
//                    Estudiante est2;
//            for(int c=0;c<m.size();c++){
//                est2 = ((Estudiante)(m.get(c)).getData());
//                System.out.print("\033[31m"+est2.getMatricula()+" \033[32m"+est2.getNombre()+" "+est2.getApellido()+" "+est2.getCarrera()+"\n");
//            }
//                    cont++;
//            }
//        }
//        else { System.out.println("La lista no es Circular."); }
//    }
}
