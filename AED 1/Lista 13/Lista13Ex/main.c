#include <stdio.h>
#include <stdlib.h>

/*
Exercícios livro
7.1 a)Endereco
    b)NULL, 0 , endereço
    c)0
7.2 a)falso, pois variavéis do tipo register não podem ser usados como referencia
    b)falso, um ponteiro void não pode ser disferenciado
    c) Falso. Os ponteiros do tipo void podem receber ponteiros de outros tipos.
7.4 a) float *fPtr;
    b) fPtr = &numero1;
    c) printf(" \n O valor de fPtr é %f", *fPtr );
    d) numero2 = *fPtr;
    e) printf("\n O valor do numero2 e %f", numero2);
    f) printf("\n O endereço do numero1 e %p", &numero1);
    g) printf("\n O endereço armazenado em fptr e %p", fPtr );
7.5 a)void exchange( float *x, float *y );
    b)???
    c) int evaluate( int x, int *poly);
    d)???
*/

//PROFESSOR NAO COMPRENDI MUITO BEM A FUNCAO MALLOC

void apresentacao();
void maior(float *a, float *b, float *maiorValor);
void valrec(float *x);
void tela(float *z);

int main()
{
    float a,b,c;
    apresentacao();
    valrec(&a);
    valrec(&b);
    maior(&a,&b,&c);
    tela(&c);
    return 0;
}

void apresentacao()
{
    printf("\n O maior valor entre dois numeros.");
}

void maior(float *a, float *b, float *maiorValor)
{
   *maiorValor = *a;
   if(*b > *a) *maiorValor = *b;
}

void valrec(float *x)
{
        printf("\n Digite um valor:");
        scanf("%f",&*x);
}

void tela(float *z)
{
    printf("O maior valor e %f", *z);
}
