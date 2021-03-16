#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{//begin main
    //Declaracao de variavel
    float nu,nu1;
    int choi;
    bool enq = 0;
    printf("\n Aloritmo de calculadora.");
    //primeiro valor
    printf("\n Bem vindo a calculadora.");
    printf("\n Digite o primeiro valor:");
    scanf("%f", &nu);
    while (enq == 0)
    {//begin while
        //segundo valor
        printf("\n Digite o segundo valor:");
        scanf("%f", &nu1);
        //menu com escolhas
        printf("Digite a operacao desejada \n 1-Sair do programa \n 2-Soma \n 3-Subtracao \n 4-Multiplicacao \n 5-Divisao:");
        scanf("%d", &choi);
        //swtich das escolhas
        switch (choi)
        {//begin switch
            case 1:
                    //sair do programa
                    enq = 1;
                    printf("\n Obrigado por usar esse programa.");
                    break;
            case 2:
                    //soma
                    nu = nu + nu1;
                    break;
            case 3:
                    //subtracao
                    nu = nu - nu1;
                    break;
            case 4:
                    //multiplicacao
                    nu = nu * nu1;
                    break;
            case 5:
                    //divicao
                    nu = nu / nu1;
        }//end switch
        //if de apresentar o valor caso nao deseje sair do programa
        if (enq != 1)
            printf("\n O valor da operacao e:%f", nu);
        //end if
    }//end while
    return 0;
}//end main
