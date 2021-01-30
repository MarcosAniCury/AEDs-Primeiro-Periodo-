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

public class Tp2ex11
{
    static int ncomparacoes;
    static int nmovimentacoes;
    public static Jogador[] leitura(String link, String[] entrada, int nentrada)
    {
        Jogador[] NBA = new Jogador[nentrada];
        int nNBA = 0;
        int nexiste = 0;

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
                        NBA[nNBA] = Armazena(linha);
                        nNBA++;
                        armazenado = true;
                    }
                }while(Integer.parseInt(entrada[n]) > Integer.parseInt(id) && !armazenado);
                if (Integer.parseInt(entrada[n]) < Integer.parseInt(id))
                {
                    nexiste++;
                    Jogador[] temp = new Jogador[nentrada-nexiste];
                    for (int i=0;i<n;i++)
                        temp[i] = NBA[i].clone();
                    NBA = temp;
                    temp = null;
                }
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

    public static Jogador Armazena(String valores)
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
        return jogadortemp;
    }

    public static int getMaior(Jogador[] NBA,int nNBA) 
    {
        int maior = NBA[0].Getaltura();
        for (int i = 0; i < nNBA; i++) 
            if(maior < NBA[i].Getaltura())
                maior = NBA[i].Getaltura();
        return maior;	
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

    public static Jogador[] CountSort(Jogador[] NBA, int nNBA)
    {
        //Array para contar o numero de ocorrencias de cada elemento
        int[] count = new int[getMaior(NBA, nNBA) + 1];
        Jogador[] ordenado = new Jogador[nNBA];

        //Inicializar cada posicao do array de contagem 
        for (int i = 0; i < count.length; count[i] = 0, i++);

        //Agora, o count[i] contem o numero de elemento iguais a i
        for (int i = 0; i < nNBA; count[NBA[i].Getaltura()]++, i++);

        //Agora, o count[i] contem o numero de elemento menores ou iguais a i
        for(int i = 1; i < count.length; count[i] += count[i-1], i++);

        //Ordenando
        for(int i = nNBA-1; i >= 0;ordenado[count[NBA[i].Getaltura()]-1] = NBA[i].clone(), count[NBA[i].Getaltura()]--, i--);
        //Copiando para o array original
        for(int i = 0; i < nNBA; NBA[i] = ordenado[i].clone(),i++);
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
        File log = new File("matricula_Countingsort.txt");
        log.createNewFile();
        FileWriter arqlog = new FileWriter(log);
        BufferedWriter warqlog = new BufferedWriter(arqlog);
        warqlog.write(Integer.toString(matricula)+"\t"+Integer.toString(ncomparacoes)+"\t"+Integer.toString(nmovimentacoes)+"\t"+Long.toString(tempexecuao));
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
        int Nentrada = 0;
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;

        Jogador[] NBA = leitura("/tmp/players.csv", entrada,Nentrada);
        //ordenando por nome
        NBA = Selecao(NBA, NBA.length);
        //ordenando com base na altura
        Jogador[] NBAOrdenado = CountSort(NBA,NBA.length);

        for (int i = 0;i < NBAOrdenado.length;i++)
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