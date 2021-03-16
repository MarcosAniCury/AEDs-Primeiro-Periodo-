#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool ehPalind(char x[]);

int main()
{
    char palavra[100];
    bool palindromo;
    printf("Algoritmos de polinomios.");
    printf("\n Escreva sua palavra:");
    scanf("%s",palavra);
    palindromo = ehPalind(palavra);
    if(palindromo)
        printf("\n Essa palavra e um palindromo.");
    else
        printf("\n Essa palavra nao e um palindromo.");
}

bool ehPalind(char palavra[])
{
    bool palindromo = true;
    int cont = 0;
    for(int cont2 = strlen(palavra) - 1;cont > -1;i--)
    {
        if(palavra[cont2] != palavra[cont])
            palindromo = false;
        cont++;
    }
    return y;
}
