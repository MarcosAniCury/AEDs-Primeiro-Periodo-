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

struct TabelaHash
{
    Jogador tabela[100];
    int n;
};

typedef struct TabelaHash Hash;

int ncomparacoes;

/*
    ----Funcoes do Jogador-----
*/

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

/*
    -----Funcoes do hash------
*/

void startTabela(Hash* tabelaH, int tamTab)
{
    for(int i = 0;i < tamTab;i++)
        tabelaH[i].n = 0;
}

int hash(int elemento)
{
    return elemento % 25;
}

void inserir(Hash* tabelah,Jogador elemento)
{
    int pos = hash(elemento.altura);
    if (tabelah[pos].n < 100)
        tabelah[pos].tabela[tabelah[pos].n++] = elemento;
}

bool pesquisa(Hash* tabelah, int tamTab, char nome[])
{
    bool retorno = false;
    for(int i = 0;i < tamTab;i++)
    {
        int nLista = tabelah[i].n;
        for(int j = 0;j < nLista;j++)
        {
            if (strcmp(nome,tabelah[i].tabela[j].nome) == 0)
            {
                retorno = true;
                j = nLista;
                i = tamTab;
            }
        }
    } 
    return retorno;
}

/*
    ---Funcoes main---
*/

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

void Armazena(Hash* tabelaH, char stringtemp[])
{
    char temp[100];
    int conttemp = 0;
    int contvirg = 0;
    Jogador NBA;
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
                case 0:NBA.id = Trade(temp);
                    break;

                case 1: for (int j = 0; j < conttemp;j++)
                            NBA.nome[j] = temp[j];
                    break;

                case 2: NBA.altura = Trade(temp);
                    break;
                
                case 3: NBA.peso = Trade(temp);
                    break;

                case 4: if (temp[0] == '0')
                            strcpy(temp, "nao informado");
                        strcpy (NBA.universidade, temp);
                    break;

                case 5: NBA.anoNascimento = Trade(temp);
                    break;

                case 6: if (temp[0] == '0')
                            strcpy (NBA.cidadeNascimento, "nao informado");
                        for (int j = 0; j < conttemp;j++)
                            NBA.cidadeNascimento[j] = temp[j];
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
            NBA.estadoNascimento[j] = temp[j];
    }
    else
    {
        for (int j = 0; j < conttemp;j++)
            NBA.estadoNascimento[j] = temp[j];
    }
    inserir(tabelaH, NBA);
}

void leitura(Hash* tabelaH, int valores[], int nvalores)
{
    FILE *arq;
    for (int i = 0; i <= nvalores;i++)
    {
        arq = fopen("players.csv", "r");
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
                Armazena(tabelaH,stringtemp);
            }
            fscanf(arq,"%[^\n]\n", stringtemp);
            contpara++;
        }while(!para && contpara < 3922 ); 
        fclose(arq);
    }
}

void Log(float Temp)
{
    FILE* arq;
    arq = fopen("matricula_hashIndireta.txt", "w");
    fprintf(arq,"684903\t%f\t%d", Temp, ncomparacoes);
    fclose(arq);
}

int main()
{
    ncomparacoes = 0;
    //tempo incial
    clock_t tempo;
	tempo = clock();
    int cont = 0;
    int contpalavras = 0;
    char entrada[100];
    int valores[3921];
    char palavras[3921];

    int tamTab = 25;
    Hash tabelaH[tamTab];
    startTabela(tabelaH,tamTab);

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

    leitura(tabelaH, valores, cont);

    do
    {   
        fgets(entrada, 100, stdin);
        fflush(stdin);
        entrada[strlen(entrada) - 1] = '\0';
        if (!isFim(entrada))
        {
            printf("%s ", entrada);
            if(pesquisa(tabelaH, tamTab, entrada))
                printf("SIM");
            else
                printf("NAO");
        }
    } while (!isFim(entrada));

    //Log com o tempo final
    Log((clock() - tempo) / (double)CLOCKS_PER_SEC);
    return 0;
}