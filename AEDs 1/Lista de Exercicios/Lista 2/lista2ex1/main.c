#include <stdio.h>
#include <stdlib.h>

int main()
{
    float pnu,snu;
    printf("\n Algoritmo de comparacao numerica.\n");
    printf("\n Digite o primeiro numero:");
    scanf("%f", &pnu);
    printf("\n Digite o segundo numero:");
    scanf("%f", &snu);
    if (pnu > snu)
    {
        printf("\n O primeiro numero e maior que o segundo.");
    }
    else
    {
        printf("\n O segundo numero e maior que o primeiro.");
    }
    return 0;
}
