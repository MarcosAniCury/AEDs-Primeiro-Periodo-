#include <iostream>
#include <string>
#include <stdbool.h>

using namespace std;
const int MAX = 100;
int TAM = 0;

class Agenda
{
    private:
        int dia;
        int mes;
        string nome;
    public:
        Agenda(){}
        void SetDia(int dia)
        {
            this->dia = dia;
        }
        void SetMes(int mes)
        {
            this->mes = mes;
        }
        void SetNome(string nome)
        {
            this->nome = nome;
        }
        string GetNome()
        {
            return this->nome;
        }
        int GetMes()
        {
            return this->mes;
        }
};

void Menu();
void CadastroUser(Agenda User[]);

int main()
{
    Agenda *User[MAX];
    int menu;
    int dia;
    int mes;
    int mesdigitado;
    string nome;
    cout << "Bem vindo, Algoritmo de agenda.";
    bool ero = 1;
    do
    {
        Menu();
        cin >> menu;
        switch(menu)
        {
            case 0: ero = 0;
                break;
            case 1:User[TAM] = new Agenda();
                CadastroUser(User[TAM]);
                TAM++;
                break;
            case 2:for (int cont = 0;cont != MAX;cont++)
                    {
                        cout << "Digite o mes q vc deseja obter os aniversariante";
                        do
                        {
                            cin >> mesdigitado;
                            ero = mesdigitado > 0 && mesdigitado < 13;
                            if (!ero)
                                cout << "Valor invalido, digite novamente";
                        }while (!ero);
                        if(User[cont]->GetMes() == mesdigitado)
                            cout << endl << User[cont]->GetNome;
                    }
                break;
            default:cout << "\n Valor invalido digite novamente.";
        }
    }while (ero);
    return 0;
}

void Menu()
{
    cout << endl << "Escolha uma das opcoes do menu abaixo:" << endl << "0-Sair do programa" << endl << "1-Cadastrar um novo usuario" << endl << "2-Verificar aniversariantes do mes" << endl <<"Digite a opcao desejada:";
}

void CadastroUser(Agenda User[])
{
    int dia;
    int mes;
    string nome;
    cout << endl << "Digite o nome do usuario:";
    cin >> nome;
    User->SetNome(nome);
    bool ero;
    do
    {
        cout << "Digite o dia de nascimento:";
        cin >> dia;
        ero = dia > 0 && dia < 32;
        if (!ero)
            cout << endl << "Valor invalido, digite novamente \n";
    }while(!ero);
    User->SetDia(dia);
    do
    {
        cout << "Digite o mes de nascimento:";
        cin >> mes;
        ero = mes > 0 && mes < 13;
        if (!ero)
            cout << endl << "Valor invalido, digite novamente \n";
    }while(!ero);
    User->SetMes(mes);
}
