#include <stdio.h>
#include <stdlib.h>
#include "E:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"
//Favor verificar e corrigir local de destino da biblioteca.
void apresentacao();
void condicao(char primo);

int main()
{
    int val;
    char primo;
    apresentacao();
    val = valint();
    primo = numeroprimo(val);
    condicao(primo);
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para verificar se o numero e primo ou nao.");
}

void condicao(char primo)
{
    if (primo == 'S')
        printf("\n O valor digitado e primo.");
    else
        printf("\n O valor digitado nao e primo.");
}
