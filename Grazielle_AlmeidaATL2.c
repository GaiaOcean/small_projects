/* atividade L2 */
/*arquivo: Grazielle_AlmeidaATL2.c
Autores: Geovanna Cristina Brenzinger
		 Grazielle Batista de Almeida
		 Isabela Nunes dos Santos
		 Luana Gabrielle Rodrigues Macedo
Data: 01/04/25 
Descrição: verificar existência de duplicatas em uma matriz do pequeno sudoku
*/


#include <stdio.h> 
#include <string.h> 
#include "Booleano.h"

bool verificarRepetido(unsigned char V[10]);

int main(){
    unsigned char geral[10][10]; 
    unsigned char linha[20];    
    FILE *entrada;
    int i,lin,col,n,j;
	entrada = fopen("SUDOKUCerto.txt","r");
    if (entrada == NULL)  {
		printf("\n nao encontrado \n");
    }else {
        lin = 0;  
        while(fscanf(entrada, "%20s", linha)==1){
            lin = lin + 1;		
			n = strlen(linha); 
            for(i=0;i<=8;i++)geral[lin][i+1] = linha[i];	
        } 
             
       	fclose(entrada); 
    } 
    
   
   for(lin=1; lin <= 9; lin++){
        for(col=1; col <= 9; col++){
            printf(" %c",geral[lin][col]); 
        } 
       	printf("\n");
    }  
	printf("\n");
	
	bool has_duplicata = FALSE;
	i = 1;
	while(i <= 9 && has_duplicata != TRUE){
		if(verificarRepetido(geral[i])){
			printf("INCORRETO");
			has_duplicata = TRUE;
		}
		i++;
	}
	
	i = 1;
	
	while(i <= 9 && has_duplicata != TRUE){
		unsigned char col[9];
		for(j = 1; j <= 9;j++){
			col[j-1] = geral[j][i];
		}
		if(verificarRepetido(col)){
			printf("INCORRETO");
			has_duplicata = TRUE;
		}
		i++;
	}
	
	if(has_duplicata == FALSE){
		printf("CORRETO");
	}

		
	return 0;
}

bool verificarRepetido(unsigned char V[]){
	bool tem_duplicata;
	unsigned char i;
	unsigned char j;	

	
	tem_duplicata = FALSE;
	i = 0;
	
	while(i < 9 && tem_duplicata != TRUE){
		j = i + 1;
		while(j < 9 && tem_duplicata != TRUE){
			if(V[i]==V[j]){
				tem_duplicata = TRUE;
			} else {
				j = j + 1;
			}	
		}
		i = i + 1;
	}		
	
	return tem_duplicata;
}