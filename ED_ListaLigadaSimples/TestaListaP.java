import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Escreva uma descrição da classe TestaListaP aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class TestaListaP
{
    public static void main(String[] args) {
        Id id = new Id();
        ListaPalavra listap = new ListaPalavra(id);
        ListaTraducao listat = new ListaTraducao(id);
        DeckManager deck = new DeckManager();
        Armazenagem arquivo = new Armazenagem(listap,listat,deck);
       
        listap.addPalavra("Cat");
        listat.addPalavra("Gato");
        listap.addPalavra("Dog");
        listat.addPalavra("Cachorro");
        listap.addPalavra("Pencil");
        listat.addPalavra("Lápis");
        listap.addPalavra("Apple");
        listat.addPalavra("Maçã");
        listap.addPalavra("School");
        listat.addPalavra("Escola");
        Game game = new Game(listap,listat);
        //arquivo.salvarTxt("Palavras.txt");
        //arquivo.salvarTxt("Palavras.txt");
        //arquivo.carregarTxt("Palavras.txt");
        List <Integer> nodes = new ArrayList<>();
        nodes = listap.p.escolherNoAleatorio();
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while(!game.perdeu() && i < nodes.size()){
            System.out.println(listap.getPalavra(nodes.get(i)));
        
            System.out.print("Your guess: ");
            String guess = scanner.nextLine();
            guess = listat.normalizaString(guess);
            game.verificarIgualdade(guess,nodes.get(i));
            System.out.println("Trad certa = " + listat.getPalavra(nodes.get(i)));
            System.out.println(game.getPontuacao());
            System.out.println(game.getCoracoes());
            i++;
        }
        //System.out.println(listap.p.getQtdNos());
        //Testa Game class
        //listap.mostrarLista();
        //listat.mostrarLista();
        
    }
}
