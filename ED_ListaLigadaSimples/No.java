/**
 * No de uma lista ligada.
 * 
 * @author Julio Arakaki 
 * @version 1.0 2023/05/15
 */
public class No{
    /**
     * Atributos
     */
    Palavra conteudo; // conteudo
    No proximo; // proximo

    /**
     * No Construtor
     *
     * @param conteudo Palavra a ser inserido no no
     */
    public No(Palavra conteudo){
        setConteudo(conteudo);
        setProximo(null);
    }
    /**
     * setters e getters
     */
    public void setConteudo(Palavra conteudo){
        this.conteudo = conteudo;
    }
    
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    public Palavra getConteudo(){
        return(this.conteudo);
    }
    
    public No getProximo(){
        return(this.proximo);
    }
    public String toString(){
        return(conteudo.toString());
    }
}
