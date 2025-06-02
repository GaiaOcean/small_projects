
/**
 * Escreva uma descrição da classe ListaPalavra aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ListaPalavra implements ILista
{
    ListaLigadaSimples p = new ListaLigadaSimples();
    Id id;
    int currentId;
    
    public ListaPalavra(Id id){
        this.id = id; //a instancia do id fica no main
    }
    
    public void addPalavra(String texto){
        currentId++;
        Palavra novaPalavra = new Palavra(texto, currentId);
        p.inserirFim(novaPalavra);
       
    }
    public void removerPalavra(String texto){
        p.removerPorId(texto);
    }
    
    public String getPalavra(int id){
        No no = p.getInicio();
        Palavra r;
        String t = "Palavra não encontrada\n";
        
        while(no != null){
            r = no.getConteudo();
            
            if(id == r.getIdPalavra()){
                t = r.getTextoPalavra();
                break;
            }
            no = no.getProximo();
        }
        
        return t;
    }
    public void mostrarLista(){
         No no = p.getInicio();
         
        while(no != null){
             System.out.print(no.getConteudo().getTextoPalavra()  + " ");
             System.out.print(no.getConteudo().getIdPalavra());
             no = no.getProximo();
             System.out.println("\n");
        }
         
    }
    public String normalizaString(String texto){
         return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }
}
