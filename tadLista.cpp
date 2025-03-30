#include <stdlib.h>
#include <stdio.h>
#define Max 1001
#define fantasma 63
#include <time.h>

typedef struct {
    int tam;
    unsigned char Tabela[Max];
} Lista;

Lista criarTabela(Lista lista){
    srand(time(NULL));
    lista.tam = 10;
    
    for(int i = 0;i < lista.tam; i++){
    	lista.Tabela[i] = rand()%19+1;
	}
	return lista;
}
int buscar(Lista lista, unsigned char elemento){
	int i = 0;
	int p = fantasma;
	bool achou = false;
	
	while(i < lista.tam && !achou){
		if(lista.Tabela[i] == elemento){
			p = i;
			achou = true;
		}else{
			i++;
		}
	}
	
	return p;
}
void mostrarLista(Lista lista){
	for(int i = 0; i <  lista.tam; i++){
		printf("%d ", lista.Tabela[i]);
	}
	printf("\n");
}

Lista buscarDuplicatas(Lista lista,unsigned char elemento){
	Lista posicoes;
	posicoes.tam = 0;
	
	for(int i = 0 ; i < lista.tam; i++){
		if(lista.Tabela[i] == elemento){
			posicoes.Tabela[posicoes.tam] = i;
			++posicoes.tam;
		}
	}
	return posicoes;
}

int main(){
	Lista lista;
	lista = criarTabela(lista);
	mostrarLista(lista);
	unsigned char elemento = 14;
	int posicao = buscar(lista,elemento);
	printf("%d", posicao);
	printf("\n");
	Lista posicoes = buscarDuplicatas(lista,elemento);
	mostrarLista(posicoes);
	
}