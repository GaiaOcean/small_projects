/**
 * Classe principal.
 * 
 * @author Julio Arakaki 
 * @version 20250310
 */
import javax.swing.JOptionPane;

public class Saida {
    /**
     * Método mostrarMsg
     *
     * @param msg String a ser apresentado na console
     * @param useGUI verifica se o usuario escolheu ou não usar a janela grafica
     */
    public static void mostrarMsg(String msg,boolean useGUI){
        if(useGUI){
            JOptionPane.showMessageDialog(null,msg);
        } else {
            System.out.println(msg);
        }
    }
}
