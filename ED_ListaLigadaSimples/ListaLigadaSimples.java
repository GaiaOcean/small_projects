import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * ListaLigadaSimples. Ed para Lista Ligada simples
 * 
 * @author Julio Arakaki 
 * @version 1.0 2023/05/15
 */
public class ListaLigadaSimples {
    No inicio, fim;
    int qtdNos;

    /**
     * ListaLigadaSimples Construtor
     *
     */
    public ListaLigadaSimples(){
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    /**
     * setInicio
     *
     * @param inicio No inicio da lista ligada
     */
    private void setInicio(No inicio){
        this.inicio = inicio;
    }

    /**
     * getInicio
     *
     * @return No de inicio da lista ligada
     */
    public No getInicio(){
        return(this.inicio);
    }

    /**
     * getFim
     *
     * @return No do final da lista ligada
     */
    public No getFim(){
        return(this.fim);
    }

    /**
     * setFim
     *
     * @param fim No fim da lista ligada
     */
    private void setFim(No fim){
        this.fim = fim;
    }

    /**
     * getQtdNos
     *
     * @return int, qtde de nos na lista ligada
     */
    public int getQtdNos(){
        return this.qtdNos;
    }

    /**
     * setQtdNos
     *
     * @param qtdNos Um parâmetro
     */
    public void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * estaVazia
     *
     * @return boolean, true se estiver vazia e false caso contrario
     */
    public boolean estaVazia(){
        boolean vazia = false; 
        if (getQtdNos() == 0 && getInicio() == null && getFim() == null){
            vazia = true;
        }
        return vazia;
    }

    /**
     * inserirInicio
     *
     * @param elem Objeto a ser inserido no inicio da lista ligada
     */
    public void inserirInicio(Palavra elem) {
        No novo = new No(elem); //1

        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        }
        else{
            novo.setProximo(inicio);
            setInicio(novo);
        }
        setQtdNos(getQtdNos() + 1);
    }
    
    //generate a random id within the maxRange, put this id into the set and return it if it was not in the set, if it is already in the set pick another one
   public List<Integer> escolherNoAleatorio() {
        int maxId = getQtdNos();
        int randomNum;
        Set<Integer> chosenNumbers = new HashSet<>();
        List<Integer> randomOrder = new ArrayList<>(); 
        Random random = new Random();
       
        while (chosenNumbers.size() < maxId) {
            randomNum = random.nextInt(maxId + 1); 
            
            if (!chosenNumbers.contains(randomNum) && randomNum != 0) {
                chosenNumbers.add(randomNum); 
                randomOrder.add(randomNum); 
            }
        }
        
        return randomOrder; 
    }


    /**
     * inserirFim
     *
     * @param elem Objeto a ser inserido no fim da lista ligada
     */
    public void inserirFim(Palavra elem){
        No novo = new No(elem);
        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        }
        else{
            getFim().setProximo(novo);
            setFim(novo);
        }
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * removerInicio
     *
     * @return Objeto removido
     */
    public Palavra removerInicio(){
        No aux = null;
        Palavra obj = null; 
        if(!estaVazia()){
            if ((getInicio() == getFim())){
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else {
                aux = getInicio();
                setInicio(aux.getProximo());
                aux.setProximo(null);
            }
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo();
        }

        return(obj);
    }
    /** buscarId
     * 
     * @return  o index da palavra ou -1 caso não encontrar
    **/
    public int buscarId(String texto){ 
        int local = -1;
        int i = 1;
        No aux = getInicio();
        Palavra word;
        while(aux != null){
            word = aux.getConteudo();
            if(word.equals(texto)){
                local = i;
                return local;
            }
            aux = aux.getProximo();
            i++;
        }
        return local;
    }
    
    public void removerPorId(String texto) {
        int local = buscarId(texto); 

        if (local != -1) {  
            No prev = null; 
            No current = getInicio(); 
            int i = 1; 
        
            if (local == 1) {
                setInicio(current.getProximo());  
                setQtdNos(getQtdNos() - 1);
                return;  
            }
    
          
            while (current != null && i < local) {
                prev = current;
                current = current.getProximo();
                i++;
            }
            setQtdNos(getQtdNos() - 1);
        }
    }

    /**
     * removerFim
     *
     * @return Objeto removido
     */
    public Palavra removerFim(){
        No ant = getInicio();
        No aux = null;
        Palavra obj = null; 
        if (!estaVazia()){
            if ((getInicio() == getFim())){
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else {            
                // percorre ate achar o no antes do fim
                while(ant.getProximo() != fim){
                    ant = ant.getProximo();
                }
                ant.setProximo(null);
                aux = fim;
                setFim(ant);
            }
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo();           
        }
        return obj;
    }
}