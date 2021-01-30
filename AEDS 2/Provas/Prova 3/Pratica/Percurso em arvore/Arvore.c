#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <malloc.h>

typedef struct No 
{
    int elemento;
	struct No *esq, *dir;
} No;

No* novoNo(int elemento)
{
    No* novo = (No*) malloc(sizeof(No));
    novo->elemento = elemento;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}

No* raiz;

void start()
{
    raiz = NULL;
}

void imprime(No* i) 
{ 
    if (i != NULL)
    {
        printf("%d ", i->elemento); 
        imprime(i->esq);
        imprime(i->dir);
    }
}

void imprimeEsq(No* esq)
{
    if (esq != NULL)
    {
        imprime(esq->esq);
        printf("%d ", esq->elemento); 
        imprime(esq->dir);
    }
}

void imprimeDir(No* dir)
{
    if(dir != NULL)
    {
        imprime(dir->esq);
        imprime(dir->dir);
        printf("%d ", dir->elemento);
    }
}

void inserir(int x)
{
    inserirRec(x, &raiz);
}

void inserirRec(int x, No** i)
{
    if (*i == NULL)
    {
        *i = novoNo(x);
    }
    else if (x < (*i)->elemento)
    {
        inserirRec(x, &((*i)->esq));
    }
    else if (x > (*i)->elemento)
    {
        inserirRec(x, &((*i)->dir));
    }
}

int main()
{
    int nTeste = 0;
    scanf("%i", &nTeste);
    for(int i = 0;i < nTeste; i++)
    {
        start();
        int nValores = 0;
        scanf("%i", &nValores);
        for(int j = 0;j < nValores;j++)
        {
            int valor = 0;
            scanf("%i", &valor);
            inserir(valor);
        }
        printf("Case %i:\n", i+1);
        imprime(raiz);
    }
}
