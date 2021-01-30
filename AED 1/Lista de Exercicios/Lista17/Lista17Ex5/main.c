#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void idade(int *soma,int *calculamedia,int D[]);
int calculomedia (int *soma, int *calculamedia, int D[]);
void fim (int idamaior);

int main()
{
    int soma = 0,D[1000],calculamedia = 0,idamaior;
    idade(&soma,&calculamedia,D);
    calculomedia(&soma,&calculamedia,D);
    idamaior = calculomedia(&soma,&calculamedia,D);
    fim (idamaior);
    return 0;
}

void idade(int *soma,int *calculamedia,int D[])
{
    int ida;
    const int flag = 0;
    bool ero;
    do
    {
        do
        {
            printf("\n Digite a idade:");
            scanf("%d", &ida);
            ero = ida > 150 || ida < 0;
            if (ero)
                printf("\n Valor invalido digite novamente");
            else
            {
                *soma += ida;
                D[*calculamedia] = ida;
                *calculamedia++;
            }
        }while(ero);
    }while (ida != flag);
}

int calculomedia (int *soma, int *calculamedia, int D[])
{
    int contador = *calculamedia,idademaior = 0;
    *calculamedia = *soma / *calculamedia;
    for (int cont = 0; cont <= contador;cont++)
    {
        if (D[cont] > *calculamedia)
            idademaior++;
    }
    return idademaior;
}

void fim (int idamaior)
{
    printf("\n Temos %d alunos com a idade acima da media", idamaior);
}
