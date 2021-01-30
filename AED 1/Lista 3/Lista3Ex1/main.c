#include <stdio.h>
#include <stdlib.h>

int main()
{
    float a,b,c,soma;
    printf("\n Algortimo de comparação de dados.");
    printf("\n Digite o primeiro valor(A):");
    scanf("%f", &a);
    printf("\n Digite o segundo valor(B):");
    scanf("%f", &b);
    printf("\n Digite o terceiro valor(C):");
    scanf("%f", &c);
    soma = a + b;
    if (soma < c)
    {
        printf("\n A soma de a e b e menor que c.");
    }
    else
    {
        printf("\n A soma de a e b e maior que c");
    }
    return 0;
}
