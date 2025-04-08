
/**
 * Escreva uma descrição da classe Entrada aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Entrada
{
    
    
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
            this.setModoGrafico(true);
        }
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
    /**
     * Metodo lerDados - verifica em qual modo deve-se mostrar a mensagem
     * Parametros:
     *         String mensagem - texto a ser displayed
     * Retorno:
     *         String  -  retorna a mensagem em modo gráfico ou texto
     */
    public String lerDados(String mensagem){
        if(this.getModoGrafico()){
            return EntradaGrafica.showInput(mensagem);
        } else {
            return lerString(mensagem);
        }
    }
    public boolean isNumeric(String texto){
        if (texto == null || texto.length() == 0) {
            return false;
        }
        boolean foundDecimal = false;
        for (char c : texto.toCharArray()) { // percorre a string
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
    
    public int validarNumero(String msg){
        String dadoSemValidacao = this.lerDados(msg);
        
        int copiaDado;
        
         while(!isNumeric(dadoSemValidacao)){
            Saida.mostrarMsg("Por favor informe apenas números", this.getModoGrafico());
            dadoSemValidacao = this.lerDados(msg);
        }
        
        copiaDado = Integer.parseInt(dadoSemValidacao);
        
        return copiaDado;
    }
    
    public String validarRa(String msg){
        String dadoSemValidacao = this.lerDados(msg);
        
         while(!isNumeric(dadoSemValidacao)){
            Saida.mostrarMsg("Por favor informe apenas números", this.getModoGrafico());
            dadoSemValidacao = this.lerDados(msg);
        }
        
        return dadoSemValidacao;
    }
    
}
