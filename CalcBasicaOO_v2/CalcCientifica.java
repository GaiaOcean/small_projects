
/**
 * Escreva uma descrição da classe CalcCientifica aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class CalcCientifica
{
    public static void calcularOperacao( String operando){
        
        double result = 0;
        String msg = "";
        CalcBasica calc = new CalcBasica();
        
        String operador = chooseOperation();
        if(calc.isNumeric(operando)){
            switch(Integer.parseInt(operador)){
                case 1:
                    result = Math.sin(Double.parseDouble(operando));
                    msg = "Seno de " + operando + " = " + result;
                    break;
                case 2:
                    result = fatorial(operando);
                    msg = "Fatorial de " + operando + " = " + result;
                    break;
                case 3:
                    result = Math.sqrt(Double.parseDouble(operando));
                    msg = "Raiz quadrada  de " + operando + " = " + result;
                    break;
                default:
                    msg = "Operador Inválido";
            }
        }else{
            msg = "Operando inválido";
        }
        
        Saida.mostrarMsg(msg);
    }
    
    public static double fatorial(String operando){
        double result = 1;
        int n = Integer.parseInt(operando);
        
        for(int i = n; i > 0; i--){
            result *= i;
        }
        
        return result; 
    }
    
    public static String chooseOperation(){
        String msg = "Digite \n 1 - seno \n 2 - Fatorial \n 3 - Raiz Quadrada";
        Saida.mostrarMsg(msg);
        
        String choice = Entrada.retornaString();
        
        return choice;
        
    }
}
