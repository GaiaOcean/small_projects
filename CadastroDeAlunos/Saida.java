
/**
 * Escreva uma descrição da classe Saida aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import javax.swing.JOptionPane;

public class Saida
{
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
