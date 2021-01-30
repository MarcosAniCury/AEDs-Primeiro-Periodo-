#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int fat,mult;
    bool ero;
    do
    {
        printf("\n Algoritmo de fatorial.");
        printf("\n Digite o valor q voce deseja retirar o fatorial:");
        scanf("%d", &fat);
        ero = fat < 0;
        if (!ero)
        {
            if (fat == 0)
            {
                printf("\n Valor do fatorial e 1");\
                return 0;
            }
            for (mult = 1; fat > 1; fat--)
                    mult = mult * fat;
            printf("\n O valor resultante e %d", mult);
        }
    }while (!ero);
    return 0;
}
