
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private ListaPalavra listap;
    private ListaTraducao listat;
    private int pontuacao;
    private int highestPontuacao;
    private int coracoes;
    public Game(ListaPalavra listap, ListaTraducao listat){
        this.listap = listap;
        this.listat = listat;
        this.pontuacao = 0;
        this.highestPontuacao = 0;
        this.coracoes = 3;
    }
       
    public void verificarIgualdade(String texto, int id){
        String word = listat.getPalavra(id);
        if(word.equals(texto)){
            incrementaPontuacao();
        }else{
            if(getPontuacao() > 0){
                decrementaPontuacao();
            }
            decrementaCoracoes();
        }
    }
    public int getHighestPontuacao(){
        return this.highestPontuacao;
    }
    private void setHighestPontuacao(int pontuacao){
        if (pontuacao > this.highestPontuacao) {
            this.highestPontuacao = pontuacao;
        }
    }

    public boolean perdeu(){
        return getCoracoes() == 0;
    }
    public int getCoracoes(){
        return coracoes;
    }
    private void setCoracoes(int coracoes){
        this.coracoes = coracoes;
    }
    private void decrementaCoracoes(){
        this.coracoes--;
    }
    public int getPontuacao(){
        return pontuacao;
    }
    private void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }
    private void incrementaPontuacao(){
        this.pontuacao++;
    }
    private void decrementaPontuacao(){
        this.pontuacao--;
    }
}














