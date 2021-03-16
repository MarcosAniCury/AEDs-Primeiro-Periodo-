#include <stdio.h>
#include <stdlib.h>
#include "E:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"
//Favor verificar e corrigir local de destino da biblioteca.
void apresentacao();

int main()
{
    int val;
    float fat;
    apresentacao();
    val = valint();
    printf("\n O resultado da conta e %f",fatorial(val));
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para calculo de fatorial.");
}
