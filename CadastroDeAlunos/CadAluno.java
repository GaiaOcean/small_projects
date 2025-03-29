import javax.swing.JOptionPane;
/**
 * Write a description of class CadAluno here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CadAluno
{
   public void inserirAluno(int qtdAlunoCadastrado, Aluno[] aluno){ //recebe um array e a qtd de alunos a pessoa ja cadastrou
        String nome = JOptionPane.showInputDialog("Forneca o nome do aluno: ");
        
        // Entrada da idade do aluno (atraves do teclado)
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Forneca a idade do aluno: "));
    
        // Entrada de uma identificacao do aluno (atraves do teclado)
        String rg = JOptionPane.showInputDialog("Forneca o rg do aluno : ");
    
        // Entrada da ra do aluno (atraves do teclado)
        String ra = JOptionPane.showInputDialog("Forneca o ra do aluno: ");
    
        // Entrada do curso do aluno (atraves do teclado)
        String curso = JOptionPane.showInputDialog("Forneca o curso do aluno: ");
    
        // Entrada da idade do aluno (atraves do teclado)
        int periodo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o periodo do aluno: "));
            
        aluno[qtdAlunoCadastrado] = new Aluno(nome,idade,rg,ra,curso,periodo);
        JOptionPane.showMessageDialog(null,"Aluno cadastrado com sucesso");   
   }
   public void removerAluno(int qtdAlunoCadastrado,String ra, Aluno[] aluno){
       if(qtdAlunoCadastrado == 0){
           JOptionPane.showMessageDialog(null,"Não exitem alunos cadastrados");
           return;
       }
       for(int i = 0; i < aluno.length;i++){
           if(ra != null && aluno[i].getRa().equals(ra)){
               aluno[i] = null;
               JOptionPane.showMessageDialog(null,"Aluno removido com sucesso");               
               return;
           }
       }
      
       
   }
   public void mostrarAluno(int qtdAlunoCadastrado, Aluno[] aluno){
       String lista = "";
       

       for(int i = 0;i <qtdAlunoCadastrado;i++){
           if(aluno[i] != null){
               lista += aluno[i].toString()+ "\n\n";
           }
       }
       if(!lista.isEmpty()){
           JOptionPane.showMessageDialog(null,lista,"Alunos Cadastrados", JOptionPane.INFORMATION_MESSAGE);
       }else{
           JOptionPane.showMessageDialog(null,"Não existe alunos cadastrado");
       }
       
   }
   public int getQtdAlunos(){
        
        boolean isValid = false;
        int qtdAlunos = 0;
        while(!isValid){
             qtdAlunos = Integer.parseInt(JOptionPane.showInputDialog("Forneca a quantidade de alunos: "));
             if(qtdAlunos > 0){
                 isValid = true;
             }
             
        }
        
        return qtdAlunos;
   }
  
}
