#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nu = 10,nu1 = 100,cont = 0;
    printf("\n Algoritmo de sequencia.");
    for (cont;cont != 10;cont++)
    {
        if (cont%2 == 0)
            printf("\n %d/%d", nu,nu1);
        else
            printf("\n %d/%d", nu1,nu);
        nu++;
        nu1--;
    }
    return 0;
}
