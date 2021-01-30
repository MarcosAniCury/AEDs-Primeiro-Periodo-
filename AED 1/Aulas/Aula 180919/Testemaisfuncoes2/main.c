#include <stdio.h>
#include <stdlib.h>

float nu();
void soma(float n1,float n2);
int main()
{
    printf("\n Algoritmo de Soma de dois numeros.");
    float nu1,nu2;
    nu1 = nu();
    nu2 = nu();
    soma(nu1,nu2);
    return 0;
}

float nu()
{
    float nu1;
    printf("\n Digite o numero:");
    scanf("%f", &nu1);
    return nu1;
}

void soma(float n1,float n2)
{
    float som;
    som = n1 + n2;
    printf("\n O resultado da operacao e %f", som);
}
