#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *arq;
    arq = fopen("exemplo.dat", "w");
    fclose(arq);
    return 0;
}
