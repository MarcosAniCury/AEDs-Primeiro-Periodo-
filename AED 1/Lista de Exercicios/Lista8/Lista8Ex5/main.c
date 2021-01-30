#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int nu,cont = 0,maiornu;
    float soma = 0;
    bool ero;
    printf("\n Algoritmo leitura de numeros naturais.");
    for (cont;cont != 10;cont++)
    {
        do
        {
            printf("\n Digite um numero natural:");
            scanf("%d", &nu);
            ero = nu < 0;
        } while(ero);
        if (cont == 1)
            maiornu = nu;
        if (maiornu < nu)
            maiornu = nu;
        soma += nu;
    }
    soma = soma / 10;
    printf("\n A media dos valores naturais e %f", soma);
    printf("\n O maior valor e %d", maiornu);
    return 0;
}
