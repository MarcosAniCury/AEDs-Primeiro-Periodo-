#include <stdio.h>
#include <stdlib.h>

const int NUM_LIN = 3;
const int NUM_COL = 3;

int main()
{
    float A[3][3] = {{2,2,2},{2.5,3.5,7},{2,5,4}}, diagonal;
    diagonal = (A[1][0] + A[2][1]) / 2;
    printf("\n A media dos valores acima da diagonal e %.2f", diagonal);
    return 0;
}
