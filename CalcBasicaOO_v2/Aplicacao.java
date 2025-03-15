
/**
 * Classe principal.
 * 
 * @author Julio Arakaki 
 * @version 20250310
 */
public class Aplicacao {

    /**
     * Método main - principal: inicia um programa em java
     *
     * @param args - vetor de string (recebe dados do SO)
     */
    public static void main(String args[]){

        // Verifica se existe parametros vindos do SO (args)
        if (args.length == 0){ // sem parametros (faz entrada pelo teclado)

            // Instancia objeto para entrada de string (cria um objeto da classe)
            Entrada ent = new Entrada();

            // Le os dados do teclado
            String operando1 = ent.lerString("Forneca operando1: ");
            String operador = ent.lerString("Forneca operador: ");
            String operando2 = ent.lerString("Forneca operando2: ");

            // Chamada do metodo local (calcular)
            calcular(operando1, operador, operando2);

        } else if (args.length == 3) { // parametros pelo SO (args)
            // Le os dados da linha de comando
            String operando1 = args[0];
            String operador = args[1];
            String operando2 = args[2];

            // Chamada do metodo local (calcular)
            calcular(operando1, operador, operando2);

        } else {
            //System.out.println("Parametros invalidos!!");
            Saida.mostrarMsg("Parametros invalidos!!");
        }
    }

    /**
     * Método calcular
     *
     * @param s1 - operando1
     * @param s2 - operador
     * @param s3 - operando2
     */
    public static void calcular(String s1, String s2, String s3){
        // Cria instancia (criando um obj) da classe CalcBasica
        CalcBasica cb = new CalcBasica();

        // Aciona o metodo calcular (passa o vetor de strings, como parametro)
        cb.calcular(s1, s2, s3);
    }
}

