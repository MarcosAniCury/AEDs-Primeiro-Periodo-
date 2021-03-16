#include <stdio.h>
#include <stdlib.h>
#include "E:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"
//Favor verificar e corrigir local de destino da biblioteca.
void apresentacao();

int main()
{
    int val;
    apresentacao();
    val = valint();
    numerointparimp(val);
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para identificar se um numero e par ou impar.");
}
