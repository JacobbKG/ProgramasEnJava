package replicarrecorrido;

import javax.swing.JOptionPane;

/**
 *
 * @author JACOB
 */
public class ReplicarRecorrido {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String strValor = JOptionPane.showInputDialog(null,"Ingrese Informacion a b");
       Automata automata = new Automata();
       System.out.println("Ingrese informacion '"+ strValor + "' es?: "+ automata.accept(strValor,true));
    }
    
}
