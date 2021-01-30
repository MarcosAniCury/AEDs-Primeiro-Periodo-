import java.io.*;

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
        MyIO.print("[");
        Lerid();
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
        MyIO.println("]");
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

class Celula
{
    public Jogador conteudo;
    public Celula prox;
    public Celula ant;

    public Celula() {}

    public Celula(Jogador conteudo)
    {
        this.conteudo = conteudo.clone();
        this.prox = this.ant = null;
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

class ListaDupla
{
    private Celula Inicio;
    private Celula Fim;

    public ListaDupla() {Inicio = new Celula(); Fim = Inicio;}

    public ListaDupla(Celula comeco)
    {
        Inicio = comeco;
        Fim = Inicio;
    }

    public void inserirFim (Jogador novo)
    {
        Fim.prox = new Celula(novo);
        Fim.prox.ant = Fim;
        Fim = Fim.prox;
    }

    public void inserirInicio (Jogador novo)
    {
        Celula tmp = new Celula(novo);
        tmp.prox = Inicio.prox;
        tmp.prox.ant = tmp;
        Inicio.prox = tmp;
        tmp.ant = Inicio;
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
            tmp.prox.ant = tmp;
            i.prox = tmp;
            tmp.ant = i;
            tmp = i = null;
        }
    }

    public Jogador removerInicio()
    {
        Jogador retorno;
        Inicio = Inicio.prox;
        Inicio.ant = null;
        retorno = Inicio.conteudo;

        return retorno;
    }

    public Jogador removerFim()
    {
        Jogador retorno = Fim.conteudo;
        Celula i = Fim;
        Fim = Fim.ant;
        i.ant = null;
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

    public static void sort() 
    {
        return quicksort(Inicio, Fim);
    }

    public static Jogador[] quicksort(Celula esq, Celula dir) 
    {
        Celula i = esq, j = dir;
        Celula tmpPivo = Inicio;
        for(int k = 0;)
        String pivo = NBA[(dir+esq)/2].GetestadoNascimento();
        while (i <= j) 
        {
            while (NBA[i].GetestadoNascimento().compareTo(pivo) < 0) 
                i++;
            while (NBA[j].GetestadoNascimento().compareTo(pivo) > 0) 
                j--;
            if (i <= j) 
            {
                Jogador temp = NBA[i].clone();
                NBA[i] = NBA[j];
                NBA[j] = temp;
                temp = null;
                i++;
                j--;
            }
        }
        if (esq < j)  
            NBA = quicksort(esq, j, NBA);
        if (i < dir)  
            NBA = quicksort(i, dir, NBA);
        return NBA;
    }
}

public class Tp3ex11
{
    static int ncomparacoes;
    static int nmovimentacoes;
    public static void leitura(String link, String[] entrada, int nentrada,ListaDupla lista)
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
                        Armazena(linha,lista);
                        armazenado = true;
                    }
                }while(Integer.parseInt(entrada[n]) > Integer.parseInt(id) && !armazenado);
                n++;
                larquivo.close();
                arquivo.close();
            }while (nNBA != nentrada && n != nentrada);
        }
        catch(IOException ex)
        {
            System.err.printf("Nao foi possivel continuar essa acao");
            ex.getMessage();
        }

        return NBA;
    }

    public static Jogador Armazena(String valores, ListaDupla lista)
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
        lista.inserirFim(jogadortemp);
    }

    public static Jogador[] Selecao(Jogador[] NBA, int nNBA)
    {
        for (int i = 0; i < (nNBA - 1); i++) 
        {
            String menor = NBA[i].Getnome();
            int nmenor = i;
            for (int j = (i + 1); j < nNBA; j++)
            {
                if (menor.compareTo(NBA[j].Getnome()) > 0)
                {
                    menor = NBA[j].Getnome();
                    nmenor = j;
                }
                ncomparacoes++;
            }
            Jogador temp = NBA[i].clone();
            NBA[i] = NBA[nmenor].clone();
            NBA[nmenor] = temp;
            nmovimentacoes += 3;
        }
        return NBA;
    }

    public static boolean isFim(String entrada)
    {
        boolean resp = false;
        if (entrada.equals("FIM"))
            resp = true;
        return resp;
    } 

    public static void Saida(boolean resp)
    {
        if(resp)
            MyIO.println("SIM");
        else
            MyIO.println("NAO");
    }

    public static void CriacaoLog(int matricula, long tempexecuao) throws IOException
    {
        File log = new File("matricula_quicksort.txt");
        log.createNewFile();
        FileWriter arqlog = new FileWriter(log);
        BufferedWriter warqlog = new BufferedWriter(arqlog);
        warqlog.write(Integer.toString(matricula)+","+Integer.toString(ncomparacoes)+","+Integer.toString(nmovimentacoes)+","+Long.toString(tempexecuao)+"s");
        warqlog.close();
        arqlog.close();
    }

    public static void main(String [] args)
    {
        long TempoInicial = System.currentTimeMillis();
        //entrada dos ids a serem lidos
        ncomparacoes = 0;
        nmovimentacoes = 0;
        String[] entrada = new String[4000];
        int k = MyIO.readInt();
        int Nentrada = 0;
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;

        ListaDupla lista = new ListaDupla();
        leitura("players.csv", entrada,Nentrada,lista);
        //ordenar por estado
        sort(lista);
        for (i = 0;i < k;i++)
            NBAOrdenado[i].Imprimir();

        try
        {
            CriacaoLog(684903, System.currentTimeMillis() - TempoInicial);
        }
        catch (IOException erro)
        {
            System.err.println("Erro nao foi possivel criar o log do arquivo");
        }
    }
}