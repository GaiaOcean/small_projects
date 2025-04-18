//Atividade L1
//arquivo: Grazielle_AlmeidaATL1.c
//Autores: Geovanna Cristina Brenzinger
//		 Grazielle Batista de Almeida
//		 Luana Gabrielle Rodrigues Macedo
//		 Isabela Nunes dos Santos
//Data: 11/03/2025
//Descrição: verificar existência de duplicatas em uma lista

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

 
void construirNumeros(unsigned char V[]){
	srand(time(NULL));
	unsigned char qtd_numeros;
	unsigned char i;
	unsigned char j;
	
	qtd_numeros = 9;
	V[0] = qtd_numeros;
	
	for(i = 1; i <= qtd_numeros; i++){
		V[i] =  rand()%9+1;
	}
}

void mostrarNumeros(unsigned char V[]){
	unsigned char i;

	for(i = 1; i < 10; i++){
		printf("%d ", V[i]);
	}
	printf("\n");
}

bool verificarRepetido(unsigned char V[]){
	bool has_duplicate;
	unsigned char i;
	unsigned char j;
	
	has_duplicate = false;
	i = 1;
	
	while(i < V[0] && has_duplicate != true){
		j = i + 1;
		while(j < V[0] && has_duplicate != true){
			if(V[i]==V[j]){
				has_duplicate = true;
			}else{
				j += 1;
			}
		}
		i += 1;
	}
	return has_duplicate;
}

int main(){
	unsigned char V[10];
	construirNumeros(V);
	mostrarNumeros(V);
}
