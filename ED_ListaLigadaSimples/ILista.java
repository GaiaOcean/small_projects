
/**
 * Escreva a descrição da interface IPalavra aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface ILista
{
    public String getPalavra(int id);
    public void addPalavra(String texto);
    public void removerPalavra(String texto);
    public void mostrarLista();
    public String normalizaString(String texto);
    //public Palavra escolherNoAleatorio();
}
