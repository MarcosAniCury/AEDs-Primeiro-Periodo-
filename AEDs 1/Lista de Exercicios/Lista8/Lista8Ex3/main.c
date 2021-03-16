#include <stdio.h>
#include <stdlib.h>

int main()
{
    int cont ;
    float h = 0,nu = 1;
    printf("\n Algoritmo para calcular a precisao de H.");
    printf("\n Digite o numero de termos desejado:");
    scanf("%d", &cont);
    for (cont;cont != 0;cont--)
    {
        h += 1.0/nu;
        nu = nu*3;
    }
    printf("\n \n %f", h);
    return 0;
}
