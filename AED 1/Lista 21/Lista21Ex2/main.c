#include <stdio.h>
#include <stdlib.h>

const int NUM_COL = 3;
const int NUM_LIN = 3;

float MaiorValor(float A[NUM_COL][NUM_LIN]);

int main()
{
    float A[3][3] = {{1,2,3},{4,5,6},{7,8,9}};
    float maiorvalor = MaiorValor(A);
    printf("\n O maior valor da primeiro linha e %f", maiorvalor);
    return 0;
}

float MaiorValor(float A[NUM_COL][NUM_LIN])
{
    float maiorval = 0;
    for (int i = 0;i < NUM_COL;i++)
    {
        if (A[i][0] > maiorval)
            maiorval = A[i][0];
    }
    return maiorval;
}
