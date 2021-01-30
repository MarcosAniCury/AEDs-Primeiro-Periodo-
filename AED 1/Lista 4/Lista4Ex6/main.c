#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void main()
{//begin main
    //inicializacao de variaveis
    int ano,teste;
    char letr;
    bool bi,enq = 1,enq1 = 1 ;
    printf("\n Algoritmo ano bissexto.");
    while (enq == 1)
    {//begin while
        printf("\n Digite o ano:");
        scanf("%d", &ano);
        //ano bissexto e divisiveis por 400, ano bissexto e divisivel por 4 e nao divisivel por 100
        if (ano%400== 0)
            bi = 0;
        else if (ano%4 == 0 && ano%100 != 0)
            bi = 0;
        else
            bi = 1;
        if (bi == 0)
            printf("\n O ano e bissexto.");
        else
        {//begin else
            printf("\n O ano nao e bissexto.");
        }//end else
        while (enq1 == 1)
        {//begin while
            //opcao de se manter no programa ou nao
            printf("\n Deseja continuar(s ou n):");
            scanf("\n %c", &letr);
            printf("%c", letr);
            if (letr != 's' || letr != 'n')
                printf("\n Opcao invalida tentar novamente.");
            else
            enq1 = 0;
            if (letr == 'n')
                enq = 0;

        }//end while
    }//end while
}//end main
