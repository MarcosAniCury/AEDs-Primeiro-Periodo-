#include <stdio.h>
#include <stdlib.h>

int main()
{
    float cont = 0,nu,mainu,mennu;//men e menor,mai e maior
    printf("\n Algoritmo maior e menor numero.");
    printf("\n Digite um numero:");
    scanf("%f", &nu);
    mainu = nu;
    mennu = nu;
    for (cont;cont <= 8;cont++)
    {
        printf("\n Digite um numero:");
        scanf("%f", &nu);
        if (nu > mainu)
            mainu = nu;
        else if (nu < mennu)
            mennu = nu;
    }
    printf("\n O maior numero e %f", mainu);
    printf("\n O menor numero e %f", mennu);
    return 0;
}
