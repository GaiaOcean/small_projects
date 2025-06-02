
/**
 * Escreva uma descrição da classe Palavra aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Palavra
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int id;
    private String texto;

    /**
     * Construtor para objetos da classe Palavra
     */
    public Palavra(String texto, int id)
    { 
       this.texto = texto;
       this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
    
        if (obj instanceof String) {
            return texto != null && texto.equals(obj);
        }
    
        
        if (obj instanceof Palavra) {
            Palavra other = (Palavra) obj;
            return texto != null && texto.equals(other.texto);
        }
    
        return false;
    }

    
    public String getTextoPalavra(){
        return this.texto;
    }
    public int getIdPalavra(){
        return this.id;
    }
}
