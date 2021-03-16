#include <stdio.h>
#include <stdlib.h>
//Verificar se o destino da biblioteca esta correto
//A resposta da um e a=2 e  b=5

/***************************************************************
 * Assinatura da função:???
 * Data da elaboração:25/09/2019
 * Autor:Marcos Ani Cury
 * Objetivo:Calcular o maior valor entre dois numeros
 * Dados de entrada (argumentos):a,b
 * Dado de saída (valor gerado pela função):Void
 **************************************************************** */

void maiorentre2f(float *x,float *y);//1
void valrea(float *b);//7
void valreal(float *a);//7
void apresentacao();

int main()
{
    float a,b;
    apresentacao();
    valreal(&a);
    valreal(&b);
    maiorentre2f(&a,&b);
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para calcular o maior valor entre dois valores reais.");
}

void valreal(float *a)//7
{
    printf("\n Digite um valor:");
    scanf("%f", &*a);
}

void maiorentre2f(float *x,float *y)//1
{
    if (*x > *y)
        printf("\n O primeiro valor e maior.");
    else if (*y > *x)
        printf("\n O segundo valor e maior.");
    else
        printf("\n Os valores possuem valor iguais.");
}
