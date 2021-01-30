#include <stdio.h>
#include <stdlib.h>

int main()
{
    float nu,por,snu = 0;
    int cont = 0;
    const float flag = 0;
    printf("\n Algoritmos de salario.");
    printf("\n Digite o valor do seu salario:");
    scanf("%f", &nu);
    do
    {
        if(nu != flag)
        {
            if (nu < 1000)
            {
                por = (10 * nu) / 100;
                printf("\n O valor de reajuste sera de %f", por);
                nu += por;
                printf("\n O valor atual do salario e de %f", nu);
                cont++;
                snu += nu;
            }
            else if (nu >= 1000 && nu < 2000)
            {
                por = (8 * nu) / 100;
                printf("\n O valor de reajuste sera de %f", por);
                nu += por;
                printf("\n O valor atual do salario e de %f", nu);
                cont++;
                snu += nu;
            }
            else if (nu >= 2000)
            {
                por = (7 * nu) / 100;
                printf("\n O valor de reajuste sera de %f", por);
                nu += por;
                printf("\n O valor atual do salario e de %f", nu);
                cont++;
                snu += nu;
            }
            printf("\n Digite o valor do seu salario:");
            scanf("%f", &nu);
        }
    }while(nu != flag);
    snu = snu / cont;
    printf("\n O salario medio e %f", snu);
    return 0;
}
