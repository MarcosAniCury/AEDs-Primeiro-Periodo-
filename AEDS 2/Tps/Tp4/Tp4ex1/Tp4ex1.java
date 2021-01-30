import java.io.*;

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

    public void Inserir(Jogador elemento) throws Exception
    {
        n = 0;
        raiz = Inserir(elemento,raiz);
    }

    public No Inserir(Jogador elemento, No i) throws Exception
    {
        if (i == null)
        {
            i = new No(elemento);
            Tp4ex1.ncomparacoes++;
        }
        else if (elemento.Getnome().compareTo(i.elemento.Getnome()) < 0)
        {
            i.esq = Inserir(elemento,i.esq);
            Tp4ex1.ncomparacoes += 2;
        }
        else if (elemento.Getnome().compareTo(i.elemento.Getnome()) > 0)
        {
            i.dir = Inserir(elemento,i.dir);
            Tp4ex1.ncomparacoes += 3;
        }
        else
            throw new Exception("Erro ao inserir");
        n++;
        return i;
   }

   public void Pesquisa(String nome)
   {
       Pesquisa(nome,raiz);
   }

   public void Pesquisa(String nome, No i)
   {
        if (i == raiz)
            MyIO.print(" raiz");
        if (i != null && nome.equals(i.elemento.Getnome()))
            MyIO.println(" SIM");
        else if (i != null && nome.compareTo(i.elemento.Getnome()) < 0)
        {
            MyIO.print(" esq");
            Pesquisa(nome,i.esq);
        }
        else if (i != null && nome.compareTo(i.elemento.Getnome()) > 0)
        {
            MyIO.print(" dir");
            Pesquisa(nome,i.dir);
        }
        else
            MyIO.println(" NAO");
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

public class Tp4ex1
{
    //numero de comparacoes
    public static int ncomparacoes;

    public static void Armazena(String valores, ArvoreBinaria Inicial) throws Exception
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
        Inicial.Inserir(jogadortemp);
        jogadortemp = null;
    }

    public static void leitura(String link, ArvoreBinaria Inicial, String[] entrada, int nentrada) throws Exception
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
            System.err.printf("Nao foi possivel continuar essa acao");
            ex.getMessage();
        }
    }

    public static boolean isFim(String entrada)
    {
        boolean resp = false;
        if (entrada.equals("FIM"))
            resp = true;
        return resp;
    } 

    public static void CriacaoLog(int matricula, long tempexecuao) throws IOException
    {
        File log = new File("matricula_arvoreBinaria.txt");
        log.createNewFile();
        FileWriter arqlog = new FileWriter(log);
        BufferedWriter warqlog = new BufferedWriter(arqlog);
        warqlog.write(Integer.toString(matricula)+"\t"+Integer.toString(ncomparacoes)+"\t"+Long.toString(tempexecuao)+"s");
        warqlog.close();
        arqlog.close();
    }

    public static void main (String [] args) throws Exception
    {
        //tempo inicial
        long TempoInicial = System.currentTimeMillis();
        ncomparacoes = 0;
        String[] entrada = new String[4000];
        int Nentrada = 0;
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;
        ArvoreBinaria dados = new ArvoreBinaria();
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
            MyIO.print(entrada2[i]+" ");
            dados.Pesquisa(entrada2[i]);
        }
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