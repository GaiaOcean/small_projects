
/**
 * Write a description of class TestaArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestaArray
{
    public static void main(String args[]){
        Armazenagem alunos = new ListaArray();
        Aluno aluno1 = new Aluno("João", 20, "123", "2023001", "Computer Science", 2);
        alunos.inserirAluno(aluno1);
        alunos.mostrarLista();
        alunos.removerAluno("2023001");
        alunos.mostrarLista();
    }
}
