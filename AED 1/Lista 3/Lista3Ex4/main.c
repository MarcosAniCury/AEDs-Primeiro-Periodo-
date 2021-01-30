#include <stdio.h>
#include <stdlib.h>

int main()
{
    int dia;
    printf("\n Algoritmo de Dia da semana");
    printf("\n Digite o dia da semana em forma de numero (sendo 1 domingo e 7 sabado):");
    scanf("%d", &dia);
    if (dia == 1)
    {
        printf("\n O dia digitado foi domingo.");
    }
    else if (dia == 2)
    {
        printf("\n O dia digitado foi segunda.");
    }
    else if (dia == 3)
    {
        printf("\n O dia digitado foi terca.");
    }
    else if (dia == 4)
    {
        printf("\n O dia digitado foi quarta.");
    }
    else if (dia == 5)
    {
        printf("\n O dia digitado foi quinta.");
    }
    else if (dia == 6)
    {
        printf("\n O dia digitado foi sexta.");
    }
    else
    {
        printf("\n O dia digitado foi sabado.");
    }
    return 0;
}
