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

void eliminarElemento(Lista* lista, unsigned char elemento){
	int i;
	int j = 0;
	
	for(i = 0; i <= lista->tam; i++){
		if(lista->Tabela[i] != elemento){
			lista->Tabela[j++] = lista->Tabela[i];
		}
	}
	lista->tam = j - 1;
}

Lista eliminarElementoCopy(Lista lista, unsigned char elemento){
	Lista newList;
	newList.tam = 0;
	
	for(int i = 0; i < lista.tam; i++){
		if(lista.Tabela[i] != elemento){
			newList.Tabela[newList.tam] = lista.Tabela[i];
			++newList.tam;
		}
	}
	return newList;
}

void removerTdsDuplicatas(Lista* lista) {
    int i, k, j;
    for(i = 0; i < lista->tam; i++) {
        for(j = i + 1; j < lista->tam; j++) {
            if(lista->Tabela[i] == lista->Tabela[j]) {
                for(k = j; k < lista->tam - 1; k++) {
                    lista->Tabela[k] = lista->Tabela[k + 1];
                }
                lista->tam--;
                j--;
            }
        }
    }
}


int main(){
	Lista lista;
	lista = criarTabela(lista);
	mostrarLista(lista);
	unsigned char elemento = 3;
	int posicao = buscar(lista,elemento);
	printf("%d", posicao);
	printf("\n");
	Lista posicoes = buscarDuplicatas(lista,elemento);
	mostrarLista(posicoes);
	printf("\n");
	eliminarElemento(&lista,elemento);
	mostrarLista(lista);
	printf("\n");
	Lista newList = eliminarElementoCopy(lista,elemento);
	mostrarLista(newList);
	printf("\n");
	removerTdsDuplicatas(&lista);
	mostrarLista(lista);
	
}