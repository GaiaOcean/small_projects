import javax.swing.JOptionPane;
/**
 * Write a description of class CadAluno here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CadAluno
{
    
   Entrada ent = new Entrada();
   
   public void inserirAluno(int qtdAlunoCadastrado, Aluno[] aluno){ //recebe um array e a qtd de alunos a pessoa ja cadastrou
        String nome = ent.lerDados("Forneca o nome do aluno: ");
        // Entrada da idade do aluno (atraves do teclado)
        int idade =  ent.validarNumero("Forneça a idade do aluno: ");
                 
        // Entrada de uma identificacao do aluno (atraves do teclado)
        String rg = ent.lerDados("Forneca o rg do aluno : ");
    
        // Entrada da ra do aluno (atraves do teclado)
        String ra = ent.validarRa("Forneca o ra do aluno: ");
    
        // Entrada do curso do aluno (atraves do teclado)
        String curso = ent.lerDados("Forneca o curso do aluno: ");
    
        // Entrada da idade do aluno (atraves do teclado)
        int periodo = ent.validarNumero("Forneca o periodo do aluno: ");
            
        aluno[qtdAlunoCadastrado] = new Aluno(nome,idade,rg,ra,curso,periodo);
        Saida.mostrarMsg("Aluno cadastrado com sucesso", ent.getModoGrafico());   
   }
   public void removerAluno(int qtdAlunoCadastrado,String ra, Aluno[] aluno){
       if(qtdAlunoCadastrado == 0){
           Saida.mostrarMsg("Não exitem alunos cadastrados", ent.getModoGrafico());
           return;
       }
       for(int i = 0; i < aluno.length;i++){
           if(ra != null && aluno[i].getRa().equals(ra)){
               aluno[i] = null;
               Saida.mostrarMsg("Aluno removido com sucesso", ent.getModoGrafico());               
               return;
           }
       }
   }
   public void mostrarAluno(int qtdAlunoCadastrado, Aluno[] aluno){

       String lista = mostrarArray(qtdAlunoCadastrado,aluno);

       if(!lista.isEmpty()){

          Saida.mostrarMsg(lista, ent.getModoGrafico());

       }else{

           Saida.mostrarMsg("Não existe alunos cadastrado", ent.getModoGrafico());

       }

   }

   public int getQtdAlunos(){

        boolean isValid = false;

        int qtdAlunos = 0;

        while(!isValid){

             qtdAlunos = ent.validarNumero("Forneca a quantidade de alunos: ");

             if(qtdAlunos > 0){

                 isValid = true;

             }

        }

        return qtdAlunos;

   }

   public String mostrarArray(int qtdAlunoCadastrado, Aluno[] aluno){

       String lista = "";

         for(int i = 0;i <qtdAlunoCadastrado;i++){

           if(aluno[i] != null){

               lista += aluno[i].toString()+ "\n\n";

           }

       }

       return lista;

    }
    
}
  

