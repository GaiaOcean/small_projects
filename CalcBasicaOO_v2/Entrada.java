import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Classe Entrada - realiza e valida todas as operações de entrada da aplicação.
 * 
 * @author 
 * @version 
 */

public class Entrada {
    //Constantes para mensagens
    private static final String MSG_OPERADORES_CIENTIFICA = 
        "Digite 1 para calcular o Seno\nDigite 2 para calcular o Fatorial\nDigite 3 para calcular Raiz Quadrada:";
    private static final String MSG_OPERADORES_BASICA = "Digite o operador (+, -, *, /): ";
    private static final String MSG_ERRO_OPERADORES = "\nOperador inválido. Digite novamente\n";
    private static final String MSG_ERRO_OPERANDO = "\nOperando inválido. Digite novamente\n";
    
    //Variavel booleana para definir que tipo de método de entrada deve ser utilizado
    private static boolean modoGrafico;
    
    //Metodos Getter and Setter para a variavel modoGrafico
    private void setModoGrafico(boolean state){
        this.modoGrafico = state;
    }
    
    public boolean getModoGrafico(){
        return this.modoGrafico;
    }
    
    public void definirModo(String modo){
        if(modo.equals("t")){
            this.setModoGrafico(false);  
        } else if (modo.equals("g")){
            this.setModoGrafico(true);
        } else {
            Saida.mostrarMsg("Parametros invalidos. Digite \"t\" para modo texto ou \"g\" para modo grafico", false);
            System.exit(1);
        }
    }
    
    public String lerOperacaoCalcBasica(int posicao){
        String entrada;
        
        if(posicao == 2){
            return verificarOperadorCalcBasica();
        }
        
        return verificarOperando(posicao);
    }
    
    public String lerOperacaoCalcCientifica(int pos){
        if(pos == 2){
            return verificarOperadorCalcCientifica();
        }
        
        return verificarOperando(pos);
    }
    
    /**
     * Método lerString - le uma string pelo teclado e retorna
     *
     * @param mensagem Mesnsage na console
     * @return s string lida
     */
    public String lerString(String mensagem){
        
        // Cria um objeto da classe Scanner, para leitura pelo teclado
        Scanner sc = new Scanner(System.in);

        // Mostra msg na console
        System.out.print(mensagem);
        
        // Faz a leitura pelo teclado
        String s = sc.nextLine();
        
        // Fecha dispositivo de entrada
        sc.close();
        
        // Retorna a string lida
        return s;
    }
    
    public String lerDados(String mensagem){
        if(this.getModoGrafico()){
            return JOptionPane.showInputDialog(mensagem);
        } else {
            return lerString(mensagem);
        }
    }
    
    private String verificarOperando(int pos){
        String operando = lerDados("Digite o " + pos + " operando: ");
        
        while(!isNumeric(operando)){
            Saida.mostrarMsg(MSG_ERRO_OPERANDO, this.getModoGrafico());
            operando = lerDados("Digite o " + pos + " operando: ");
        }
        
        return operando;
    }
    
    private String verificarOperadorCalcBasica() {
        String operador = lerDados(MSG_OPERADORES_BASICA);

        while (!validarOperadorCalcBasica(operador)) {
            Saida.mostrarMsg(MSG_ERRO_OPERADORES, this.getModoGrafico());
            operador = lerDados(MSG_OPERADORES_BASICA);
        }

        return operador;
    }
    
    private boolean validarOperadorCalcBasica(String operador){
        return operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/");

    }
    
    private String verificarOperadorCalcCientifica() {
        String operador = lerDados(MSG_OPERADORES_CIENTIFICA);

        while (!validarOperadorCalcCientifica(operador)) {
            Saida.mostrarMsg(MSG_ERRO_OPERADORES, this.getModoGrafico());
            operador = lerDados(MSG_OPERADORES_CIENTIFICA);
        }

        return operador;
    }
    
    private boolean validarOperadorCalcCientifica(String operador){
        return operador.equals("1") || operador.equals("2") || operador.equals("3");
    }
    
    /**
     * Metodo isNumeric - verifica se a string eh numerica
     * Parametros:
     *         String str - string a ser verificada
     * Retorno:
     *         boolean - true: a string eh numerica
     *                  - false: a string nao eh numerica
     */
        
    private boolean isNumeric(String operando){
        if (operando == null || operando.length() == 0) {
            return false;
        }
            
        boolean foundDecimal = false;
        for (char c : operando.toCharArray()) { // percorre a string
            if (!Character.isDigit(c)) { // verifica se eh digito
                if (c == '.' && !foundDecimal) { // verifica se existe um unico ponto
                    foundDecimal = true;
                } else {
                    return false;
                }
            }
        }            
        return true;
    }
}
