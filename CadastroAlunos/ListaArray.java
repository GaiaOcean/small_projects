import java.util.ArrayList;
/**
 * Write a description of class ListaArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListaArray implements Armazenagem
{
   private ArrayList <Aluno> lista;
   
   public ListaArray(){
       setLista(new <Aluno>ArrayList());
   }
   
   private ArrayList <Aluno> getLista(){
       return lista;
   }
   
   public int getTamanho(){
       return lista.size();
   }
   
   private void setLista(ArrayList <Aluno> lista){
       this.lista = lista;
   }
   public void inserirAluno(Aluno aluno){
       lista.add(aluno);
   }
   
   public void removerAluno(String ra){
       int pos = buscarRa(ra);

       if(pos != -1){
           lista.remove(pos);
       }else{
           System.out.println("Aluno não encontrado");
       }
   }
   
   public int buscarRa(String ra){
       int pos = -1;
       int i = 0;
       
       while(pos == -1 || i < lista.size()){
           if(lista.get(i).getRa().equals(ra)){
               pos = i;
           }
           i ++;
       }
       
       return pos;
       
   }
   
    public void mostrarLista(){

       String list = "";
       int nAluno = 0;
       
       if(lista.size() > 0){
           
         for(int i = 0;i < lista.size();i++){

           if(lista.get(i) != null){
               nAluno++;
               list += "----------------- Aluno " + nAluno + "----------------\n";
               list += lista.get(i).toString()+ "\n\n";
           }

           }
            System.out.println(list); 
       }else{
            System.out.println("Não existem alunos cadastrados"); 
       }
   }

   
   
   
   
   
}
