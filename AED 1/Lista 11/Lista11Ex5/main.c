#include <stdio.h>
#include <stdlib.h>
#include "E:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"
//Favor verificar e corrigir local de destino da biblioteca.
void apresentacao();

int main()
{
    int pot;
    float base;
    apresentacao();
    base = valreal();
    pot = valint();
    printf("\n O resultado da conta e %f", potencia(base,pot));
    return 0;
}

void apresentacao()
{
    printf("\n Algortimo de potenciacao.");
}
