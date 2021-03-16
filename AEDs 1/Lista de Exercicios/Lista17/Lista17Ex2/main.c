#include <stdio.h>
#include <stdlib.h>

int main()
{
    float aray[3];
    aray[2] = 9.7;
    aray[0] = 4.7;
    int local0 = 0, local2 = 2;
    printf("\n O primeiro valor de aray e %.2f, O segundo valor de aray e %.2f", aray[local0], aray[local2]);
    aray[1] = aray[local0];
    aray [local0] = aray[local2];
    aray[local2] = aray[1];
    printf("\n O primeiro valor final de aray e %.2f, O segundo valor final de aray e %.2f", aray[local0], aray[local2]);
    return 0;
}
