#include <stdio.h>
#include <stdlib.h>

int main()
{
    char letr;
    printf("\n Algoritmo de Vogal");
    printf("\n Digite uma letra:");
    scanf("%c", &letr);
    if (letr == 'a' || letr == 'e' || letr == 'i' || letr == 'o' || letr == 'u')
    {
        printf("\n A letra digitada e uma vogal.");
    }
    else
    {
        printf("\n A letra digitada e uma consoante.");
    }
    return 0;
}
