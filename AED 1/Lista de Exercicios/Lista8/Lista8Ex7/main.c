#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int nu;
    bool ero;
    do
    {
        printf("\n Algoritmo numeros primos.");
        printf("\n Digite um numero natural que vc deseje sabe se e primo:");
        scanf("%d", &nu);
        ero = nu < 0;
    }while(ero);
    if (nu == 1)
        printf("\n O numero digitado e primo.");
    else if (nu == 2)
        printf("\n O numero digitado e primo.");
    else if (nu == 3)
        printf("\n O numero digitado e primo.");
    else if (nu == 5)
        printf("\n O numero digitado e primo.");
    else if  (nu == 7)
        printf("\n O numero digitado e primo.");
    else if (nu%2 == 0)
        printf("\n O numero digitado nao e primo.");
    else if (nu%3 == 0)
        printf("\n O numero digitado nao e primo.");
    else if (nu%5 == 0)
        printf("\n O numero digitado nao e primo.");
    else if (nu%7 == 0)
        printf("\n O numero digitado nao e primo.");
    else
        printf("\n O numero digitado e primo.");
    return 0;
}
