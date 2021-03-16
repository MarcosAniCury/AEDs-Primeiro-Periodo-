#include <stdio.h>
#include <stdlib.h>

void apresentacao();
void leival(float aray[]);
float maival (float aray[]);
float tradeval(float aray[], int cont, int cont2);
void fim(float mai, int x, float aray[]);

const int TAM=5;

int main()
{
    apresentacao();
    float aray[TAM];
    leival(aray);
    float mai=maival(aray);
    fim(mai, 0, aray);
    return 0;
}

void apresentacao()
{
    printf("\n Programa para calcular maior valor de array");
}

void leival(float aray[])
{
    for(int cont = 0; cont < TAM; cont++)
    {
        printf("\n Digite um dos valores: ");
        scanf("%f", &aray[cont]);
    }
}

float maival (float aray[])
{
    float maior;
    for(int cont =TAM - 1; cont > 0; cont--)
    {
        for(int cont2 = 0; cont2 < cont ; cont2++)
        {
            if(aray[cont2] > aray[cont2 + 1])
            {
                maior=tradeval(aray, cont2, cont2 + 1);
            }
        }
    }
    return maior;
}

float tradeval(float aray[], int cont, int cont2)
{
    float aux=aray[cont];
    aray[cont] = aray[cont2];
    aray[cont2] = aux;
    return cont2;
}

void fim(float mai, int x, float aray[])
{
    if(x < TAM)
    {
        printf(" \n %g", aray[x]);
        fim(mai, x + 1,aray);
    }
}
