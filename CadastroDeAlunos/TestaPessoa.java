import javax.swing.JOptionPane;

/**
 * Testa a classe Pessoa.
 * 
 * @author Julio Arakaki
 * @version 20250326
 */
public class TestaPessoa {
    public static void main(String[] args) {
        // Entrada de um nome (atraves do teclado)
        String nome= JOptionPane.showInputDialog("Forneca o nome: ");
        // Entrada de um nome (atraves do teclado)
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Forneca a idade: "));
        // Entrada de uma identificacao (atraves do teclado)
        String rg = JOptionPane.showInputDialog("Forneca o rg: ");

        // Criacao de uma instancia da classe Pessoa
        Pessoa p = new Pessoa(nome, idade, rg);
        
        // Mostra os dados
        System.out.println("Nome              : " + p.getNome() + " (" + p.getQtdePalavras()+ " palavras)");
        System.out.println("Nome invertido    : " + p.getNomeInvertido());
        System.out.println("Nome bibliografico: " + p.getNomeBiblio());
    }
}
