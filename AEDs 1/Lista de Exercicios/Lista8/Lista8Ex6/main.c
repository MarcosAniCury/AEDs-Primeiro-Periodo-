#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int nu,maiornu;
    float soma = 0;
    bool ero;
    const int flag = 0;
    printf("\n Algoritmo leitura de numeros naturais.");
    do
    {
        do
        {
            printf("\n Digite um numero natural:");
            scanf("%d", &nu);
            ero = nu < 0;
        } while(ero);
        if (soma == 0)
            maiornu = nu;
        if (maiornu < nu)
            maiornu = nu;
        soma += nu;
    }while (nu != flag);
    soma = soma / 10;
    printf("\n A media dos valores naturais e %f", soma);
    printf("\n O maior valor e %d", maiornu);
    return 0;
}
