#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

struct Jogador
{
    int id;
    char nome[100];
    int altura;
    int peso;
    char universidade[100];
    int anoNascimento;
    char cidadeNascimento[100];
    char estadoNascimento[100];
};

typedef struct Jogador Jogador;

int nmovimentacoes;
int ncomparacoes;

//ler

void Lerid(Jogador *NBA,int cont)
{
    printf("%i", NBA[cont].id);
}

void Lernome(Jogador *NBA,int cont)
{
    printf("%s", NBA[cont].nome);
}

void Leraltura(Jogador *NBA,int cont)
{
    printf("%i", NBA[cont].altura);
}

void Lerpeso(Jogador *NBA,int cont)
{
    printf("%i", NBA[cont].peso);
}

void Leruniversidade(Jogador *NBA, int cont)
{
    printf("%s", NBA[cont].universidade);
}

void LeranoNascimento(Jogador *NBA, int cont)
{
    printf("%i", NBA[cont].anoNascimento);
}

void LercidadeNascimento(Jogador *NBA, int cont)
{
    printf("%s", NBA[cont].cidadeNascimento);
}

void LerestadoNascimento(Jogador *NBA,int cont)
{
    printf("%s", NBA[cont].estadoNascimento);
}

//imprimir

void ImprimirJogador (Jogador *NBA,int cont)
{
    printf("[");
    Lerid(NBA,cont);
    printf(" ## ");
    Lernome(NBA,cont);
    printf(" ## ");
    Leraltura(NBA,cont);
    printf(" ## ");
    Lerpeso(NBA,cont);
    printf(" ## ");
    LeranoNascimento(NBA,cont);
    printf(" ## ");
    Leruniversidade(NBA,cont);
    printf(" ## ");
    LercidadeNascimento(NBA,cont);
    printf(" ## ");
    LerestadoNascimento(NBA,cont);
    printf("]\n");
}

Jogador clone(Jogador Serclonado)
{
    Jogador* clone = (Jogador*)malloc(sizeof(Jogador));
    strcpy(clone->nome, Serclonado.nome);
    clone->id = Serclonado.id;
    clone->altura = Serclonado.altura;
    clone->peso = Serclonado.peso;
    strcpy(clone->universidade,Serclonado.universidade);
    clone->anoNascimento = Serclonado.anoNascimento;
    strcpy(clone->cidadeNascimento, Serclonado.cidadeNascimento);
    strcpy(clone->estadoNascimento, Serclonado.estadoNascimento);
    return *clone;
}

bool isFim(char entrada[])
{
    bool resp = false;
    if (strcmp(entrada,"FIM") == 0)
        resp = true;
    return resp;
}

int Trade(char temp[])
{
    int TAM = strlen(temp);
    int valores[TAM];
    int valor = 0;
    for (int i = 0;i < TAM;i++)
    {
        if (i != TAM - 1)
        {
            int dez = 1;
            int j=0;
            do
            {
                dez *= 10;
                j++;
            } while (j < TAM - i - 1);
            
            valores[i] = ((int) temp[i] - 48) * dez;
            valor += valores[i];
        }
        else
        {
            valor += (int) temp[i] - 48;
        }
    }
    return valor;
}

void Armazena(Jogador *NBA,char stringtemp[],int cont)
{
    char temp[100];
    int conttemp = 0;
    int contvirg = 0;
    for(int i = 0;i < strlen(stringtemp);i++)
    {
        if (stringtemp[i] != ',')
        {
            temp[conttemp] = stringtemp[i];
            conttemp++;
        }
        else
        {
            if (temp[0] != '0')
                temp[conttemp] = '\0';
            
            switch (contvirg)
            {
                case 0:NBA[cont].id = Trade(temp);
                    break;

                case 1: for (int j = 0; j < conttemp;j++)
                            NBA[cont].nome[j] = temp[j];
                    break;

                case 2: NBA[cont].altura = Trade(temp);
                    break;
                
                case 3: NBA[cont].peso = Trade(temp);
                    break;

                case 4: if (temp[0] == '0')
                            strcpy(temp, "nao informado");
                        strcpy (NBA[cont].universidade, temp);
                    break;

                case 5: NBA[cont].anoNascimento = Trade(temp);
                    break;

                case 6: if (temp[0] == '0')
                            strcpy (NBA[cont].cidadeNascimento, "nao informado");
                        for (int j = 0; j < conttemp;j++)
                            NBA[cont].cidadeNascimento[j] = temp[j];
                    break;

                default:
                    break;
            }
            contvirg++;
            for (int j = 0; j <= conttemp;j++)
                temp[j] = '0';
            conttemp = 0;
        }
    }
    if (stringtemp[strlen(stringtemp) - 1] == ',')
    {
        strcpy(temp, "nao informado"); 
        for (int j = 0; j < strlen(temp);j++)
            NBA[cont].estadoNascimento[j] = temp[j];
    }
    else
    {
        for (int j = 0; j < conttemp;j++)
            NBA[cont].estadoNascimento[j] = temp[j];
    }
    
}

bool pesquisa(Jogador *NBA, int n, char *palavra)
{
      bool resp = false;
      int dir = (n-1), esq = 0, meio;

        while (esq <= dir)
        {
            meio = (esq + dir) / 2;
            if(strcmp(palavra, NBA[meio].nome) == 0)
            {
                resp = true;
                esq = dir + 1;
            }
            else if (strcmp(palavra, NBA[meio].nome) > 0)
                esq = meio + 1;
            else
                dir = meio - 1;
        }
    return resp;
}

void leitura(Jogador *NBA, int valores[], int nvalores)
{
    FILE *arq;
    int contjogador = 0;
    for (int i = 0; i <= nvalores;i++)
    {
        arq = fopen("/tmp/players.csv", "r");
        if (arq == 0)//null
            printf("\n Erro de leitura do arquivo");
        char stringtemp[300];
        fscanf(arq,"%[^\n]\n", stringtemp);
        int contpara = -1;
        bool para = false;
        do
        {
            bool fim = false;
            char temp[5];
            for(int j = 0;!fim;j++)
            {
                if(stringtemp[j] != ',')
                    temp[j] = stringtemp[j];
                else
                {
                    fim = true;
                    if (temp[0] != '0')
                        temp[j] = '\0';
                }
            }
            int id = Trade(temp);
            if (id == valores[i])
            {
                para = true;
                Armazena(NBA,stringtemp,contjogador);
                contjogador++;
            }
            fscanf(arq,"%[^\n]\n", stringtemp);
            contpara++;
        }while(!para && contpara < 3922 ); 
        fclose(arq);
    }
}

int getMaiorFilho(int i, int tamHeap, Jogador* NBA)
    {
        int filho;
        if (2*i == tamHeap || NBA[2*i].altura > NBA[2*i+1].altura)
           filho = 2*i;
        else 
           filho = 2*i + 1;
        return filho;
    }

    void Heapsort(Jogador* NBA, int nNBA)
    {
        //Contrução do heap
        for (int tam = 2; tam <= nNBA; tam++)
        {
            for (int i = tam; i > 1 && NBA[i].altura > NBA[i/2].altura; i /= 2)
            {
                Jogador temp = clone(NBA[i]);
                NBA[i] = clone(NBA[i/2]);
                NBA[i/2] = temp;
            }
        }
        
        //Ordenacao propriamente dita
        int tam = nNBA;
        while (tam > 1)
        {
            Jogador temp = clone(NBA[tam]);
            NBA[tam] = clone(NBA[1]);
            NBA[1] = temp;
            tam--;
            int i = 1;
            while (i <= (tam/2))
            {
                int filho = getMaiorFilho(i, tam,NBA);
                if (NBA[i].altura <= NBA[filho].altura)
                {
                    if (NBA[i].altura < NBA[filho].altura || strcmp(NBA[i].nome,NBA[filho].nome) > 0)
                    {
                        temp = clone(NBA[i]);
                        NBA[i] = clone(NBA[filho]);
                        NBA[filho] = temp;
                        i = filho;
                    }
                    else
                        i = tam;
                }
                else
                    i = tam;		     
            }
        }
    }

void Log(float Temp)
{
    FILE* arq;
    arq = fopen("matricula_heapsort.txt", "w");
    fprintf(arq,"684903\t%f\t%d\t%d", Temp, ncomparacoes, nmovimentacoes);
    fclose(arq);
}

int main()
{
    ncomparacoes = 0;
    nmovimentacoes = 0;
    //tempo incial
    clock_t tempo;
	tempo = clock();
    int cont = 0;
    int contpalavras = 0;
    char entrada[100];
    int valores[3921];
    char palavras[3921];
    do
    {   
        fgets(entrada, 100, stdin);
        fflush(stdin);
        entrada[strlen(entrada) - 1] = '\0';
        if (!isFim(entrada))
        {
            valores[cont] = Trade(entrada);
            cont++;
        }
    } while (!isFim(entrada));

    Jogador NBA[1+cont];
    leitura(NBA, valores, cont);
    Heapsort(NBA, cont);

    for (int i = 0;i < 10;i++)
        ImprimirJogador(NBA, i);
    //Log com o tempo final
    Log((clock() - tempo) / (double)CLOCKS_PER_SEC);
    return 0;
}