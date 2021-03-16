#include <stdio.h>
#include <stdlib.h>

int main()
{
    float nu1,nu2,raz,val;
    int nu;
    printf("\n Algoritmo PA");
    printf("\n Digite o primeiro termo da PA:");
    scanf("%f", &nu1);
    printf("\n Digite o segundo termo da PA:");
    scanf("%f", &nu2);
    raz= nu2 - nu1;
    printf("\n Digite o numero do termo que voce deseja:");
    scanf("%d", &nu);
    val = nu1 + (nu - 1)*raz;
    printf("\n O valor do termo e %f", val);
    return 0;
}
