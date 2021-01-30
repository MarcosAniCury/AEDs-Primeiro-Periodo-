import java.io.*;

class HashReserva 
{
    Jogador tabela[];
    HashRhash reserva1;
    ListaDinamica reserva2;
    ArvoreBinaria reserva3;
    int tamTab, reserva;
    Jogador NULO = new Jogador();

    public HashReserva()
    {
        this(11,3);
    }

    public HashReserva(int tamTab, int tamReserv)
    {
        this.tamTab = tamTab;
        reserva = 0;
        this.tabela = new Jogador[tamTab];
        reserva1 = new HashRhash(9);
        reserva2 = new ListaDinamica();
        reserva3 = new ArvoreBinaria();
        NULO.Setnome("NULO");
        for(int i = 0; i < tamTab; i++)
            tabela[i] = NULO;
    }

    public int htab(int elemento)
    {
        return elemento % tamTab;
    }

    public int hres(int elemento)
    {
        return elemento % 3;
    }

    public boolean inserir(Jogador elemento)
    {
        boolean resp = false;

        if(elemento != NULO)
        {
            int pos = htab(elemento.Getaltura());

            if(tabela[pos] == NULO)
            {
                tabela[pos] = elemento;
                resp = true;
            } 
            else
            {
                pos = hres(elemento.Getaltura());
                switch(pos)
                {
                    case 0: if(!reserva1.isFull())
                            {
                                reserva1.inserir(elemento);
                                break;
                            }
                    case 1: reserva2.inserirFim(elemento);
                            break;
                    case 2: reserva3.Inserir(elemento);
                            break;
                    default: break;
                }
            }
        }

        return resp;
    }

    public boolean pesquisar(String elemento)
    {
        boolean resp = false;

        for(int i = 0;i < tamTab;i++)
        {
            if(tabela[i].Getnome().equals(elemento))
                resp = true;
        }
        if(!resp && (reserva1.pesquisar(elemento) || reserva2.pesquisar(elemento) || reserva3.Pesquisa(elemento)))
            resp = true;
        return resp;
    }

    public int Getn()
    {
        return tamTab;
    }
}

class HashRhash
{
    Jogador tabela[];
    int n;
    Jogador NULO = new Jogador();

    public HashRhash()
    {
        this(25);
    }

    public HashRhash(int n)
    {
        this.n = n;
        this.tabela = new Jogador[this.n];
        NULO.Setnome("NULO");
        for(int i = 0; i < n; i++)
            tabela[i] = NULO;
    }

    public int h(int elemento)
    {
        return elemento % n;
    }

    public int reh(int elemento)
    {
        return ++elemento % n;
    }

    public boolean inserir(Jogador elemento)
    {
        boolean resp = false;

        if(elemento != NULO)
        {
            int pos = h(elemento.Getaltura());

            if(tabela[pos] == NULO)
            {
                tabela[pos] = elemento;
                resp = true;
            } 
            else 
            {
                pos = reh(elemento.Getaltura());
                if(tabela[pos] == NULO)
                {
                    tabela[pos] = elemento;
                    resp = true;
                }      
            }
        }

        return resp;
    }

    public boolean pesquisar(String elemento)
    {
        boolean resp = false;

        for(int i = 0;i < n;i++)
        {
            if(tabela[i].Getnome().equals(elemento))
                resp = true;
        }
        return resp;
    }

    public boolean isFull()
    {
        boolean isfull = true;
        for(int i = 0;i < n;i++)
        {
            if (tabela[i] != NULO)
            {
                isfull = false;
                i = n;
            }
        }
        return isfull;
    }

    public int Getn()
    {
        return n;
    }
}

class Celula
{
    public Jogador conteudo;
    public Celula prox;

    public Celula() {}
    
    public Celula(Celula prox)
    {
        this.prox = prox;
    }

    public Celula(Jogador conteudo)
    {
        this.conteudo = conteudo.clone();
        this.prox = null;
    }

    public Celula(Jogador conteudo, Celula prox)
    {
        this.prox = prox;
        this.conteudo = conteudo;
    }

    public Celula clone()
    {
        Celula clone = new Celula();
        clone.conteudo = this.conteudo;
        if (prox != null)
            clone.prox = this.prox.clone();
        else
            clone.prox = null;
        return clone;
    }
}

class ListaDinamica
{
    private Celula Inicio;
    private Celula Fim;

    public ListaDinamica() {Inicio = new Celula(); Fim = Inicio;}

    public ListaDinamica(Celula comeco)
    {
        Inicio = comeco;
        Fim = Inicio;
    }

    public void inserirFim (Jogador novo)
    {
        Fim.prox = new Celula(novo);
        Fim = Fim.prox;
    }

    public void inserirInicio (Jogador novo)
    {
        Celula tmp = new Celula(novo);
        tmp.prox = Inicio.prox;
        Inicio.prox = tmp;
        if (Inicio == Fim)
            Fim = tmp;
        tmp = null;
    }

    public void inserir (Jogador novo, int pos)
    {
        if(pos < 0 || pos > tamanho())
            MyIO.println("Erro ao inserir posicao invalida");
        else if (pos == 0)
            inserirInicio(novo);
        else if (pos == tamanho() - 1)
            inserirFim(novo);
        else
        {
            Celula i = Inicio;
            for(int j = 0;j < pos;j++, i = i.prox);

            Celula tmp = new Celula(novo);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    public Jogador removerInicio()
    {
        Jogador retorno;
        Inicio = Inicio.prox;
        retorno = Inicio.conteudo;

        return retorno;
    }

    public Jogador removerFim()
    {
        Jogador retorno = Fim.conteudo;
        Celula i = Inicio;
        for(;i.prox != Fim;i = i.prox);
        Fim = i;
        Fim.prox = i = null;
        return retorno;
    }

    public Jogador remover(int pos)
    {
        Jogador retorno = new Jogador();
        if (pos == 0)
            retorno = removerInicio();
        else if (pos == tamanho() - 1)
            retorno = removerFim();
        else if (pos < 0 || pos > tamanho())
            MyIO.println("Posicao invalida");
        else
        {
            Celula i = Inicio;
            for(int j = 0;j < pos;j++, i = i.prox);

            retorno = i.prox.conteudo;
            i.prox = i.prox.prox;
            i = null;
        }
        return retorno;
    }

    public int tamanho()
    {
        int tamanho = 0;
        for(Celula i = Inicio;i != Fim; i = i.prox,tamanho++);
        return tamanho;
    }
    

    public void MostrarLista(boolean notRemovidos)
    {
        if(notRemovidos)
        {
            int i = 0;
            for(Celula j = Inicio.prox; j != null; j = j.prox, i++)
            {
                MyIO.print("["+i+"]");
                j.conteudo.Imprimir();
                MyIO.println();
            }
        }
        else
        {
            for (Celula i = Inicio.prox; i != null; i = i.prox)
                MyIO.println("(R) "+i.conteudo.Getnome());
        }
    }

    public boolean pesquisar(String elemento)
    {
        boolean existe = false;
        for(Celula i = Inicio.prox; i != null; i = i.prox)
        {
            if(i.conteudo.Getnome().equals(elemento))
            {
                existe = true;
                i = Fim;
            }
        }
        return existe;
    }
}

class No
{
    public Jogador elemento;
    public No esq,dir;

    public No() {esq = dir = null;}

    public No(Jogador elemento)
    {
        this.elemento = elemento;
    }
}

class ArvoreBinaria
{
    private No raiz;
    private int n;

    public ArvoreBinaria() {raiz = null;n = 0;}

    public void Inserir(Jogador elemento)
    {
        n = 0;
        raiz = Inserir(elemento,raiz);
    }

    public No Inserir(Jogador elemento, No i)
    {
        try
        {
            if (i == null)
                i = new No(elemento);
            else if (elemento.Getnome().compareTo(i.elemento.Getnome()) < 0)
                i.esq = Inserir(elemento,i.esq);
            else if (elemento.Getnome().compareTo(i.elemento.Getnome()) > 0)
                i.dir = Inserir(elemento,i.dir);
            else
                throw new IOException("Erro ao inserir");
            n++;
        }
        catch(IOException erro)
        {
            erro.printStackTrace();
        }
        return i;
   }

    public boolean Pesquisa(String nome)
    {
       return Pesquisa(nome,raiz);
    }

    public boolean Pesquisa(String nome, No i)
    {
        boolean existe = false;
        if (i == raiz)
            MyIO.print(" raiz");
        if (i != null && nome.equals(i.elemento.Getnome()))
            existe = true;
        else if (i != null && nome.compareTo(i.elemento.Getnome()) < 0)
        {
            MyIO.print(" esq");
            existe = Pesquisa(nome,i.esq);
        }
        else if (i != null && nome.compareTo(i.elemento.Getnome()) > 0)
        {
            MyIO.print(" dir");
            existe = Pesquisa(nome,i.dir);
        }
        return existe;
    }

    public int Getn()
    {
        return n;
    }
}

class Jogador
{
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {}

    public Jogador(int idjogador)
    {
        Setid(idjogador);
    }

    //SETS
    
    public void Setid(int id)
    {
        this.id = id;
    }

    public void Setnome(String nome)
    {
        this.nome = nome;
    }

    public void Setaltura(int altura)
    {
        this.altura = altura;
    }

    public void Setpeso(int peso)
    {
        this.peso = peso;
    }

    public void Setuniversidade(String universidade)
    {
        this.universidade = universidade;
    }

    public void SetanoNascimento(int anoNascimento)
    {
        this.anoNascimento = anoNascimento;
    }

    public void SetcidadeNascimento(String cidadeNascimento)
    {
        this.cidadeNascimento = cidadeNascimento;
    }

    public void SetestadoNascimento(String estadoNascimento)
    {
        this.estadoNascimento = estadoNascimento;
    }

    //GETS

    public int Getid()
    {
        return this.id;
    }

    public String Getnome()
    {
        return this.nome;
    }

    public int Getaltura()
    {
        return this.altura;
    }

    public int Getpeso()
    {
        return this.peso;
    }

    public String Getuniversidade()
    {
        return this.universidade;
    }

    public int GetanoNascimento()
    {
        return this.anoNascimento;
    }

    public String GetcidadeNascimento()
    {
        return this.cidadeNascimento;
    }

    public String GetestadoNascimento()
    {
        return this.estadoNascimento;
    }

    //Ler

    public void Lerid()
    {
        MyIO.print(this.id);
    }

    public void Lernome()
    {
        MyIO.print(this.nome);
    }

    public void Leraltura()
    {
        MyIO.print(this.altura);
    }

    public void Lerpeso()
    {
        MyIO.print(this.peso);
    }

    public void Leruniversidade()
    {
        MyIO.print(this.universidade);
    }

    public void LeranoNascimento()
    {
        MyIO.print(this.anoNascimento);
    }

    public void LercidadeNascimento()
    {
        MyIO.print(this.cidadeNascimento);
    }

    public void LerestadoNascimento()
    {
        MyIO.print(this.estadoNascimento);
    }

    public void Imprimir()
    {
        MyIO.print(" ## ");
        Lernome();
        MyIO.print(" ## ");
        Leraltura();
        MyIO.print(" ## ");
        Lerpeso();
        MyIO.print(" ## ");
        LeranoNascimento();
        MyIO.print(" ## ");
        Leruniversidade();
        MyIO.print(" ## ");
        LercidadeNascimento();
        MyIO.print(" ## ");
        LerestadoNascimento();
        MyIO.println(" ##");
    }

    public Jogador clone()
    {
        Jogador copia = new Jogador();
        copia.Setid(this.id);
        copia.Setnome(this.nome);
        copia.Setaltura(this.altura);
        copia.Setpeso(this.peso);
        copia.Setuniversidade(this.universidade);
        copia.SetanoNascimento(this.anoNascimento);
        copia.SetcidadeNascimento(this.cidadeNascimento);
        copia.SetestadoNascimento(this.estadoNascimento);
        return copia;
    }
}

public class Tp5ex4
{
    public static void Armazena(String valores, HashReserva Inicial)
    {
        String[] aux = new String[8];
        String[] aux2 = new String[8];
        //Dividir a String em aux2 aonde tem virgula
        aux2 = valores.split(",");
        for (int i = 0;i < 8;aux[i++] = "");
        //atribuir a aux o vetor aux2 sendo que quando o campo esta vazio se mantem o valor atribuido anterior mente a aux
        for (int i = 0;i < aux2.length;aux[i] = aux2[i++]);
        Jogador jogadortemp = new Jogador();
        //armazenamento dos valores em jogadortemp
        jogadortemp.Setid(Integer.parseInt(aux[0]));
        if (aux[1].equals(""))
            jogadortemp.Setnome("nao informado");
        else
            jogadortemp.Setnome(aux[1]);
        jogadortemp.Setaltura(Integer.parseInt(aux[2]));
        jogadortemp.Setpeso(Integer.parseInt(aux[3]));
        if (aux[4].equals(""))
            jogadortemp.Setuniversidade("nao informado");
        else    
            jogadortemp.Setuniversidade(aux[4]);
        jogadortemp.SetanoNascimento(Integer.parseInt(aux[5]));
        if (aux[6].equals(""))
            jogadortemp.SetcidadeNascimento("nao informado");
        else
            jogadortemp.SetcidadeNascimento(aux[6]);
        if (aux[7].equals(""))
            jogadortemp.SetestadoNascimento("nao informado");
        else
            jogadortemp.SetestadoNascimento(aux[7]);
        Inicial.inserir(jogadortemp);
        jogadortemp = null;
    }

    public static void leitura(String link, HashReserva Inicial, String[] entrada, int nentrada)
    {
        try
        {
            int n = 0;
            do
            {
                //abertura do players.csv
                FileReader arquivo = new FileReader(link);
                BufferedReader larquivo = new BufferedReader(arquivo);
                //pegar de linha em linha pulando a primeira linha do arquivo
                String linha = larquivo.readLine();
                //enviar string por string para a Armazena, manipular e armazenar
                boolean armazenado = false;
                //armazena os ids de forma ordenada no vetor
                String id = "";
                do
                {
                    //verificar se o id da linha e um dos ids selecionados na entrada
                    linha = larquivo.readLine();
                    id = linha.substring(0,linha.indexOf(","));
                    if(entrada[n].equals(id))
                    {
                        Armazena(linha, Inicial);
                        armazenado = true;
                    }
                }while(Integer.parseInt(entrada[n]) > Integer.parseInt(id) && !armazenado);
                n++;
                larquivo.close();
                arquivo.close();
            }while (Inicial.Getn() != nentrada && n != nentrada);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static boolean isFim(String entrada)
    {
        boolean resp = false;
        if (entrada.equals("FIM"))
            resp = true;
        return resp;
    } 

    public static void main (String [] args)
    {
        String[] entrada = new String[4000];
        int Nentrada = 0;
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;
        HashReserva dados = new HashReserva();
        leitura("/tmp/players.csv", dados, entrada, Nentrada);
        String[] entrada2 = new String[4000];
        int Nentrada2 = 0;
        do
        {
            entrada2[Nentrada2] = MyIO.readLine();
        }while(!isFim(entrada2[Nentrada2++]));
        Nentrada2--;
        for(int i = 0;i < Nentrada2;i++)
        {
            MyIO.print(entrada2[i]);
            if (dados.pesquisar(entrada2[i]))
                MyIO.println(" SIM");
            else
                MyIO.println(" NAO");
        }
    }
}