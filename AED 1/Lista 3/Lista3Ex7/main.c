#include <stdio.h>
#include <stdlib.h>

int main()
{
    float alt,peso,imc;
    printf("\n Algoritmo do IMC");
    printf("\n Digite seu peso(KG):");
    scanf("%f", &peso);
    printf("\n Digite sua altura(Metro):");
    scanf("%f", &alt);
    imc = peso/(alt * alt);
    if (imc < 16)
    {
        printf("\n A sua condicao e de magreza grave.");
    }
    else if (imc < 17)
    {
        printf("\n A sua condicao e de magreza moderada.");
    }
    else if (imc < 18.5)
    {
        printf("\n A sua condicao e de magreza leve.");
    }
    else if (imc < 25)
    {
        printf("\n A sua condicao e saudavel");
    }
    else if (imc < 30)
    {
        printf("\n A sua condicao e de sobrepeso");
    }
    else if (imc < 35)
    {
        printf("\n A sua condicao e de Obesidade Grau 1");
    }
    else if (imc < 40)
    {
        printf("\n A sua condicao e de Obesidade Grau 2");
    }
    else
    {
        printf("\n A sua condecao e de Obesidade Grau 3");
    }
    return 0;
}
