#include <stdio.h>
#include <stdlib.h>

int main()
{
    float pes1,mas,pes2;
    int cod;
    printf("\n Algoritmo do peso em planetas.");
    printf("\n Digite seu peso na terra:");
    scanf("%f", &pes1);
    printf("\n Digite o codigo do planeta sendo \n 1-Mercurio \n 2-Venus \n 3-Marte \n 4-Jupiter \n 5-Saturno \n 6-Urano:");
    scanf("%d", &cod);
    mas = pes1 / 9.8;
    if (cod == 1)
    {
        pes2 = mas * 0.37;
        printf("\n O seu peso no planeta escolhido e %f", pes2);
    }
    else if (cod == 2)
    {
        pes2 = mas * 0.88;
        printf("\n O seu peso no planeta escolhido e %f", pes2);
    }
    else if (cod == 3)
    {
        pes2 = mas * 0.38;
        printf("\n O seu peso no planeta escolhido e %f", pes2);
    }
    else if (cod == 4)
    {
        pes2 = mas * 2.64;
        printf("\n O seu peso no planeta escolhido e %f", pes2);
    }
    else if (cod == 5)
    {
        pes2 = mas * 1.15;
        printf("\n O seu peso no planeta escolhido e %f", pes2);
    }
    else
    {
        pes2 = mas * 1.17;
        printf("\n O seu peso no planeta escolhido e %f", pes2);
    }
    return 0;
}
