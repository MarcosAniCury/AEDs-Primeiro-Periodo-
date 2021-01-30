#include <stdio.h>
#include <stdlib.h>

void EncherArranjo(float A[]);
int ContNumerosNegativos(float A[]);

int main()
{
    float A[100];
    int cont;
    EncherArranjo(A);
    cont = ContNumerosNegativos(A);
    printf("\n O total de numeros negativos no Arranjo real e de %d", cont);
    return 0;
}

void EncherArranjo(float A[])
{
    for (int cont = 0; cont != 100;cont++)
    {
        printf("\n Digite o %d termo do Arranjo:", cont);
        scanf("%f", &A[cont]);
    }
}

int ContNumerosNegativos(float A[])
{
    int conta = 0;
    for (int cont = 0;cont != 100;cont++)
    {
        if(A[cont] < 0)
            conta++;
    }
    return conta;
}
