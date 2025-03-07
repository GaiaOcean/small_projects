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
	unsigned char numeros[10];
	unsigned char i;
	unsigned char random_num;
	unsigned char temp;
	unsigned char j;
	unsigned char seed;
	
	qtd_numeros = 9;
	
	for(i = 1; i <= qtd_numeros; i++){
		random_num = rand()%9+1;
		numeros[i] =  random_num;

	}
	numeros[0] = qtd_numeros ;

	for(j = 0; j <= qtd_numeros; j++){

		V[j] = numeros[j];
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

