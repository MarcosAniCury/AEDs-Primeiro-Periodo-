#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    float val,valmai = 0,valmen = 99999999,dif;
    bool ero1 = 1;//menor q zero
    printf("\n Algoritmo de leitura de conjutos de valores inteiros e positivo.");
    do
    {
        printf("\n Digite o valor do conjunto (se desejar encerrar digite 0):");
        scanf("%f", &val);
        if (val < 0)
            printf("\n Valor invalido, era esperado um valor acima positivo ou nulo, digite novamente");
        else if (val == 0)
        {
            printf("\n Programa encerrado, obrigado.");
            ero1 = 0;
        }
        else if (val > valmai)
            valmai = val;
        else if (val < valmen)
            valmen = val;
    }while(ero1);//fim while menor que zero
    dif = valmai - valmen;
    printf("\n A amplitude entre o maior valor e o menor e %f", dif);
    return 0;
}
