
/**
 * Classe para calculadora basica (4 operacoes|)
 * 
 * @author
 * @version
 */
public class CalcBasica {
    /**
     * Método calcular
     *
     * @param operando1 String
     * @param operador String
     * @param operando2 String
     */
    public void calcular(String operando1, String operador, String operando2, boolean useGUI){ 

        // Para armazenar resultado
        double result = 0;

        // Para armazenar uma msg
        String msg = "";

            // Realiza as 4 operacoes
            switch (operador){
                case "-":
                    result = Double.parseDouble(operando1) - Double.parseDouble(operando2);
                    msg = String.format("Resultado = %.2f", result);
                    break;
                case "+":
                    result = Double.parseDouble(operando1) + Double.parseDouble(operando2);
                    msg = String.format("Resultado = %.2f", result);
                    break;
                case "*":
                    result = Double.parseDouble(operando1) * Double.parseDouble(operando2);
                    msg = String.format("Resultado = %.2f", result);
                    break;
                case "/":
                    result = Double.parseDouble(operando1) / Double.parseDouble(operando2);
                    msg = String.format("Resultado = %.2f", result);
                    break;
                default:
                    msg = "Operador invalido!!";
            }    

        Saida.mostrarMsg(msg,useGUI);
    }
}

