
/**
 * Implementa um "template" (tipo de dados) para criar 
 * objetos Pessoa.
 * 
 * @author Julio Arakaki
 * @version 20250326
 */

public class Pessoa {
    // Variaveis de instancia
    // ou Variaveis de estado
    // ou Atributos
    private NomePessoa nome; // Nome a pessoa
    private int idade;       // Idade da pessoa
    private String rg;       // Identificacao da pessoa 

    /**
     * Construtor. "constroi uma pessoa". Metodo chamado na criacao 
     * de um objeto da classe
     * @param nome (NomePessoa) Nome da pessoa
     * @param idade (int) Idade da pessoa
     * @param id (String) Identificacao da pessoa
     */
    public Pessoa(String nome, int idade, String rg) {
        setNome(nome);
        setIdade(idade);
        setId(rg);
    }

    private void setNome(String nome){
        this.nome = new NomePessoa(nome);
    }

    private void setIdade(int idade){
        this.idade = idade;
    }

    private void setId(String rg){
        this.rg = rg;
    }

    /**
     * Retorna o nome da pessoa
     *
     * @return (String) nome da pessoa
     */
    public String getNome(){
        return(this.nome).getNome();
    }

    /**
     * Retorna a idade da pessoa
     *
     * @return (int) idade da pessoa
     */
    public int getIdade(){
        return(this.idade);
    }

    /**
     * Retorna a identificacao da pessoa
     *
     * @return (String) identificacao da pessoa
     */
    public String getRg(){
        return(this.rg);
    }

    /**
     * Retorna a qtde de palavras do nome 
     *
     * @return (int) qtde de palavras
     */
    public int getQtdePalavras(){
        return this.nome.getQtdePalavras();
    }

    /**
     * Retorna o nome invertido
     *
     * @return (String) nome invertido
     */
    public String getNomeInvertido(){
        return this.nome.getNomeInvertido();
    }

    /**
     * Retorna o nome bibliografico
     *
     * @return(String) nome bibliografico
     */
    public String getNomeBiblio(){
        return this.nome.getNomeBiblio();
    }

    /**
     *  Retorna dados da pessoa
     *  @return (String) Dados de uma pessoa
     */
    public String toString() {
        String str = " ";
        str = str + "Nome: " + getNome();
        str = str +  "\nIdade: " + getIdade();
        str = str + "\nRg: " + getRg();
        return str;
    }
}
