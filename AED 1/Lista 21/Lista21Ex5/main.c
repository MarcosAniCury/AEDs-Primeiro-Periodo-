#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

const int NUM_LIN = 3;
const int NUM_COL = 3;

bool Linhaigual(float A[NUM_COL][NUM_LIN]);
void Fim(bool resultado);

int main()
{
    float A[3][3] = {{2,2,2},{2.5,3.5,7},{2,2,4}};
    bool resultado = Linhaigual(A);
    Fim(resultado);
    return 0;
}

bool Linhaigual(float A[NUM_COL][NUM_LIN])
{
    int cont,cont2 = 0;
    bool resultado = 0;
    for (cont = 0;cont < NUM_LIN;cont++)
    {
        if (A[0][cont] == A[2][cont])
            cont2++;
    }
    if (cont2 == NUM_LIN)
        resultado = 1;
    return resultado;
}

void Fim(bool resultado)
{
    if (resultado)
        printf("\n A primeira linha e a ultima possuem todos os valores iguais.");
    else
        printf("\n A primeira linha e a ultima nao possuem todos os valores iguais.");
}
