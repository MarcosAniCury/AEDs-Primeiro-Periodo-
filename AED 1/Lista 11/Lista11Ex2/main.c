#include <stdio.h>
#include <stdlib.h>
#include "E:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"
//Favor verificar e corrigir local de destino da biblioteca.
void apresentacao();

int main()
{
    float lado;
    apresentacao();
    lado = valreal();
    printf("\n O perimetro do quadrado e %f", perimetroquadrado(lado));
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para o calculo do perimetro de um quadrado");
}
