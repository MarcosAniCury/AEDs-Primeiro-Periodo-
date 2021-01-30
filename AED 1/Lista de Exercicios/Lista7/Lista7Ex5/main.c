#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int expoente,teste;
    float base;
    bool ero;
    do
    {
        printf("\n Algoritmo de potenciacao.");
        printf("\n Digite o valor da base:");
        scanf("%f", &base);
        printf("\n Digite o valor do expoente:");
        scanf("%d", &expoente);
        float base2 = base;
        ero = base > 0 && expoente >= 0;
        if (expoente > 1)
        {
            for(;expoente != 1;)
            {
                expoente = expoente - 1;
                base = base * base2;
            }
        }
        else if (expoente == 0)
        {
            base = 1;
        }
        if (ero != 1)
            printf("\n Valor invalido, era esperado na base um numero real e no expoente um valor maior ou igual a 0 inteiro.");
    }while (ero != 1);
    printf("\n O resultado da operacao e %f", base);
    return 0;
}
