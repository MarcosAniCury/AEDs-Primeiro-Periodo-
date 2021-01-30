#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int fatorial,numero,teste;
    bool ero;
    do
    {
        printf("\n Algoritmo fatorial.");
        printf("\n Digite o numero para descobrir o seu fatorial:");
        scanf("%d", &numero);
        ero = numero > 0;
        if (ero)
        {
            for (fatorial = 1; numero > 1; numero = numero - 1)
                fatorial = fatorial * numero;
            printf("\n O valor resultante e %d", fatorial);

        }
        else
        {
            teste = ero;
            printf("\n Valor invalido, era esperado um valor inteiro positivo %d.", teste);
        }
    }while (!ero);
}
