import javax.swing.JOptionPane;
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
   public static void main(String[] Args){
       CadAluno cad = new CadAluno();
       int qtdAlunos = cad.getQtdAlunos();
       Aluno[] aluno = new Aluno[qtdAlunos];
       int qtdAlunoCadastrado = 0;
       
       while(true){
           //String options = "Selecione uma opção: \n" + "1.Cadastrar um aluno\n" + "2.Remover um aluno\n"+"3.Mostrar alunos cadastrados\n";
           int choice = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma Opção: \n" + "1.Cadastrar um Aluno\n" +
                               "2.Remover um Aluno\n"+"3.Mostrar Alunos Cadastrados\n" + "4.Sair do Programa"));
           
           switch(choice){
               case 1:
                   if (qtdAlunoCadastrado < qtdAlunos) {
                        cad.inserirAluno(qtdAlunoCadastrado, aluno);
                        qtdAlunoCadastrado++;  // Increment the counter after adding a student
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há mais espaço para cadastrar novos alunos.");
                    }
                    break;
               case 2:
                   String ra = JOptionPane.showInputDialog("Forneça o ra do aluno que deseja remover");
                   cad.removerAluno(qtdAlunoCadastrado,ra,aluno);
                   break;
               case 3:
                   cad.mostrarAluno(qtdAlunoCadastrado,aluno);
                   break;
               case 4:
                   JOptionPane.showMessageDialog(null,"Saindo do programa");
                   System.exit(0);
                   break;
               default:
                   JOptionPane.showMessageDialog(null,"Opção inválida");
                   break;
           }
               
       }
       
   }
   
}
