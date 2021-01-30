#include <stdio.h>
#include <stdlib.h>

const int NUM_LIN = 3;
const int NUM_COL = 3;

float Maiorvalor(float A[NUM_COL][NUM_LIN]);
void Fim(float resultado);

int main()
{
    float A[3][3] = {{2,9,9},{20,3.5,7},{20,20,40}};
    float resultado = Maiorvalor(A);
    Fim(resultado);
    return 0;
}

float Maiorvalor(float A[NUM_COL][NUM_LIN])
{
    int cont,cont2 = 0;
    float maiorvalor = 0;
    for (cont = 1;cont < NUM_COL;cont++)
    {
        if (maiorvalor < A[0][cont])
            maiorvalor = A[0][cont];
    }
    if (A[1][2] > maiorvalor)
        maiorvalor = A[1][2];
    return maiorvalor;
}

void Fim(float resultado)
{
    printf("\n O maior valor acima da diagonal e %f", resultado);
}
