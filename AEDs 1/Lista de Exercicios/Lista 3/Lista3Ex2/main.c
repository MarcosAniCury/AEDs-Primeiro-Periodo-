#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c;
    printf("\n Algoritmo decresente.");
    printf("\n Digite o primeiro numero inteiro:");
    scanf("%d", &a);
    printf("\n Digite o segundo numero inteiro:");
    scanf("%d", &b);
    printf("\n Digite o terceiro numero inteiro:");
    scanf("%d", &c);
    if (a > b && b > c)
    {
        printf("\n primeiro numero:%d", a);
        if (b > c)
        {
            printf("\n segundo numero:%d \n terceiro numero:%d", b,c);
        }
        else
        {
            printf("\n segundo numero:%d \n terceiro numero:%d", c,b);
        }
    }
    else if (b > a && a > c)
    {
        printf("\n primeiro numero:%d", b);
        if (a > c)
        {
            printf("\n segundo numero:%d \n terceiro numero:%d", a,c);
        }
        else
        {
            printf("\n segundo numero:%d \n terceiro numero:%d", c,a);
        }
    }
    else
    {
        printf("\n primeiro numero:%d", c);
        if (a > b)
        {
            printf("\n segundo numero:%d \n terceiro numero:%d", a,b);
        }
        else
        {
            printf("\n segundo numero:%d \n terceiro numero:%d", b,a);
        }
    }
    return 0;
}
