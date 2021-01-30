#include <stdio.h>
#include <stdlib.h>

int main()
{
    float altura,id,gen;
    printf("\n Peso ideal.");
    printf("\n Digite sua altura:");
    scanf ("%f", &altura);
    printf("\n Se seu genero for Masculino digite 1, se seu genero foi Feminino digite 2:");
    scanf ("%f", &gen);
    if (gen == 1)
    {
        id = (72.7*altura)-58;
    }
    else
    {
        id = (62.1*altura)-44.7;
    }
    printf("\n Seu peso ideal e:%f \n", id);
    return 0;
}
