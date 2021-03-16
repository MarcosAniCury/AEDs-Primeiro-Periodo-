#include <stdio.h>
#include <stdlib.h>

int main()
{
    int cont = 0;
    float h = 0,nu = 1;
    printf("\n Algoritmo para calcular a precisao de H.");
    for (cont;cont != 10;cont++)
    {
        h += 1.0/nu;
        nu = nu*3;
    }
    printf("\n \n %f", h);
    return 0;
}
