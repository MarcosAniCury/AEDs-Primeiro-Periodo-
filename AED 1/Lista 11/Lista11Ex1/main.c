#include <stdio.h>
#include <stdlib.h>
#include "E:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"
//Favor verificar e corrigir local de destino da biblioteca.
void apresentacao();

int main()
{
    float A,B;
    apresentacao();
    A = valreal();
    B = valreal();
    maiorentre2f(A,B);
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para calcular o maior valor entre dois valores reais.");
}
