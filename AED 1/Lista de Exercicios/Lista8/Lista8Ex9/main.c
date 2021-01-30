#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int mer,marc;
    float val,maival,maivaldois;
    bool ero,ero2;
    printf("\n Algoritmo de reestrutura de politicas empresarias.");
    do
    {
        printf("\n Digite o numero de mercadorias:");
        scanf("%d", &mer);
        ero = mer < 0;
    } while (ero);
    marc = mer;
    for (mer;mer != 0;mer--)
    {
        do
        {
            printf("\n Digite o valor da mercadoria:");
            scanf("%f", &val);
            ero2 = val < 0;
        } while (ero2);
        if (marc == mer)
        {
            if (val > 2000)
            {
                maival = 0;
                maivaldois = val;
            }
            else
            {
                maival = val;
                maivaldois = 0;
            }
        }
        if (val < 2000)
        {
            if (maival < val)
                maival = val;
        }
        else
        {
            if (maivaldois < val)
                maivaldois = val;
        }
    }
    printf("\n O maior preco entre as mercadorias de 2000 reais e %f", maival);
    printf("\n O maior preco entre as mercadorias acima de 2000 reais e %f", maivaldois);
    return 0;
}
