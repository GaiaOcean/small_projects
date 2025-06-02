import java.io.BufferedReader;
import java.io.*;

public class Armazenagem implements IPersistencia {
    private ListaPalavra palavra;
    private ListaTraducao traducao;
    private DeckManager deck;
    public Armazenagem(ListaPalavra palavra, ListaTraducao traducao,DeckManager deck) {
        this.palavra = palavra;
        this.traducao = traducao;
        this.deck = deck;
    }

    @Override
    public void salvarTxt(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            No noPalavra = palavra.p.getInicio();
            No noTraducao = traducao.p.getInicio();

            while (noPalavra != null && noTraducao != null) {
                writer.write(noPalavra.getConteudo().getTextoPalavra() + ":" + noTraducao.getConteudo().getTextoPalavra());
                writer.newLine();
                noPalavra = noPalavra.getProximo();
                noTraducao = noTraducao.getProximo();
            }
            deck.addDeck(nomeArquivo);
            deck.saveDeckNamesToFile("decks.txt"); 
            System.out.println("Palavras e traduções salvas com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar palavras no arquivo: " + e.getMessage());
        }
    }

    @Override
    public boolean carregarTxt(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    palavra.addPalavra(partes[0].trim());
                    traducao.addPalavra(partes[1].trim());
                }
            }
            System.out.println("Palavras e traduções carregadas com sucesso de " + nomeArquivo);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao carregar palavras do arquivo: " + e.getMessage());
            return false;
        }
    }
}
