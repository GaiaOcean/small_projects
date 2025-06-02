
/**
 * Escreva uma descrição da classe Id aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Id
{
    // variáveis de instância 
    private int id = 1;
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void incrementarId(){
        this.id = this.id + 1;
    }
    
    public void decrementaId(){
        this.id--;
    }
   
}
