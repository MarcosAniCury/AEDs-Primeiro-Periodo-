#include <stdio.h>
#include <stdlib.h>

int main()
{
    int aray[2];
    aray[0] = 20;
    aray[2] = 40;
    printf("\n O primeiro valor de aray e %d, o terceiro valor de aray e %d", aray[0], aray[2]);
    aray[1] = aray[0];
    aray[0] = aray[2];
    aray[2] = aray[1];
    printf("\n O primeiro valor final de aray %d, o segundo valor final de aray e %d", aray[0],aray[2]);
    return 0;
}
