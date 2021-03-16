#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nu,nu1;
    printf("\n Algoritmo Decrescente");
    printf("\n Digite o valor maximo:");
    scanf("%d", &nu);
    printf("\n Digite o valor minimo:");
    scanf("%d", &nu1);
    printf("\n %d", nu);
    while (nu != nu1)
    {
        nu = nu - 1;
        printf("\n %d", nu);
    }
    return 0;
}

