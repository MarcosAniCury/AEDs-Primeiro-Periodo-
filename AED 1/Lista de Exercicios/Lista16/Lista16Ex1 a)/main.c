#include <stdio.h>
#include <stdlib.h>

void apresentacao();
void leval(float aray[]);
float maival(float aray[]);
float tradeval(float aray[], int i, int k);
void fim(float maior);
const int TAM=5;
int main()
{
    apresentacao();
    float aray[TAM];
    leval(aray);
    float mai = maival(aray);
    fim(mai);
    return 0;
}

void apresentacao()
{
    printf("\nEsse programa calcula o maior valor dentro de um arranjo\n");
}

void leval(float aray[])
{
    for(int i=0; i < TAM; i++)
    {

        printf("\nDigite um dos valores: ");
        scanf("%f", &aray[i]);
    }
}

float maival(float aray[])
{
    float maior;
    for(int k=TAM-1; k>0; k--)
    {
        for(int i=0; i<k; i++)
        {
            if(aray[i] > aray[i+1])
            {
                maior = tradeval(aray, i, i+1);
            }
        }
    }
    return maior;
}

float tradeval(float aray[], int i, int k)
{
    float aux=aray[i];
    aray[i]=aray[k];
    aray[k]=aux;
    return k;
}

void fim(float maior)
{
    printf("\nO maior valor eh:%g", maior);
}
