#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

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

Jogador lista[4000]; //Lista
int nLista;//elementos na Lista 
Jogador listaRemovidos[4000]; //Lista Removidos
int nListaR;//elementos na Lista Removidos

//ler

void Lerid(Jogador elemento)
{
    printf("%i", elemento.id);
}

void Lernome(Jogador elemento)
{
    printf("%s", elemento.nome);
}

void Leraltura(Jogador elemento)
{
    printf("%i", elemento.altura);
}

void Lerpeso(Jogador elemento)
{
    printf("%i", elemento.peso);
}

void Leruniversidade(Jogador elemento)
{
    printf("%s", elemento.universidade);
}

void LeranoNascimento(Jogador elemento)
{
    printf("%i", elemento.anoNascimento);
}

void LercidadeNascimento(Jogador elemento)
{
    printf("%s", elemento.cidadeNascimento);
}

void LerestadoNascimento(Jogador elemento)
{
    printf("%s", elemento.estadoNascimento);
}

//imprimir

void ImprimirJogadorLista (Jogador elemento)
{
    printf(" ## ");
    Lernome(elemento);
    printf(" ## ");
    Leraltura(elemento);
    printf(" ## ");
    Lerpeso(elemento);
    printf(" ## ");
    LeranoNascimento(elemento);
    printf(" ## ");
    Leruniversidade(elemento);
    printf(" ## ");
    LercidadeNascimento(elemento);
    printf(" ## ");
    LerestadoNascimento(elemento);
    printf("]\n");
}

void ImprimirJogadorListaRemovidos(Jogador elemento)
{
    printf("(R) ");
    Lernome(elemento);
}

Jogador clone(Jogador Serclonado)
{
    Jogador clone;
    strcpy(clone.nome, Serclonado.nome);
    clone.id = Serclonado.id;
    clone.altura = Serclonado.altura;
    clone.peso = Serclonado.peso;
    strcpy(clone.universidade,Serclonado.universidade);
    clone.anoNascimento = Serclonado.anoNascimento;
    strcpy(clone.cidadeNascimento, Serclonado.cidadeNascimento);
    strcpy(clone.estadoNascimento, Serclonado.estadoNascimento);
    return clone;
}
//listaRemovidos

void InserirFimR(Jogador elemento)
{
     if(nListaR == 4000)
        printf("Erro lista cheia\n");
    else
    {
        listaRemovidos[nListaR] = elemento;
        nListaR++;
    }
}

//lista

void StartLista()
{
    nLista = 0;
    nListaR = 0;
}

void InserirInicio(Jogador elemento)
{
    //lista cheia
    if (nLista == 4000)
        printf("Erro Lista cheia\n");
    //lista vazia
    else if (nLista == 0)
    {
        lista[nLista] = elemento;
        nLista++;
    }
    else
    {
        for (int i = nLista - 1;i >= 0;i--)
            lista[i+1] = lista[i];   
        lista[0] = elemento;
        nLista++;
    }
}

void InserirFim(Jogador elemento)
{
    if(nLista == 4000)
        printf("Erro lista cheia\n");
    else
    {
        lista[nLista] = elemento;
        nLista++;
    }
}

void Inserir(Jogador elemento, int pos)
{
    for (int i = nLista - 1;i >= pos;i--)
        lista[i+1] = lista[i];
    lista[pos] = elemento;
    nLista++;
}

Jogador RemoverInicio()
{
    Jogador retorno = lista[0];
    for (int i = 1;i < nLista;i++)
        lista[i - 1] = lista[i];
    nLista--;
    return retorno; 
}

Jogador RemoverFim()
{
    Jogador retorno = lista[nLista-1];
    nLista--;
    return retorno;
}

Jogador Remover(int pos)
{
    Jogador retorno = lista[pos];
    for (int i = pos + 1;i < nLista;i++)
        lista[i - 1] = lista[i]; 
    nLista--;
    return retorno;
}

//funcao da main

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

Jogador Armazena(char stringtemp[])
{
    char temp[100];
    int conttemp = 0;
    int contvirg = 0;
    Jogador tmp;
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
                case 0:tmp.id = Trade(temp);
                    break;

                case 1: for (int j = 0; j < conttemp;j++)
                            tmp.nome[j] = temp[j];
                    break;

                case 2: tmp.altura = Trade(temp);
                    break;
                
                case 3: tmp.peso = Trade(temp);
                    break;

                case 4: if (temp[0] == '0')
                            strcpy(temp, "nao informado");
                        strcpy (tmp.universidade, temp);
                    break;

                case 5: tmp.anoNascimento = Trade(temp);
                    break;

                case 6: if (temp[0] == '0')
                            strcpy (tmp.cidadeNascimento, "nao informado");
                        for (int j = 0; j < conttemp;j++)
                            tmp.cidadeNascimento[j] = temp[j];
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
            tmp.estadoNascimento[j] = temp[j];
    }
    else
    {
        for (int j = 0; j < conttemp;j++)
            tmp.estadoNascimento[j] = temp[j];
    }
    return tmp;
}

void leitura(int valores[], int nvalores)
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
                InserirFim(Armazena(stringtemp));
            }
            fscanf(arq,"%[^\n]\n", stringtemp);
            contpara++;
        }while(!para && contpara < 3922); 
        fclose(arq);
    }
}

Jogador ler1elemento(int valor)
{
    FILE *arq;
    arq = fopen("players.csv", "r");
    if (arq == 0)//null
        printf("\n Erro de leitura do arquivo");
    char stringtemp[300];
    fscanf(arq,"%[^\n]\n", stringtemp);
    int contpara = -1;
    bool para = false;
    Jogador tmp;
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
        if (id == valor)
        {
            para = true;
            tmp = Armazena(stringtemp);
        }
        fscanf(arq,"%[^\n]\n", stringtemp);
        contpara++;
    }while(!para && contpara < 3922); 
    fclose(arq);
    return tmp;
}

int lerIdIF(char str[])
{
    int tamtmp = strlen(str);
    char tmp[tamtmp - 3];
    int conttmp = 0;
    for (int i = 3; i < strlen(str);i++)
        tmp[conttmp] = str[i];
    int id = 0; 
    id = Trade(tmp);
    return id;
}

int lerIdPos(char str[])
{
    char tmp[strlen(str) - 3];
    int conttmp = 0;
    int contspace = 0;
    int j = 3;
    do
    {
        if (tmp[j++] == ' ')
            contspace++;
    }while (contspace != 1);
    for (int i = j; i < strlen(tmp);i++)
        tmp[conttmp] = str[i];
    int id = Trade(tmp);
    return id;
}

int lerPos(char str[])
{
    char tmp[strlen(str - 3)];
    int conttmp = 0;
    int i = 3;
    do
    {
        tmp[conttmp++] = str[i];
    }while(str[++i] != ' ');
    int pos = Trade(tmp);
    return pos;
}

int main()
{
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

    leitura(valores, cont);

    int noper = 0;
    fflush(stdin);
    scanf("%d", &noper);
    for(int i = 0;i < noper;i++)
    {
        char str[10];
        fflush(stdin);
        fgets(str, 10, stdin);
        str[strlen(str) - 1] = '\0';
        if(str[0] == 'I' && str[1] == 'I')
            InserirInicio(ler1elemento(lerIdIF(str)));
        else if(str[0] == 'I' && str[1] == 'F')
            InserirFim(ler1elemento(lerIdIF(str)));
        else if(str[0] == 'I' && str[1] == '*')
            Inserir(ler1elemento(lerIdPos(str)),lerPos(str));           
        else if(str[0] == 'R' && str[1] == 'I')
            InserirFimR(RemoverInicio());
        else if(str[0] == 'R' && str[1] == 'F')
            InserirFimR(RemoverFim());
        else
            InserirFimR(Remover(lerPos(str)));
    }

    for(int i = 0;i < nListaR;i++)
        ImprimirJogadorListaRemovidos(listaRemovidos[i]);

    for (int i = 0;i < nLista;i++)
    {
        printf("[%d]", i);
        ImprimirJogadorLista(lista[i]);
    }
    return 0;
}