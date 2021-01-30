#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

float soma();
float subt();
float mult();
float divi();
float nu();
int main()
{
    int oper;
    float som,sub,mul,divis;
    bool ero;
    do
    {
        printf("\n Algoritmo de teste calculadora");
        printf("\n Digite a operacao desejada \n 0-Para sair do programa \n 1-Soma \n 2-Subtracao \n 3-Multiplicacao \n 4-Divisao:");
        scanf("%d", &oper);
        switch (oper)
        {
            case 0:
                ero = 0;
                printf("\n Obrigado por usar a minha calculadora.");
                break;
            case 1:
                som = soma();
                printf("\n O resultado da operacao e %f \n", som);
                break;
            case 2:
                sub  = subt();
                printf("\n O resultado da operacao e %f \n", sub);
                break;
            case 3:
                mul = mult();
                printf("\n O resultado da operacao e %f \n", mul);
                break;
            case 4:
                divis = divi();
                printf("\n O resultado da operacao e %f \n", divis);
                break;
            default:
                ero = 1;
        }
    } while (ero);
    return 0;
}

float soma()
{
    float val1,val2,som;
    printf("\n Soma");
    printf("\n Digite o primeiro valor:");
    scanf("%f", &val1);
    printf("\n Digite o segundo valor:");
    scanf("%f", &val2);
    som = val1 + val2;
    return som;
}

float subt()
{
    float val1,val2,sub;
    printf("\n Subtracao");
    printf("\n Digite o primeiro valor:");
    scanf("%f", &val1);
    printf("\n Digite o segundo valor:");
    scanf("%f", &val2);
    sub = val1 - val2;
    return sub;
}

float mult()
{
    float val1,val2,mul;
    printf("\n Multiplicacao");
    printf("\n Digite o primeiro valor:");
    scanf("%f", &val1);
    printf("\n Digite o segundo valor:");
    scanf("%f", &val2);
    mul = val1 * val2;
    return mul;
}

float divi()
{
    float val1,val2,divis;
    printf("\n Divisao");
    printf("\n Digite o primeiro valor:");
    scanf("%f", &val1);
    printf("\n Digite o segundo valor:");
    scanf("%f", &val2);
    divis = val1 / val2;
    return divis;
}
