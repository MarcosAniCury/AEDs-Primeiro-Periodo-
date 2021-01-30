#include <stdio.h>
#include <stdlib.h>

void apres();
float valreal();
float soma(float nu1,float nu2);
void fim(float som);
int main()
{
    float val1,val2,som;
    apres();
    val1 = valreal();
    val2 = valreal();
    som = soma(val1,val2);
    fim(som);
    return 0;
}

void apres()
{
    printf("\n Algoritmo para Somar dois numeros.");
}

float valreal()
{
    float val;
    printf("\n Digite um numero real:");
    scanf("%f", &val);
    return val;
}

float soma(float nu1,float nu2)
{
     float som = nu1 + nu2;
     return som;
}

void fim(float som)
{
    printf("\n O valor obtido da soma e %f", som);
}
