#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nu;
    printf("\n Algoritmo para identificar se o numero e par ou impar.");
    printf("\n Digite um numero inteiro:");
    scanf("%d", &nu);
    if (nu%2 == 0)
    {
        printf("\n O numero digitado e par.");
    }
    else
    {
        printf("\n O numero digitado e impar.");
    }
    return 0;
}
