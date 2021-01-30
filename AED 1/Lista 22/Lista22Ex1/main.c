#include <stdio.h>
#include <stdlib.h>

const int NUM_LINHAS = 3;
const int NUM_COLUNAS = 3;

float ValorMinMax(float A[NUM_LINHAS][NUM_COLUNAS]);

int main()
{
    float A[3][3] = {{2,3,4},{4,5,9},{9,4,10}}, MINMAX;
    MINMAX = ValorMinMax(A);
    printf("\n O valor MinMax da matriz e %f", MINMAX);
    return 0;
}

float ValorMinMax(float A[NUM_LINHAS][NUM_COLUNAS])
{
    float valmin = A[0][0],maival;
    int linha = 0;
    for (int cont = 0;cont < NUM_LINHAS;cont++)
    {
        for(int cont2 = 0;cont2 < NUM_COLUNAS;cont2++)
        {
            if(A[cont][cont2] < valmin)
            {
                valmin = A[cont][cont2];
                linha = cont;
            }
        }
    }
    maival = A[linha][0];
    for (int cont = 0;cont < NUM_COLUNAS;cont++)
    {
        if(A[linha][cont] > maival)
            maival = A[linha][cont];
    }
    return maival;
}
