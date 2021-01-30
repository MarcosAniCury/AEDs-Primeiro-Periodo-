#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

const int NUM_LIN = 3;
const int NUM_COL = 3;

bool ValorReal(float A[NUM_COL][NUM_LIN],float Valor);
void Fim(bool resultado);

int main()
{
    float A[3][3] = {{2,2,2},{2.5,3.5,7},{2,5,4}}, Valor;
    bool Verificado;
    printf("\n Digite um valor real:");
    scanf("%f", &Valor);
    Verificado = ValorReal(A,Valor);
    Fim(Verificado);
    return 0;
}

bool ValorReal(float A[NUM_COL][NUM_LIN],float Valor)
{
    int cont,cont2;
    bool resultado = 0;
    for (cont = 0;cont < NUM_COL;cont++)
    {
        for (cont2 = 0;cont2 < NUM_LIN;cont2++)
        {
            if (A[cont][cont2] == Valor)
            {
                resultado = 1;
                break;
            }
        }
        if (resultado)
            break;
    }
    return resultado;
}

void Fim(bool resultado)
{
    if (!resultado)
        printf("\n O valor digitado nao existe dentro da matriz.");
    else
        printf("\n O valor digitado existe na matriz.");
}
