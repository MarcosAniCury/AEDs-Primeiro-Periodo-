#include <stdio.h>
#include <stdlib.h>

const int NUM_LIN = 2;
const int NUM_COL = 2;

int main()
{
    float A[NUM_LIN][NUM_COL] = {{2,2},{2.5,3.5}}, diagonal;
    diagonal = (A[0][0] + A[1][1]) / 2;
    printf("\n A media da diagonal e %.2f", diagonal);
    return 0;
}
