#include <stdio.h>
#include <stdlib.h>

int main()
{
    float plado,slado,tlado;
    printf("\n Algoritmo triangulo.");
    printf("\n Digite o primeiro lado do triangulo:");
    scanf("%f", &plado);
    printf("\n Digite o segundo lado do triangulo:");
    scanf("%f", &slado);
    printf("\n Digite o terceiro lado do triangulo:");
    scanf("%f", &tlado);
    //Esse if abaixo possui a condicao de existencia de um triangulo
    if (plado < slado + tlado && tlado < plado + slado)
    {
        // todos os lados iguais = triangulo equilatero
        if (plado == slado && plado == tlado)
        {
            printf("\n O triangulo e equilatero.");
        }
        // dois lados iguais = triangulo
        else
        {
            if (plado == slado || plado == tlado || slado == tlado)
            {
              printf("\n O triangulo e isosceles.");
            }
            else
            {
            printf("\n O triangulo e escaleno.");
            }
        }
    }
    else
    {
        printf("\n O triangulo nao atende as condicoes de existencia.");
    }
    return 0;
}
