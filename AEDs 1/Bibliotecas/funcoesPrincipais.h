/* ********************************************
    * Assinatura da funcao:By Marcos
    * Data de elaboracao:22/09/2019
    * Autor:Marcos Ani Cury Vinagre Silva
    * Objetivo:Facilitar a elaboracao de novos sistemas
    * Dados de entrada(argumentos):1-x,y; 2-lado; 3-val; 4-numero; 5-val,expoente; 6-numero; 7-Void; 8-Void;
    * Dado de saida(Valor gerado pela funcoe):1-Void; 2-(float)perimetro; 3-Void; 4-(float)fatorial; 5-(float)potencia; 6-(char)primo; 7-(float)val; 8-(int)val;
*********************************************** */

void maiorentre2f(float x,float y)//1
{
    if (x > y)
        printf("\n O primeiro valor e maior.");
    else if (y > x)
        printf("\n O segundo valor e maior.");
    else
        printf("\n Os valores possuem valor iguais.");
}

float perimetroquadrado(float lado)//2
{
    float perimetro;
    perimetro = 4*lado;
    return perimetro;
}

void numerointparimp(int val)//3
{
    if (val % 2 == 0)
    {
        printf("\n O valor digitado e par.");
    }
    else
    {
        printf("\n O valor digitado e impar.");
    }
}

float fatorial(int numero)//4
{
    int fatorial = 1;
    if (numero > 0)
    {
        for (fatorial; numero > 1; numero = numero - 1)
            fatorial = fatorial * numero;
    }
    return fatorial;//se fatorial retornar 1 o valor nao era valido
}

float potencia(float val,int expoente)//5
{
    float pot = 1;
    for(int cont = 1;cont <= expoente;cont++)
        pot = pot * val;
    return pot;
}

char numeroprimo(int numero)//6
{
    int divisor = 0;
    char primo = 'N';
    for (int cont = 1;cont <= numero;cont++)
    {
        if (numero % cont == 0)
            divisor++;
    }
    if (divisor == 2)
        primo = 'S';
    return primo;
}

float valreal()//7
{
    float val;
    printf("\n Digite um valor:");
    scanf("%f", &val);
    return val;
}

int valint()//8
{
    int val;
    do
    {
        printf("\n Digite um valor inteiro:");
        scanf("%d", &val);
    } while(val <= 0);
    return val;
}

void maiorentre2f_2(float x,float y)//1
{
	if (x > y)
		{
		printf("\n O primeiro valor e maior.");
		printf("\n %f", x);
		}
	else if (y > x)
		{
		printf("\n O segundo valor e maior.");
		printf(" \n %f", y);
		}
	else
		printf("\n Os valores possuem valor iguais.");
}

float smaiorentre3f(float val1,float val2,float val3)
{
    float maival;
    if (val1 > val2 && val1 > val3)
        maival = val1;
    else if (val2 > val1 && val2 > val3)
        maival = val2;
    else if (val3 > val1 && val3 > val2)
        maival = val3;
    return maival;
}
