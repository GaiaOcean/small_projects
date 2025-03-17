/**
 * Classe principal.
 * 
 * @author 
 * @version 
 */

import javax.swing.JOptionPane;
public class Aplicacao {

    /**
     * Método main - principal: inicia um programa em java
     *
     * @param args - vetor de string (recebe dados do SO)
     */
    public static void main(String args[]){
        boolean useGUI = false;
        
        if(args.length == 1){
                // Instancia objeto para entrada de string (cria um objeto da classe)
            Entrada ent = new Entrada();
            ent.definirModo(args[0]);
                    
            String choice = ent.lerDados("Digite 0 para acessar a calculadora Básica \nou \n1 para a calculadora científica: ");
                
            if(choice.equals("0")){
                // Le os dados do teclado
                String operando1 = ent.lerOperacaoCalcBasica(1);
                String operador = ent.lerOperacaoCalcBasica(2);
                String operando2 = ent.lerOperacaoCalcBasica(3);
        
                // Chamada do metodo local (calcularBasica)
                calcularBasica(operando1, operador, operando2, ent.getModoGrafico());
            } else if (choice.equals("1")){
                String operador = ent.lerOperacaoCalcCientifica(2);
                String operando = ent.lerOperacaoCalcCientifica(1);
                
                calcularCientifica(operando,operador,ent.getModoGrafico());
            }
        } else {
            Saida.mostrarMsg("Parametros invalidos. Digite \"t\" para modo texto ou \"g\" para modo grafico", false);
        }
    }

    /**
     * Método calcular
     *
     * @param s1 - operando1
     * @param s2 - operador
     * @param s3 - operando2
     */
    private static void calcularBasica(String s1, String s2, String s3, boolean useGUI){
        // Cria instancia (criando um obj) da classe CalcBasica
        CalcBasica cb = new CalcBasica();

        // Aciona o metodo calcular (passa o vetor de strings, como parametro)
        cb.calcular(s1, s2, s3, useGUI);
    }
    
    private static void calcularCientifica(String s1, String s2, boolean useGUI){
        // Cria instancia (criando um obj) da classe CalcBasica
        CalcCientifica cb = new CalcCientifica();

        // Aciona o metodo calcular (passa o vetor de strings, como parametro)
        cb.calcular(s1, s2,useGUI);
    }
}

