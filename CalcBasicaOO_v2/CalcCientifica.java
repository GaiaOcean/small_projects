public class CalcCientifica
{
    public void calcular(String operando, String operador, boolean modoGrafico){
        
        double result = 0;
        String msg = "";
        
        switch(Integer.parseInt(operador)){
            case 1:
                result = Math.sin(Double.parseDouble(operando));
                msg = "Seno de " + operando + " = " + result;
                break;
            case 2:
                result = fatorial(operando, modoGrafico);
                if (result != -1) {  // Verifica se o fatorial foi válido
                    msg = "Fatorial de " + operando + " = " + result;
                } else {
                    msg = "Fatorial não pode ser calculado para números negativos";
                }
                break;
            case 3:
                result = Math.sqrt(Double.parseDouble(operando));
                msg = "Raiz quadrada  de " + operando + " = " + result;
                break;
            default:
                msg = "Operador Inválido";
            }
        
        Saida.mostrarMsg(msg,modoGrafico);
    }
    
    private static double fatorial(String operando, boolean modoGrafico){
        double result = 1;
        int n = Integer.parseInt(operando);
        
        if(n < 0){
            Saida.mostrarMsg("Operando inválido", modoGrafico);
            return -1;
        }
        for(int i = n; i > 0; i--){
            result *= i;
        }
        
        return result; 
    }
}
