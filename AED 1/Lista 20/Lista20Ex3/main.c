#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void ArmazenamentoDado(float M[2][2]);
int IgualdadeMatriz (float M[2][2],float M2[2][2]);

int main()
{
    float M[2][2],M2[2][2];
    bool resultado;
    ArmazenamentoDado(M);
    ArmazenamentoDado(M2);
    resultado = IgualdadeMatriz(M,M2);
    if (resultado)
        printf("\n As Matrizes sao identicas.");
    else
        printf("\n As Matrizes sao diferentes.");
    return 0;
}

void ArmazenamentoDado(float M[2][2])
{
    int cont,cont2;
    for (cont = 0;cont < 2;cont++)
    {
        for (cont2 = 0;cont2 < 2;cont2++)
        {
            printf("\n Digite o valor (%d,%d) da matriz:",cont + 1,cont2 + 1);
            scanf("%f", &M[cont][cont2]);
        }
    }
}

int IgualdadeMatriz (float M[2][2],float M2[2][2])
{
    int cont,cont2;
    bool resultado;
    for (cont = 0;cont < 2;cont++)
    {
        for (cont2 = 0;cont2 < 2;cont2++)
        {
            if (M[cont][cont2] == M2[cont][cont2])
                resultado = 1;
            else
            {
                resultado = 0;
                break;
            }
        }
        if (!resultado)
            break;
    }
    return resultado;
}
