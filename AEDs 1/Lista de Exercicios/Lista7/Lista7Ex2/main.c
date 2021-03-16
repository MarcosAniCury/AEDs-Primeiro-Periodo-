#include <stdio.h>
#include <stdlib.h>

int main()
{
    int ter;
    float h = 0,nu = 100;
    printf("\n Algoritmo para calcular o valor de H");
    printf("\n Digite o numero de termos:");
    scanf("%d", &ter);
    for (ter;ter >= 1 ;ter--)
    {
        h += 1.0/nu;
        nu -= 3;
        printf("\n %f \n %f", h,nu);
    }
    printf("\n O valor de H e %f", h);
    return 0;
}
