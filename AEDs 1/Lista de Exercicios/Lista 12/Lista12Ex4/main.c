#include <stdio.h>
#include <stdlib.h>
#include "E:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"

void apresentacao();

int main()
{
    float val1,val2,val3;
    apresentacao();
    val1 = valreal();
    val2 = valreal();
    val3 = valreal();
    printf("\n O maior valor e %f", smaiorentre3f(val1,val2,val3));
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para calcular o segundo maior valor.");
}



