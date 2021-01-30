import java.io.*;

class No 
{
    public char elemento;
    public int tamanho = 255;
    public No[] prox;
    public boolean folha;
    
    public No ()
    {
       this(' ');
    }
 
    public No (char elemento)
    {
       this.elemento = elemento;
       prox = new No [tamanho];
       for (int i = 0; i < tamanho; i++) prox[i] = null;
       folha = false;
    }
 
    public static int hash (char x)
    {
       return (int)x;
    }
}
 

class ArvoreTrie
{
    private No raiz;
    private int n;

    public ArvoreTrie() 
    {
        raiz = new No();
        n = 0;
    }

    public void inserir(String s)
    {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i)
    {
        try
        {
            if(no.prox[s.charAt(i)] == null)
            {
                no.prox[s.charAt(i)] = new No(s.charAt(i));

                if(i == s.length() - 1)
                    no.prox[s.charAt(i)].folha = true;
                else
                    inserir(s, no.prox[s.charAt(i)], i + 1);
                Tp4ex6.ncomparacoes += 2;
            } 
            else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1)
            {
                Tp4ex6.ncomparacoes += 2;
                inserir(s, no.prox[s.charAt(i)], i + 1);
            }
            else 
                throw new Exception("Erro ao inserir!");
            Tp4ex6.ncomparacoes++;
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
        } 
    }

    public void inserirNaArvore(ArvoreTrie dados)
    {
        inserirNaArvore("", raiz, dados);
    }

    public void inserirNaArvore(String s, No no, ArvoreTrie dados) 
    {
        if(no.folha == true)
            dados.inserir(s+no.elemento);
        else 
        {
            for(int i = 0; i < no.prox.length; i++)
            {
                if(no.prox[i] != null)
                    inserirNaArvore(s + no.elemento, no.prox[i],dados);
                Tp4ex6.ncomparacoes += 2;
            }
        }
        Tp4ex6.ncomparacoes++;
    }

    public boolean pesquisar(String s)
    {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i)
    {
        boolean resp = false;
        try
        {
            if(no.prox[s.charAt(i)] == null)
            {
                resp = false;
                Tp4ex6.ncomparacoes++;
            }
            else if(i == s.length() - 1)
            {
                resp = (no.prox[s.charAt(i)].folha == true);
                Tp4ex6.ncomparacoes += 2;
            }
            else if(i < s.length() - 1)
            {
                resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
                Tp4ex6.ncomparacoes += 3;
            }
            else
                throw new Exception("Erro ao pesquisar!");
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
        }
        return resp;
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

public class Tp4ex6
{
    //numero de comparacoes
    public static int ncomparacoes;

    public static void Armazena(String valores, ArvoreTrie Inicial) throws Exception
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
        Inicial.inserir(jogadortemp.Getnome());
        MyIO.println(jogadortemp.Getid()+"\t"+jogadortemp.Getnome());
        jogadortemp = null;
    }

    public static void leitura(String link, ArvoreTrie Inicial, String[] entrada, int nentrada) throws Exception
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

    public static void CriacaoLog(int matricula, long tempexecuao) throws IOException
    {
        File log = new File("matricula_arvoreTrie.txt");
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

        //criacao e preenchimento da arvore
        ArvoreTrie dados = new ArvoreTrie();
        leitura("players.csv", dados, entrada, Nentrada);

        String[] entrada2 = new String[4000];
        int Nentrada2 = 0;
        do
        {
            entrada2[Nentrada2] = MyIO.readLine();
        }while(!isFim(entrada2[Nentrada2++]));
        Nentrada2--;

        //criacao e preenchimento da arvore
        ArvoreTrie dados2 = new ArvoreTrie();
        leitura("players.csv", dados2, entrada2, Nentrada2);

        String[] entrada3 = new String[4000];
        int Nentrada3 = 0;
        do
        {
            entrada3[Nentrada3] = MyIO.readLine();
        }while(!isFim(entrada3[Nentrada3++]));
        Nentrada3--;

        //insere todas as palavras da arvore 2 na 1
        dados2.inserirNaArvore(dados);

        for(int i = 0;i < Nentrada3;i++)
        {
            MyIO.print(entrada3[i]+" ");
            if(dados.pesquisar(entrada3[i]))
                MyIO.println("SIM");
            else
                MyIO.println("NAO");
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