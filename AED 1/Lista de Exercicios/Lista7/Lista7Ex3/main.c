#include <stdio.h>
#include <stdlib.h>

int main()
{
    int ter,nu = 1,nu2 = 100;
    printf("\n Algoritmo de senquencia.");
    printf("\n Digite a quantidade de termos da sequencia:");
    scanf("%d", &ter);
        for(ter;ter > 0;ter--)
        {
            int temp,temp2;
            if (ter%2)
                printf("\n O termo e %d/%d", nu,nu2);
            else
                printf("\n O termo e %d/%d", nu2,nu);
            nu += 1;
            nu2 -= 3;
        }
    return 0;
}
