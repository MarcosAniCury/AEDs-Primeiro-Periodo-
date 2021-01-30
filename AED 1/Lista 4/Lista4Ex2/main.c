#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nu = 11;
    printf("\n Algoritmo Decrescente");
    do
    {
        nu = nu - 1;
        printf("\n %d", nu);
    }
    while (nu != 1);
    return 0;
}
