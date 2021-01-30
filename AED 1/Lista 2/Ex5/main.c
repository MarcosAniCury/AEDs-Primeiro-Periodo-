#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int ano,teste;
    bool bi;
    printf("\n Algoritmo ano bissexto.");
    printf("\n Digite o ano:");
    scanf("%d", &ano);
    //ano bissexto e divisiveis por 400, ano bissexto e divisivel por 4 e nao divisivel por 100
    if (ano%400== 0)
    {
        bi = 0;
    }
    else if (ano%4 == 0 && ano%100 != 0)
    {
        bi = 0;
    }
    else
    {
        bi = 1;
    }
    if (bi == 0)
    {
        printf("\n O ano e bissexto.");
    }
    else
    {
        printf("\n O ano nao e bissexto.");
    }
    return 0;
}
